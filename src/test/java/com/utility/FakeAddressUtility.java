package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.pojos.AddressPOJO;

public class FakeAddressUtility {
	
	
	public static AddressPOJO getFakeAddress()
	{
		Faker faker = new Faker(Locale.US);
		AddressPOJO address = new AddressPOJO(faker.company().name(),faker.address().buildingNumber(), faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "1", "HOME","other");

		 return address;
	}

}
