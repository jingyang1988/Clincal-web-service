package com.stonybrook.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.stonybrook.bean.ClinicHistory;
import com.stonybrook.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/ccss";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "admin123";
	private static String getAllUsersSQLQuery = "select * from demographics";
	private static String getClinicalHistorySQLQuery = "select * from Demographics left outer join Clinical_History on Demographics.Patient_id = Clinical_History.Id";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public JSONObject deleteUser(int id) throws ClassNotFoundException, SQLException{
		JSONObject res = new JSONObject();
		String deleteUser = "delete from demographics where Patient_id = " + id;
		try {
			setConn();
			setStmt(deleteUser);
			stmt.setQueryTimeout(60);
			stmt.executeUpdate();
			res.put("success", true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			res.put("success", false);
			res.put("message", e.getMessage());
		}finally {
			closeConn();
		}

		return res;
	}
	
	public JSONObject updateClinicHistory(ClinicHistory ch) throws ClassNotFoundException, SQLException {
		JSONObject res = new JSONObject();
		String patientid = ch.getPatientid();
		String historyid = ch.getHistoryid();
		String smoking = ch.getSmoking();
		String quitsmoking = ch.getQuitsmoking();
	    String hypertension = ch.getHypertension();
		String diabetes = ch.getDiabetes();
		if(historyid.equals("new")){
			String insertClinicHistory = "insert into Clinical_History (Id, Smoking, QuitSmokingDate, Hypertension, Diabetes) values ('" + patientid + "', '" + smoking + "', '" + quitsmoking + "', '" + hypertension + "', '" + diabetes + "')";
			try {
				setConn();
				setStmt(insertClinicHistory);
				stmt.setQueryTimeout(60);
				stmt.executeUpdate();
				res.put("success", true);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				res.put("success", false);
				res.put("message", e.getMessage());
			}finally {
				closeConn();
			}
		}else{
			String updateClinicHistory = "update Clinical_History set Smoking = '" + smoking + "', QuitSmokingDate = '" + quitsmoking + "', Hypertension = '" + hypertension + "', Diabetes = '" + diabetes + "' where HistoryId = " + historyid;
			try {
				setConn();
				setStmt(updateClinicHistory);
				stmt.setQueryTimeout(60);
				stmt.executeUpdate();
				res.put("success", true);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				res.put("success", false);
				res.put("message", e.getMessage());
			}finally {
				closeConn();
			}
		}
		
		return res;
	
	}
	public JSONObject updateUser(User user) throws ClassNotFoundException, SQLException {
		JSONObject res = new JSONObject();
		int id = user.getId();
		String first_name = user.getFirst_name();
		String last_name = user.getLast_name();
		String middle_initial = user.getMiddle_initial();
		String gender = user.getGender();
		String ethinity = user.getEthinity();
		String insurance = user.getInsurance();
		String address = user.getAddress();
		String phone_numbers = user.getPhone_numbers();
		String email_address = user.getEmail_address();
		String zip_code = user.getZip_code();
		int hispanic_or_latino = user.getHispanic_or_latino();
		float height = user.getHeight();
		float weight = user.getWeight();
		String date = user.getDate();
		String medical_record_number = user.getMedical_record_number();
		String social_security_number = user.getSocial_security_number();

		String updateUser = "update demographics set Last_name = '" + last_name + "', First_name = '" + first_name + "', Middle_initial = '" + middle_initial +"', Gender = '" + gender +"', Ethinity = '" + ethinity +"', insurance = '" + insurance +"', Address = '" + address +"',Phone_numbers = '" + phone_numbers +"', email_address = '" + email_address +"', Postal_code = '" + zip_code +"', Hispanic_or_Latino = '" + hispanic_or_latino +"', Height ='" + height +"', Weight= '" + weight +"', Date_of_birth='" + date +"', Medical_record_number='" + medical_record_number +"',Social_security_number = '" + social_security_number +"' where Patient_id = " + id;
		System.out.println(updateUser);
/*		String insertUser = "insert into demographics(Last_name, First_name, Middle_initial, Gender, Ethinity, insurance, Address," 
				+ "Phone_numbers, email_address, Zip/Postal_code, Hispanic_or_Latino, Height, Weight, Date_of_birth, Medical_record_number,"
				+ " Social_security_number) values (" + first_name + "," + last_name +"," + middle_initial +"," + gender +"," + ethinity +"," + insurance +"," + address +","
				+ phone_numbers +"," + email_address +"," + zip_code +"," + hispanic_or_latino +"," + height +"," + weight +"," + date +"," + medical_record_number +"," + social_security_number +")";
*/
		try {
			setConn();
			setStmt(updateUser);
			stmt.setQueryTimeout(60);
			stmt.executeUpdate();
			res.put("success", true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			res.put("success", false);
			res.put("message", e.getMessage());
		}finally {
			closeConn();
		}

		return res;
	}
	
	public JSONObject addUser(User user) throws ClassNotFoundException, SQLException {
		JSONObject res = new JSONObject();
		String first_name = user.getFirst_name();
		String last_name = user.getLast_name();
		String middle_initial = user.getMiddle_initial();
		String gender = user.getGender();
		String ethinity = user.getEthinity();
		String insurance = user.getInsurance();
		String address = user.getAddress();
		String phone_numbers = user.getPhone_numbers();
		String email_address = user.getEmail_address();
		String zip_code = user.getZip_code();
		int hispanic_or_latino = user.getHispanic_or_latino();
		float height = user.getHeight();
		float weight = user.getWeight();
		String date = user.getDate();
		String medical_record_number = user.getMedical_record_number();
		String social_security_number = user.getSocial_security_number();

		String insertUser = "insert into demographics(First_name, Last_name, Middle_initial, Gender, Ethinity, insurance, Address," 
				+ " Phone_numbers, email_address, Postal_code, Hispanic_or_Latino, Height, Weight, Date_of_birth, Medical_record_number,"
				+ " Social_security_number) values ('" + first_name + "','" + last_name +"','" + middle_initial +"','" + gender +"','" + ethinity +"','" + insurance +"','" + address +"','"
				+ phone_numbers +"','" + email_address +"','" + zip_code +"','" + hispanic_or_latino +"','" + height +"','" + weight +"','" + date +"','" + medical_record_number +"','" + social_security_number +"')";

		System.out.println(insertUser);
/*		String insertUser = "insert into demographics(Last_name, First_name, Middle_initial, Gender, Ethinity, insurance, Address," 
				+ "Phone_numbers, email_address, Zip/Postal_code, Hispanic_or_Latino, Height, Weight, Date_of_birth, Medical_record_number,"
				+ " Social_security_number) values (" + first_name + "," + last_name +"," + middle_initial +"," + gender +"," + ethinity +"," + insurance +"," + address +","
				+ phone_numbers +"," + email_address +"," + zip_code +"," + hispanic_or_latino +"," + height +"," + weight +"," + date +"," + medical_record_number +"," + social_security_number +")";
*/
		try {
			setConn();
			setStmt(insertUser);
			stmt.setQueryTimeout(60);
			stmt.executeUpdate();
			res.put("success", true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			res.put("success", false);
			res.put("message", e.getMessage());
		}finally {
			closeConn();
		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public JSONArray listAllUsers() throws ClassNotFoundException, SQLException {
		JSONArray result;
		try {
			result = new JSONArray();
			setConn();
			setStmt(getAllUsersSQLQuery);
			stmt.setQueryTimeout(60);
			rs = (ResultSet) stmt.executeQuery();
			while (rs.next()) {
				JSONObject userJson = new JSONObject();
				userJson.put("id", rs.getString("Patient_id"));
				userJson.put("firstname", rs.getString("First_name"));
				userJson.put("lastname", rs.getString("Last_name"));
				userJson.put("gender", rs.getString("Gender"));
				userJson.put("ethinity", rs.getString("Ethinity"));
				userJson.put("middleinitial", rs.getString("Middle_initial"));
				userJson.put("insurance", rs.getString("Insurance"));
				userJson.put("address", rs.getString("Address"));
				userJson.put("phonenumbers", rs.getString("Phone_numbers"));
				userJson.put("emailaddress", rs.getString("email_address"));
				userJson.put("zipcode", rs.getString("Postal_code"));
				userJson.put("hispanicorlatino",
						rs.getString("Hispanic_or_Latino"));
				userJson.put("height", rs.getString("Height"));
				userJson.put("weight", rs.getString("Weight"));
				userJson.put("dateofbirth", rs.getString("Date_of_birth"));
				userJson.put("medicalrecordnumber",
						rs.getString("Medical_record_number"));
				userJson.put("socialsecuritynumber",
						rs.getString("Social_security_number"));
				result.add(userJson);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConn();
		}
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray listClinicalHistory() throws ClassNotFoundException, SQLException {
		JSONArray result;
		try {
			result = new JSONArray();
			setConn();
			setStmt(getClinicalHistorySQLQuery);
			stmt.setQueryTimeout(60);
			rs = (ResultSet) stmt.executeQuery();
			while (rs.next()) {
				JSONObject clinHistoryJson = new JSONObject();
				clinHistoryJson.put("historyId", rs.getString("HistoryId"));
				clinHistoryJson.put("id", rs.getString("Patient_id"));
				clinHistoryJson.put("firstname", rs.getString("first_name"));
				clinHistoryJson.put("lastname", rs.getString("Last_name"));
				clinHistoryJson.put("gender", rs.getString("Gender"));
				clinHistoryJson.put("smoking", rs.getString("Smoking"));
				clinHistoryJson.put("quitSmoking", rs.getString("QuitSmokingDate"));
				clinHistoryJson.put("hypertension", rs.getString("Hypertension"));
				clinHistoryJson.put("diabetes", rs.getString("Diabetes"));
				result.add(clinHistoryJson);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConn();
		}
	}

	private void setConn() throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);
		conn = (Connection) DriverManager.getConnection(DB_CONNECTION, DB_USER,
				DB_PASSWORD);
	}

	private void setStmt(String sql) throws SQLException {
		stmt = (PreparedStatement) conn.prepareStatement(sql);
	}

	private void closeConn() throws ClassNotFoundException, SQLException {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + ": " + e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + ": " + e.getMessage());
			}
		}
	}
}
