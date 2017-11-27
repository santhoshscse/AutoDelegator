package com.swiggy.allocator.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.swiggy.allocator.model.OrderAssignment;
import com.swiggy.allocator.model.OrderAssignmentInput;

public class WeightageHandlerImpl {

	private static List<WeightageHandler> handlerList = new ArrayList<>();

	public WeightageHandlerImpl() {
		handlerList.add(new DistanceHandler());
	}

	public List<OrderAssignment> getAssignmentList(OrderAssignmentInput orderInput) {

		List<OrderAssignment> combinationList = getCombinationList(orderInput);
		HashMap<OrderAssignment, Integer> orderAssignmentWeightMap = new HashMap<>();

		for (WeightageHandler wh : handlerList) {
			HashMap<OrderAssignment, Integer> tmpWeightMap = wh.addWeightage(orderInput, combinationList);
			for (OrderAssignment orderAssignment : tmpWeightMap.keySet()) {
				Integer existWeight = orderAssignmentWeightMap.get(orderAssignment);
				if (existWeight != null) {
					orderAssignmentWeightMap.put(orderAssignment,
							existWeight.intValue() + tmpWeightMap.get(orderAssignment).intValue());
				} else {
					orderAssignmentWeightMap.put(orderAssignment, tmpWeightMap.get(orderAssignment).intValue());
				}
			}
		}

		Map<OrderAssignment, Integer> sortedMap = sortBasedOnWeightage(orderAssignmentWeightMap);

		List<OrderAssignment> retList = new ArrayList<>();
		for (Map.Entry<OrderAssignment, Integer> entry : sortedMap.entrySet()) {
			OrderAssignment orderAssignment = entry.getKey();
			String orderId = orderAssignment.getOrderId();
			String deId = orderAssignment.getDeId();
			if (orderInput.getOrder(orderId) != null && orderInput.getDE(deId) != null) {
				retList.add(orderAssignment);
				orderInput.removeOrder(orderId);
				orderInput.removeDE(deId);
			}
		}
		return retList;
	}

	private static Map<OrderAssignment, Integer> sortBasedOnWeightage(
			HashMap<OrderAssignment, Integer> orderAssignmentWeightMap) {
		List<Map.Entry<OrderAssignment, Integer>> list = new LinkedList<Map.Entry<OrderAssignment, Integer>>(
				orderAssignmentWeightMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<OrderAssignment, Integer>>() {
			public int compare(Map.Entry<OrderAssignment, Integer> o1, Map.Entry<OrderAssignment, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<OrderAssignment, Integer> result = new LinkedHashMap<OrderAssignment, Integer>();
		for (Map.Entry<OrderAssignment, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	private static List<OrderAssignment> getCombinationList(OrderAssignmentInput orderInput) {
		List<OrderAssignment> orderCombinationList = new ArrayList<>();

		for (String orderId : orderInput.getOrders()) {

			for (String deId : orderInput.getDEs()) {
				OrderAssignment orderAssignment = new OrderAssignment();
				orderAssignment.setOrderId(orderId);
				orderAssignment.setDeId(deId);
				orderCombinationList.add(orderAssignment);
			}
		}
		return orderCombinationList;
	}
}
