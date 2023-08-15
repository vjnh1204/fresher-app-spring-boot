package com.vinh.fresherApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "tbl_fresher")
public class Fresher {

	@Id
	@Column(name = "fresher_id")
	@GeneratedValue
	private Integer id;

	@Column(name = "fresher_name")
	private String name;

	@Column(name = "fresher_address")
	private String address;

	@Column(name = "fresher_email")
	private String email;

	@Column(name = "fresher_programing_language")
	private String programingLanguage;

	@Column(name = "first_score")
	private float firstScore;
	@Column(name = "second_score")
	private float secondScore;
	@Column(name = "third_score")
	private float thirdScore;

	@Column(name = "last_score")
	private float lastScore;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CompanyCenter center;

	public Fresher() {
	}

	public Fresher(Integer id, String name, String address, String email, String programingLanguage) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.programingLanguage = programingLanguage;
		this.firstScore = 0.0f;
		this.secondScore = 0.f;
		this.thirdScore = 0.0f;
		this.lastScore = (this.firstScore + this.secondScore + this.thirdScore) / 3;
	}

	public Fresher(Integer id, String name, String address, String email, String programingLanguage, float firstScore,
			float secondScore, float thirdScore, float lastScore) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.programingLanguage = programingLanguage;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
		this.lastScore = lastScore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getLastScore() {
		return lastScore;
	}

	public void setLastScore() {
		this.lastScore = (firstScore + secondScore + thirdScore) / 3;
	}

	public float getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(float firstScore) {
		this.firstScore = firstScore;
	}

	public float getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(float secondScore) {
		this.secondScore = secondScore;
	}

	public float getThirdScore() {
		return thirdScore;
	}

	public void setThirdScore(float thirdScore) {
		this.thirdScore = thirdScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramingLanguage() {
		return programingLanguage;
	}

	public void setProgramingLanguage(String programingLanguage) {
		this.programingLanguage = programingLanguage;
	}

	public CompanyCenter getCenter() {
		return center;
	}

	public void setCenter(CompanyCenter center) {
		this.center = center;
	}

}
