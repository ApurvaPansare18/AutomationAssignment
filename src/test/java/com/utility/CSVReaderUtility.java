package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pojos.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
	

		File file = new File(System.getProperty("user.dir") + "/TestData/"+fileName);

		FileReader fr = null;
		CSVReader csvReader ;
		String [] line;// contains email and pass for each row
		List<User> userList =null;
		User userData;
		try {
			fr = new FileReader(file);
			csvReader = new CSVReader(fr);
			csvReader.readNext(); //reading col names -----> Row 1 ----> need to skip column names row so keep this line
			//csvReader.readNext();//row 2
			//csvReader.readNext();//row 3
			//csvReader.readNext();// no row or we have reached end of csv file ----> returns null
			userList = new ArrayList<User>();
			while((line = csvReader.readNext())!=null)
			{
				userData = new User(line[0],line[1]);
				userList.add(userData);
			}
			
			for(User user:userList)
			{	
				System.out.println(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
       return userList.iterator();
	}
}
