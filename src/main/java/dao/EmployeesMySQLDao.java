package dao;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;
import models.Employee;

public class EmployeesMySQLDao {
	private Connection connection = null;

	public EmployeesMySQLDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
		} catch (SQLException e) {
			throw new RuntimeException("error connecting to database", e);
		}
	}

	public static void main(String[] args) {
		Config config = new Config();
		EmployeesMySQLDao dao = new EmployeesMySQLDao(config);
		List<Employee> employees = dao.all();
		for (int i = 0; i <= 10; i++){
			Employee emp = employees.get(i);
			System.out.println("emp.getFirstName() = " + emp.getFirstName());
			System.out.println("emp.getLastName() = " + emp.getLastName());
			System.out.println("emp.getEmpNo() = " + emp.getEmpNo());
			System.out.println("--------");
		}
	}

	public List<Employee> all(){
		List<Employee> employees = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM employees.employees");
			while (resultSet.next()){
				employees.add(new Employee(
					resultSet.getLong("emp_no"),
					resultSet.getString("first_name"),
					resultSet.getString("last_name"),
					resultSet.getString("gender").charAt(0),
					resultSet.getDate("birth_date"),
					resultSet.getDate("hire_date")
				));
			}
			return employees;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
