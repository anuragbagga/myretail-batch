package com.myretail.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.myretail.bean.InputData;
import com.myretail.exception.InvalidInputException;

public class FileParser {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String filePath;
	private ArrayList<InputData> inputDataArray;

	/**
	 * 
	 * 
	 * @param filePath
	 *           parsing file received from customer
	 * */
	
	public FileParser(String filePath) throws InvalidInputException, NumberFormatException,
			IOException {
		this.filePath = filePath;
		this.inputDataArray = new ArrayList<InputData>();
		fileReader = new FileReader(filePath);
		bufferedReader = new BufferedReader(fileReader);
		String currentLine = null;
		int quantity = 0;
		double cost = 0;
		int id=0;
		while ((currentLine = bufferedReader.readLine()) != null) {
			// remove trailing spaces
			currentLine = currentLine.replaceAll("\\s+$", "");
			String[] array = currentLine.split(",");
			// Assuming the line should start and end with a number
			if (checkNumber(array[0]) && checkNumber(array[array.length - 1])) {
				quantity = new Integer(array[0]).intValue();
				cost = new Double(array[array.length - 1]).doubleValue();
				id = new Integer(array[1]).intValue();
			} else {
				id=0;
				quantity = 0;
				cost = 0;
				throw new InvalidInputException();
			}
			inputDataArray.add(new InputData(id , quantity, cost));
		}

	}

	/**
	 * Helper method to validate data in file
	 * 
	 * @param fileInputString
	 *            string from file that needs validation
	 * */
	private boolean checkNumber(String fileInputString) {
		boolean isNumber = true;
		try {
			isNumber = (Integer.parseInt(fileInputString)) > 0;
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		return isNumber;
	}

	/**
	 * Method to populate data from file into an array of InputData
	 * 
	 * @return inputDataArray Array of type InputData that contains data
	 *         processed from file
	 * */
	public ArrayList<InputData> getInputData() {
		return inputDataArray;

	}
}
