package by.htp6.hospital.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.hospital.bean.Patient;
import by.htp6.hospital.helpers.ReadPatientQuery;

/**
 * Servlet implementation class ReadPatientServlet
 */
@WebServlet("/readPatient")
public class ReadPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPatientServlet() {
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
		// Получаем ссылку на объект ReadPatientQuery
		ReadPatientQuery readPatientQuery = ReadPatientQuery.getInstance();
		
		// Открывается соединение
		readPatientQuery.openConnection();
		
		// Выполняется запрос в бд на получение списка пациентов
		readPatientQuery.executeQuery();
		
		List<Patient> patientList = readPatientQuery.getPatients();
		readPatientQuery.closeConnection();
		
		request.setAttribute("patientList", patientList);
		
		String url = "read.jsp";
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
