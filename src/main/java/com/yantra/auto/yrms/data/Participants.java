package com.yantra.auto.yrms.data;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"firstName",
"lastName",
"phone",
"email",
"addressLine1",
"addressLine2",
"city",
"state",
"country",
"zipCode",
"type",
"category",
"riskPriority",
"accountWith",
"holderId",
"holderType"
})
public class Participants 
{
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("email")
	private String email;
	@JsonProperty("addressLine1")
	private String addressLine1;
	@JsonProperty("addressLine2")
	private String addressLine2;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("country")
	private String country;
	@JsonProperty("zipCode")
	private String zipCode;
	@JsonProperty("type")
	private String type;
	@JsonProperty("category")
	private String category;
	@JsonProperty("riskPriority")
	private String riskPriority;
	@JsonProperty("accountWith")
	private String accountWith;
	@JsonProperty("holderId")
	private String holderId;
	@JsonProperty("holderType")
	private String holderType;
	@JsonProperty("firstName")
	public String getFirstName() 
	{
		return firstName;
	}
	@JsonProperty("firstName")
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() 
	{
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	@JsonProperty("phone")
	public String getPhone() 
	{
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	@JsonProperty("email")
	public String getEmail() 
	{	
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) 
	{
		this.email = email;
	}

	@JsonProperty("addressLine1")		
	public String getAddressLine1() 
	{
		return addressLine1;
	}

	@JsonProperty("addressLine1")
	public void setAddressLine1(String addressLine1) 
	{
		this.addressLine1 = addressLine1;	
	}	

	@JsonProperty("addressLine2")
	public String getAddressLine2() 
	{
		return addressLine2;
	}

@JsonProperty("addressLine2")
public void setAddressLine2(String addressLine2) {
this.addressLine2 = addressLine2;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("state")
public String getState() {
return state;
}

@JsonProperty("state")
public void setState(String state) {
this.state = state;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("zipCode")
public String getZipCode() {
return zipCode;
}

@JsonProperty("zipCode")
public void setZipCode(String zipCode) {
this.zipCode = zipCode;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("riskPriority")
public String getRiskPriority() {
return riskPriority;
}

@JsonProperty("riskPriority")
public void setRiskPriority(String riskPriority) {
this.riskPriority = riskPriority;
}

@JsonProperty("accountWith")
public String getAccountWith() {
return accountWith;
}

@JsonProperty("accountWith")
public void setAccountWith(String accountWith) {
this.accountWith = accountWith;
}

@JsonProperty("holderId")
public String getHolderId() {
return holderId;
}

@JsonProperty("holderId")
public void setHolderId(String holderId) {
this.holderId = holderId;
}

@JsonProperty("holderType")
public String getHolderType() {
return holderType;
}

@JsonProperty("holderType")
public void setHolderType(String holderType) {
this.holderType = holderType;
}


}