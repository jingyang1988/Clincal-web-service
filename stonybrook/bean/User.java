package com.stonybrook.bean;

public class User {
	private int patient_id;
	private String first_name;
	private String last_name;
	private String middle_initial;
	private String gender;
	private String ethinity;
	private String insurance;
	private String address;
	private String phone_numbers;
	private String email_address;
	private String zip_code;
	private int hispanic_or_latino;
	private	float height;
	private float weight;
	private String date;
	private String medical_record_number;
	private String social_security_number;

	public int getId() {
		return patient_id;
	}

	public void setId(int id) {
		this.patient_id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMiddle_initial() {
		return middle_initial;
	}

	public void setMiddle_initial(String middle_initial) {
		this.middle_initial = middle_initial;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEthinity() {
		return ethinity;
	}

	public void setEthinity(String ethinity) {
		this.ethinity = ethinity;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_numbers() {
		return phone_numbers;
	}

	public void setPhone_numbers(String phone_numbers) {
		this.phone_numbers = phone_numbers;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public int getHispanic_or_latino() {
		return hispanic_or_latino;
	}

	public void setHispanic_or_latino(int hispanic_or_latino) {
		this.hispanic_or_latino = hispanic_or_latino;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMedical_record_number() {
		return medical_record_number;
	}

	public void setMedical_record_number(String medical_record_number) {
		this.medical_record_number = medical_record_number;
	}

	public String getSocial_security_number() {
		return social_security_number;
	}

	public void setSocial_security_number(String social_security_number) {
		this.social_security_number = social_security_number;
	}
	
}
