package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {
	
	private static final By SEARCH_PRODUCT_TEXT_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LIST = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String searchProductTitle()
	{
		return getVisibleText(SEARCH_PRODUCT_TEXT_LOCATOR);
	}
	
	public boolean isSearchTerPresentInProductList(String searchTerm) {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productList = getAllVisibleText(ALL_PRODUCT_LIST);
		productList.stream()
        .filter(product ->
                keywords.stream()
                        .noneMatch(keyword ->
                                product.toLowerCase().contains(keyword)))
        .forEach(product ->
                System.out.println("Unexpected product: " + product));
		
		return productList.stream()
	            .allMatch(product ->
	                    keywords.stream()
	                            .anyMatch(keyword ->
	                                    product.toLowerCase().contains(keyword)));
	}
	
	public ProductDetailsPage clickOnProduct(int index)
	{
		clickOn(getAllProductsList(ALL_PRODUCT_LIST).get(index));
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
		return productDetailsPage;
	}
	
	

}
