package by.htp6.hospital.helpers;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.htp6.hospital.bean.Patient;

public class ReadPatientQuery {
	private Connection connection;

	private ResultSet resultSet;

	private static ReadPatientQuery instance;

	private ReadPatientQuery() {
	}

	public static ReadPatientQuery getInstance() {
		if (instance == null) {
			synchronized (ReadPatientQuery.class) {
				if (instance == null) {
					synchronized (ReadPatientQuery.class) {
						instance = new ReadPatientQuery();
					}
				}
			}
		}
		return instance;
	}

	public void openConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle("resources.db_connection_info");
		String dbName = bundle.getString("db_name");
		String dbPassword = bundle.getString("db_password");
		
		String url = "jdbc:mysql://127.0.0.1/hospital?useSSL=false";
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			this.connection = DriverManager.getConnection(url, dbName, dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void executeQuery() {
		Statement statement;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM patient");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				this.resultSet = resultSet;
			} else {
				this.resultSet = null;
			}

		}
	}

	public List<Patient> getPatients() {
		
		List<Patient> patientList = new ArrayList<>();
		int id;
		String patientName;
		String patientSurname;
		String diagnosis;
		try {
			while (this.resultSet.next()) {
				id = resultSet.getInt("id");
				patientName = resultSet.getString("name");
				patientSurname = resultSet.getString("surname");
				diagnosis = resultSet.getString("diagnosis");
				
				patientList.add(new Patient(id, patientName, patientSurname,
						diagnosis));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public void closeConnection() {
		try {
			if (!this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
