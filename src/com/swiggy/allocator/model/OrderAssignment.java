package com.swiggy.allocator.model;

public class OrderAssignment {
	private String orderId;
	private String deId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeId() {
		return deId;
	}

	public void setDeId(String deId) {
		this.deId = deId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderAssignment [orderId=");
		builder.append(orderId);
		builder.append(", deId=");
		builder.append(deId);
		builder.append("]");
		return builder.toString();
	}

}
