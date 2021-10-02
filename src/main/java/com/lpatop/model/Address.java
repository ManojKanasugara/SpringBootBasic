package com.lpatop.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String country;
	private String state;
	private String dist;
	private String taluqa;
	private String village;
	private int pinCode;
	private String landMark;

	@ManyToOne()
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonIgnore
	private Customer customer;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String country, String state, String dist, String taluqa, String village, int pinCode,
			String landMark) {
		super();
		this.country = country;
		this.state = state;
		this.dist = dist;
		this.taluqa = taluqa;
		this.village = village;
		this.pinCode = pinCode;
		this.landMark = landMark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getTaluqa() {
		return taluqa;
	}

	public void setTaluqa(String taluqa) {
		this.taluqa = taluqa;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", state=" + state + ", dist=" + dist + ", taluqa="
				+ taluqa + ", village=" + village + ", pinCode=" + pinCode + ", landMark=" + landMark + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(village);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(village, other.village);
	}
	
	
	

}
