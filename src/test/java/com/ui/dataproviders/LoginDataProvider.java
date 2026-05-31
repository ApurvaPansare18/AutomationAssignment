package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.pojos.TestData;
import com.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	@DataProvider(name = "LoginDataProvider")
	public Iterator<Object[]> loginDataProvider()
	{
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir")+"/TestData/loginData.json");
		FileReader fr = null;
		try {
			fr = new FileReader(testDataFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TestData data = gson.fromJson(fr, TestData.class);
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		
		for(User user : data.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
		
		return dataToReturn.iterator();
	}

	
	@DataProvider(name = "LoginCSVDataProvider")
	public Iterator<User> loginCSVDataProvider()
	{
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	
	
	@DataProvider(name = "LoginExcelDataProvider")
	public Iterator<User> loginExcelDataProvider()
	{
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
}



