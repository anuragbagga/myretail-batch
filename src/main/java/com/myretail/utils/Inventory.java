/**
 * This program will take items from file, compute total bill 
 *  generates the receipt and email to customer.
 * 
 * */

package com.myretail.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myretail.bean.InputData;
import com.myretail.dao.InventoryUpdateDao;
import com.myretail.exception.InvalidInputException;


public class Inventory {

	ArrayList<InputData> inputData;

	private String inputFilePath;

	public Inventory(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	
	public void updateInventory() throws  NumberFormatException, IOException, InvalidInputException, SQLException {
		
		// read and prepare input data
		inputData = new FileParser(inputFilePath).getInputData();
	
		for (InputData data : inputData) {
			int quantity = data.getQuantity();
			double price = data.getCost();
			int id = data.getId();	
			System.out.println("id:"+id);
			System.out.println("price:"+price);
			System.out.println("quantity:"+quantity);
			InventoryUpdateDao.update(id, price, quantity);
		}
	}

}
