package com.lpatop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String serialNumber;
	private String processor;
	private int ram;
	
	@ManyToMany()
	@JoinTable(name = "laptop_storageType", 
	joinColumns =@JoinColumn(name="laptop_id"),
	inverseJoinColumns = @JoinColumn(name="storageType_id"))
	private List<StorageType> storageType =new ArrayList<>() ;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop( String serialNumber, String processor, int ram) {
		super();
		
		this.serialNumber = serialNumber;
		this.processor = processor;
		this.ram = ram;
			}
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public List<StorageType> getStorageType() {
		return storageType;
	}
	public void setStorageType(ArrayList<StorageType> storageType) {
		this.storageType = storageType;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", serialNumber=" + serialNumber + ", processor=" + processor + ", ram=" + ram
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, processor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Objects.equals(id, other.id) && Objects.equals(processor, other.processor);
	}
	
	
	
	
}
