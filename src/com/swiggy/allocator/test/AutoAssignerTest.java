package com.swiggy.allocator.test;

import java.util.ArrayList;
import java.util.List;

import com.swiggy.allocator.AutoAssigner;
import com.swiggy.allocator.model.DeliveryExecutive;
import com.swiggy.allocator.model.Location;
import com.swiggy.allocator.model.Order;
import com.swiggy.allocator.model.OrderAssignment;

public class AutoAssignerTest {
	public static void main(String[] args) {
		List<Order> orderList = new ArrayList<>();
		List<DeliveryExecutive> deList = new ArrayList<>();

		orderList.add(getOrderExample1());
		orderList.add(getOrderExample2());
		
		deList.add(getDEExample());
//		deList.add(getDEExample1());

		AutoAssigner assigner = new AutoAssigner();
		List<OrderAssignment> list = assigner.getAssignmentList(orderList, deList);
		System.out.println(list);
	}

	private static DeliveryExecutive getDEExample1() {
		DeliveryExecutive de = new DeliveryExecutive();
		de.setDeId("100");
		Location restLoc = new Location();
		restLoc.setLongitude(1000l);
		restLoc.setLatitude(1000l);
		de.setCurrLoc(restLoc);
		de.setLastDeliveryTime(System.currentTimeMillis());
		return de;
	}
	
	private static DeliveryExecutive getDEExample() {
		DeliveryExecutive de = new DeliveryExecutive();
		de.setDeId("200");
		Location restLoc = new Location();
		restLoc.setLongitude(2000l);
		restLoc.setLatitude(2000l);
		de.setCurrLoc(restLoc);
		de.setLastDeliveryTime(System.currentTimeMillis());
		return de;
	}

	private static Order getOrderExample1() {
		Order order = new Order();
		order.setOrderId("xyz1");
		order.setOrderTime(System.currentTimeMillis());
		Location restLoc = new Location();
		restLoc.setLongitude(100l);
		restLoc.setLatitude(100l);
		order.setRestLoc(restLoc);
		return order;
	}
	
	private static Order getOrderExample2() {
		Order order = new Order();
		order.setOrderId("xyz2");
		order.setOrderTime(System.currentTimeMillis());
		Location restLoc = new Location();
		restLoc.setLongitude(200l);
		restLoc.setLatitude(200l);
		order.setRestLoc(restLoc);
		return order;
	}
}
