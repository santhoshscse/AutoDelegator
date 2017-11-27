package com.swiggy.allocator.model;

public class Order {
	private Location restLoc;
	private long orderTime;
	private String orderId;
	private DeliveryStatus status = DeliveryStatus.NotAssigned;

	public Location getRestLoc() {
		return restLoc;
	}

	public void setRestLoc(Location restLoc) {
		this.restLoc = restLoc;
	}

	public long getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

}
