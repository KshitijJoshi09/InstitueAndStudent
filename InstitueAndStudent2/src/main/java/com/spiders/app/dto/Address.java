package com.spiders.app.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private String street;
	private String pinCode;
	private String state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", pinCode=" + pinCode + ", state=" + state + "]";
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String street, String pinCode, String state) {
		super();
		this.city = city;
		this.street = street;
		this.pinCode = pinCode;
		this.state = state;
	}

}
