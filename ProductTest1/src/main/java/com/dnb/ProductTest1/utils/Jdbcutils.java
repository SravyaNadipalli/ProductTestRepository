package com.dnb.ProductTest1.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class Jdbcutils {
	@Autowired
		DataSource dataSource;
		// To get the connect from the database we use getconnection
		//jdbc url username and password will be taken from yml file implicitly by spring itself.
		public Optional<Connection> getConnection() {
			try {
				Connection connection = dataSource.getConnection();
				return Optional.of(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Optional.empty();
		}
		// the connection which is created in the getconnection method will be closed
		public void closeConnection(Connection connection) {
			try {
				connection.close();// using closeconnection()
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
