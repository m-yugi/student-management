package com.yugi.hibernateEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class students {
	@Id
	private int id;
	private String name;
	private long moblie;
	private String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMoblie() {
		return moblie;
	}
	public void setMoblie(long moblie) {
		this.moblie = moblie;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "students [id=" + id + ", name=" + name + ", moblie=" + moblie + ", country=" + country + "]";
	}
}
