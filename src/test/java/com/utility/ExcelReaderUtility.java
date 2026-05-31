package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pojos.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelFile(String fileName)
	
	{
		File file = new File(System.getProperty("user.dir")+"/TestData/"+fileName);
		XSSFWorkbook wb ;
		List<User> userList = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		try {
			wb = new XSSFWorkbook(file);
			userList = new ArrayList<User>();
			xssfSheet = wb.getSheet("Sheet1");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// to skip headers or column names
			while(rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Cell emailAddressCell = row.getCell(0);
				Cell passwordCell = row.getCell(1);
				User user = new User(emailAddressCell.toString(),passwordCell.toString());
				userList.add(user);

				System.out.println(emailAddressCell.toString());
				System.out.println(passwordCell.toString());

			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
