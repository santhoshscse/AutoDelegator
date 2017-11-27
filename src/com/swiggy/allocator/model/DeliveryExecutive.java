package com.swiggy.allocator.model;

public class DeliveryExecutive {
	private String deId;
	private Location currLoc;
	private long lastDeliveryTime;
	private boolean availability;

	public String getDeId() {
		return deId;
	}

	public void setDeId(String deId) {
		this.deId = deId;
	}

	public Location getCurrLoc() {
		return currLoc;
	}

	public void setCurrLoc(Location currLoc) {
		this.currLoc = currLoc;
	}

	public long getLastDeliveryTime() {
		return lastDeliveryTime;
	}

	public void setLastDeliveryTime(long lastDeliveryTime) {
		this.lastDeliveryTime = lastDeliveryTime;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}
