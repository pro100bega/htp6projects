package by.htp6.hospital.helpers;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.ResourceBundle;
import java.util.ResourceBundle;

import by.htp6.hospital.bean.Patient;

public class AddPatientQuery {

	private Connection connection;

	public static volatile AddPatientQuery instance;

	public static AddPatientQuery getInstance() {
		if (instance == null) {
			synchronized (AddPatientQuery.class) {
				if (instance == null) {
					synchronized (AddPatientQuery.class) {
						instance = new AddPatientQuery();
					}
				}
			}
		}
		return instance;
	}

	private AddPatientQuery() {
	}

	/**
	 * Opens database connection.
	 */
	public void openConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle("resources.db_connection_info");
		String dbName = bundle.getString("db_name");
		String dbPassword = bundle.getString("db_password");

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String url = "jdbc:mysql://127.0.0.1/hospital?useSSL=false";
			this.connection = DriverManager.getConnection(url, dbName, dbPassword);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Closes database connection.
	 */
	public void closeConnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addPatient(Patient patient) throws SQLException {
		String query = "INSERT INTO patient(name, surname, diagnosis) VALUES(?,?,?)";

		PreparedStatement preparedStatement = this.connection.prepareStatement(query);

		preparedStatement.setString(1, patient.getName());
		preparedStatement.setString(2, patient.getName());
		preparedStatement.setString(3, patient.getDiagnosis());

		preparedStatement.executeUpdate();
	}
}
