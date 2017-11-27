package com.swiggy.allocator;

import java.util.List;

import com.swiggy.allocator.handler.WeightageHandlerImpl;
import com.swiggy.allocator.model.DeliveryExecutive;
import com.swiggy.allocator.model.Order;
import com.swiggy.allocator.model.OrderAssignment;
import com.swiggy.allocator.model.OrderAssignmentInput;

public class AutoAssigner {
	private WeightageHandlerImpl weightageHandlerImpl = new WeightageHandlerImpl();

	public List<OrderAssignment> getAssignmentList(List<Order> orderList, List<DeliveryExecutive> deList) {

		OrderAssignmentInput orderInput = new OrderAssignmentInput(orderList, deList);
		return weightageHandlerImpl.getAssignmentList(orderInput);

	}
}
