package com.swiggy.allocator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OrderAssignmentInput {
	private HashMap<String, Order> orderMap = new HashMap<>();
	private HashMap<String, DeliveryExecutive> deMap = new HashMap<>();

	public OrderAssignmentInput(List<Order> orderList, List<DeliveryExecutive> deList) {

		for (Order order : orderList) {
			orderMap.put(order.getOrderId(), order);
		}

		for (DeliveryExecutive de : deList) {
			deMap.put(de.getDeId(), de);
		}

	}

	public Set<String> getOrders() {
		return orderMap.keySet();
	}

	public Set<String> getDEs() {
		return deMap.keySet();
	}

	public Order getOrder(String orderId) {
		return orderMap.get(orderId);
	}

	public DeliveryExecutive getDE(String deId) {
		return deMap.get(deId);
	}

	public void removeOrder(String orderId) {
		orderMap.remove(orderId);
	}

	public void removeDE(String deId) {
		deMap.remove(deId);
	}
}
