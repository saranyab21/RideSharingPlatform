package com.rideManagement.model.DTOs;

public class SearchDTO {
	private String from;
	private String to;
	private Integer minPrice;
	private Integer maxPrice;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	@Override
	public String toString() {
		return "SearchDTO [from=" + from + ", to=" + to + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
}
