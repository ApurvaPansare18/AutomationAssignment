package com.pojos;

public class AddressPOJO {
	
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipCode;
	private String homePhoneNumber;
	private String mobileNumber;
	
	private String state;
	private String addressAlias;
	private String additionalInfo;
	public AddressPOJO(String companyName, String addressLine1, String addressLine2, String city, String zipCode,
			String homePhoneNumber, String mobileNumber,  String state, String addressAlias,
			String additionalInfo) {
		super();
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipCode = zipCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		
		this.state = state;
		this.addressAlias = addressAlias;
		this.additionalInfo = additionalInfo;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getCompanyName() {
		return companyName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public String getState() {
		return state;
	}
	public String getAddressAlias() {
		return addressAlias;
	}

	@Override
	public String toString() {
		return "AddressPOJO [companyName=" + companyName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", zipCode=" + zipCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", state=" + state + ", addressAlias="
				+ addressAlias + ", additionalInfo=" + additionalInfo + "]";
	}
	
	

}
