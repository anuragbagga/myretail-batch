package com.myretail.batch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FilenameUtils;

import com.myretail.exception.InvalidInputException;
import com.myretail.utils.Constants;
import com.myretail.utils.Inventory;


public class InventoryJob {

	public static void main(String[] args) {

		String inputFile = null;

		//Checking valid Input file 
		if(args.length == 0){
			System.err.println("No input file specified. Please specify input file path as command line argument");
			System.exit(0);
		} else {
			inputFile = args[0];
			String ext = FilenameUtils.getExtension(inputFile);	
			// Checking valid input file format
			if(!(ext.equals(Constants.FILE_EXTN))){
				System.out.println("Only txt file accepted. You provided "+ ext);
				System.exit(0);
			}
		}

		Inventory inv = new Inventory(inputFile);
		try {
			inv.updateInventory();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
