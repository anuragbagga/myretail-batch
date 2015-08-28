package com.myretail.dao;

import com.myretail.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryUpdateDao {

	// Method updates inventory based on id. Price and quantity both will get updated.
	
	public static void update(int id,double price,int quantity) throws SQLException{

		PreparedStatement preparedStatement = null;
		PreparedStatement selectstatement = null;
		Connection con = DBConnection.getConnection();

		String selectTableSQL = "SELECT ID,QUANTITY from ITEM_PRICE WHERE ID = ?";

		String updateTableSQL = "UPDATE ITEM_PRICE SET PRICE = ?, QUANTITY=?  "
				+ " WHERE ID = ?";
		try {
			selectstatement = con.prepareStatement(selectTableSQL);
			selectstatement.setInt(1, id);
			ResultSet rs = selectstatement.executeQuery();
			while (rs.next()) {
				preparedStatement = con.prepareStatement(updateTableSQL);
				preparedStatement.setDouble(1, price);
				System.out.println("Total"+ rs.getInt("QUANTITY")+quantity);
				preparedStatement.setInt(2, rs.getInt(2)+quantity);
				preparedStatement.setInt(3, id);
				// execute update SQL statement
				preparedStatement.executeUpdate();
				System.out.println("Inventory updated successfully!!!! for id :-"+id);
			}
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (con != null) {
				con.close();
			}

		}
	}
}

