package com.lpatop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

@Entity
public class StorageType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String storageType;
	private int rom;

	@ManyToMany(mappedBy = "storageType")
	@JsonIgnore
	private List<Laptop> laptop = new ArrayList<>();

	public StorageType(String storageType, int rom) {
		super();
		this.storageType = storageType;
		this.rom = rom;

	}

	public StorageType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(ArrayList<Laptop> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "StorageType [Id=" + Id + ", storageType=" + storageType + " rom= " + rom + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, storageType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StorageType other = (StorageType) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(storageType, other.storageType);
	}

}
