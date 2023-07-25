package com.vinh.fresherApp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "company_center")
public class CompanyCenter {
	
	@Column(name = "center_id")
	@GeneratedValue
	@Id
	private Integer id;
	
	@Column(name = "center_name")
	private String name;
	
	@Column(name = "center_address")
	private String centerAddress;
	
	@Column(name = "center_desc")
	private String description;
	
	@OneToMany(mappedBy = "center")
	@JsonIgnore
	private List<Fresher> freshers;
	
	public CompanyCenter() {
	}

	

	public CompanyCenter(Integer id, String name, String centerAddress, String description, List<Fresher> freshers) {
		super();
		this.id = id;
		this.name = name;
		this.centerAddress = centerAddress;
		this.description = description;
		this.freshers = freshers;
	}



	public String getCenterAddress() {
		return centerAddress;
	}



	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Fresher> getFreshers() {
		return freshers;
	}


	public void setFreshers(List<Fresher> freshers) {
		this.freshers = freshers;
	}
	
	
	
}
