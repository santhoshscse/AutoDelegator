package com.swiggy.allocator.handler;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.swiggy.allocator.model.OrderAssignment;
import com.swiggy.allocator.model.OrderAssignmentInput;
import com.swiggy.allocator.util.DistanceUtil;

public class DistanceHandler implements WeightageHandler {

	@Override
	public HashMap<OrderAssignment, Integer> addWeightage(OrderAssignmentInput orderInput,
			List<OrderAssignment> assignmentCombination) {
		Collections.sort(assignmentCombination, new Comparator<OrderAssignment>() {

			@Override
			public int compare(OrderAssignment o1, OrderAssignment o2) {
				long distance1 = DistanceUtil.getDistance(orderInput.getOrder(o1.getOrderId()).getRestLoc(),
						orderInput.getDE(o1.getDeId()).getCurrLoc());
				long distance2 = DistanceUtil.getDistance(orderInput.getOrder(o2.getOrderId()).getRestLoc(),
						orderInput.getDE(o2.getDeId()).getCurrLoc());
				if (distance1 > distance2) {
					return 1;
				} else if (distance1 < distance2) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		OrderAssignment maxOrderAssignment = assignmentCombination.get(0);
		long max = DistanceUtil.getDistance(orderInput.getOrder(maxOrderAssignment.getOrderId()).getRestLoc(),
				orderInput.getDE(maxOrderAssignment.getDeId()).getCurrLoc());

		HashMap<OrderAssignment, Integer> retMap = new HashMap<>();
		for (OrderAssignment orderAssignment : assignmentCombination) {
			long tmp = DistanceUtil.getDistance(orderInput.getOrder(orderAssignment.getOrderId()).getRestLoc(),
					orderInput.getDE(orderAssignment.getDeId()).getCurrLoc());

			System.out.println(tmp);
			retMap.put(orderAssignment, (int) (100 - ((max - tmp) / max * 100)));
		}

		System.out.println(retMap);
		return retMap;
	}

}
