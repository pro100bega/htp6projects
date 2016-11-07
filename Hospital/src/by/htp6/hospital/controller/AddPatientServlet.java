package by.htp6.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.hospital.bean.Patient;
import by.htp6.hospital.helpers.AddPatientQuery;

/**
 * Servlet implementation class AddPatientServlet
 */
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet reached");
		String name = (String) request.getAttribute("patientName");
		String surname = (String) request.getAttribute("patientSurname");
		String diagnosis = (String) request.getAttribute("diagnosis");

		Patient patient = new Patient(name, surname, diagnosis);

		AddPatientQuery addPatientQuery = AddPatientQuery.getInstance();
		addPatientQuery.openConnection();
		try {
			addPatientQuery.addPatient(patient);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		addPatientQuery.closeConnection();

		String url = "readPatient";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
