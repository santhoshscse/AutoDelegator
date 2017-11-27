package com.swiggy.allocator.handler;

import java.util.HashMap;
import java.util.List;

import com.swiggy.allocator.model.OrderAssignment;
import com.swiggy.allocator.model.OrderAssignmentInput;

public interface WeightageHandler {
	public HashMap<OrderAssignment, Integer> addWeightage(OrderAssignmentInput orderInput,
			List<OrderAssignment> assignmentCombination);
}
