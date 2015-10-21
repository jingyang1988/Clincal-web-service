package com.stonybrook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.stonybrook.bean.ClinicHistory;
import com.stonybrook.bean.User;
import com.stonybrook.dao.UserDAO;
import com.stonybrook.util.Const;

/**
 * Servlet implementation class UIServlet
 */
@WebServlet("/UIServlet")
public class UIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String func = request.getParameter("btnSubmit");
		//String func2 = request.getParameter("btnSubmitHistory");
		if (func != null && func.equals("getPatients"))
			try {
				doGetPatients(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (func != null && func.equals("getClinicalHistory"))
			try {
				doGetClinicalHistory(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void doGetClinicalHistory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserDAO userDAO = new UserDAO();
		JSONObject result = new JSONObject();
		try {
			result.put("users", userDAO.listClinicalHistory());
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getLocalizedMessage());
		}
		response.getWriter().print(result.toJSONString());
	}

	@SuppressWarnings("unchecked")
	private void doGetPatients(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserDAO userDAO = new UserDAO();
		JSONObject result = new JSONObject();
		try {
			result.put("users", userDAO.listAllUsers());
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getLocalizedMessage());
		}
		response.getWriter().print(result.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String func = request.getParameter("btnSubmit");
		if (func != null)
			switch (func) {
			case "login":
				doPostLogin(request,response);
				break;
			case "submituser":
				doPostAddUser(request, response);
				break;
			case "updateuser":
				doPostUpdateUser(request, response);
				break;	
			case "deleteuser":
				doPostDeleteUser(request, response);
				break;		
			case "updateHistory":
				doPostUpdateHistory(request, response);
				break;
			default:
				break;
			}
	}

	private void doPostUpdateHistory(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject result = new JSONObject();
		String historyid = request.getParameter("historyid");
		if(historyid.equals("null"))
			historyid = "new";
		String smoking = request.getParameter("smoking");
		String quitsmoking = request.getParameter("quitsmoking");
		String hypertension = request.getParameter("hypertension");
		String diabetes = request.getParameter("diabetes");
		String patientid = request.getParameter("patientid");
		UserDAO userDAO = new UserDAO();
		ClinicHistory ch = new ClinicHistory();
		ch.setHistoryid(historyid);
		ch.setSmoking(smoking);
		ch.setQuitsmoking(quitsmoking);
		ch.setHypertension(hypertension);
		ch.setDiabetes(diabetes);
		ch.setPatientid(patientid);
		try {
			result = userDAO.updateClinicHistory(ch);
			response.getWriter().print(result.toJSONString());
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			result.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	private void doPostLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isCorrectCredential = checkCredential(username, password);
		if (isCorrectCredential){
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("error", "Bad Credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
			
	}

	private boolean checkCredential(String username, String password) {
		if (username.equals(Const.USERNAME)&&password.equals(Const.PASSWORD))
			return true;
		return false;
	}

	private void doPostDeleteUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO = new UserDAO();
		JSONObject result = null;
		try {
			result = userDAO.deleteUser(id);
			response.getWriter().print(result.toJSONString());
		} catch (ClassNotFoundException | SQLException e) {
			result.put("message", e.getMessage());
		}
		
	}

	private void doPostUpdateUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User user = new User();
		String id = request.getParameter("id");
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String middle_initial = request.getParameter("middleinitial");
		String gender = request.getParameter("gender");
		String ethinity = request.getParameter("ethinity");
		String insurance = request.getParameter("insurance");
		String address = request.getParameter("address");
		String phone_numbers = request.getParameter("phonenumbers");
		String email_address = request.getParameter("emailaddress");
		String zip_code = request.getParameter("zipcode");
		String hispanic_or_latino = request.getParameter("hispanicorlatino");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String date = request.getParameter("dateofbirth");
		String medical_record_number = request.getParameter("medicalrecordnumber");
		String social_security_number = request.getParameter("socialsecuritynumber");
		
		user.setId(Integer.parseInt(id));
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setMiddle_initial(middle_initial);
		user.setGender(gender);
		user.setEthinity(ethinity);
		user.setInsurance(insurance);
		user.setAddress(address);
		user.setPhone_numbers(phone_numbers);
		user.setEmail_address(email_address);
		user.setZip_code(zip_code);
		user.setHispanic_or_latino(Integer.parseInt(hispanic_or_latino));
		user.setHeight(Float.parseFloat(height));
		user.setWeight(Float.parseFloat(weight));
		user.setDate(date);
		user.setMedical_record_number(medical_record_number);
		user.setSocial_security_number(social_security_number);
		
		UserDAO userDAO = new UserDAO();
		JSONObject result = null;
		try {
			result = userDAO.updateUser(user);
			response.getWriter().print(result.toJSONString());
		} catch (ClassNotFoundException | SQLException e) {
			result.put("message", e.getMessage());
		}
		
		
	}

	
	

	@SuppressWarnings("unchecked")
	private void doPostAddUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User user = new User();
		
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String middle_initial = request.getParameter("middleinitial");
		String gender = request.getParameter("gender");
		String ethinity = request.getParameter("ethinity");
		String insurance = request.getParameter("insurance");
		String address = request.getParameter("address");
		String phone_numbers = request.getParameter("phonenumbers");
		String email_address = request.getParameter("emailaddress");
		String zip_code = request.getParameter("zipcode");
		String hispanic_or_latino = request.getParameter("hispanicorlatino");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String date = request.getParameter("dateofbirth");
		String medical_record_number = request.getParameter("medicalrecordnumber");
		String social_security_number = request.getParameter("socialsecuritynumber");
		
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setMiddle_initial(middle_initial);
		user.setGender(gender);
		user.setEthinity(ethinity);
		user.setInsurance(insurance);
		user.setAddress(address);
		user.setPhone_numbers(phone_numbers);
		user.setEmail_address(email_address);
		user.setZip_code(zip_code);
		user.setHispanic_or_latino(Integer.parseInt(hispanic_or_latino));
		user.setHeight(Float.parseFloat(height));
		user.setWeight(Float.parseFloat(weight));
		user.setDate(date);
		user.setMedical_record_number(medical_record_number);
		user.setSocial_security_number(social_security_number);
		
		UserDAO userDAO = new UserDAO();
		JSONObject result = null;
		try {
			result = userDAO.addUser(user);
			response.getWriter().print(result.toJSONString());
		} catch (ClassNotFoundException | SQLException e) {
			result.put("message", e.getMessage());
		}
		
		
	}

	
}
