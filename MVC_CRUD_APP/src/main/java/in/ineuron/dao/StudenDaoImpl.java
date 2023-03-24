package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudenDaoImpl implements IStudentDao {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addStudent(Student student) {
		String sqlInsertQuery = "INSERT INTO students(`name`,`age`,`address`) values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {

				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getAge());
				pstmt.setString(3, student.getAddress());
				int rowCount = pstmt.executeUpdate();
				if (rowCount == 1) {
					return "Success";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "Failure";
	}

	@Override
	public Student searchStudent(Integer id) {
		String sqlSelectQuery = "SELECT id,name,age,address FROM STUDENTS where id =?";
		Student student = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {

				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, id);
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {
				if (resultSet.next()) {
					student = new Student();
					student.setId(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setAge(resultSet.getInt(3));
					student.setAddress(resultSet.getString(4));
					return student;
				}
			}
		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Student stdUpdate) {
		String sqlUpdateQuery = "UPDATE students SET name = ?,age = ?,address = ? WHERE id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			if (pstmt != null) {
				if (stdUpdate != null) {
					Integer id = stdUpdate.getId();
					String name = stdUpdate.getName();
					Integer age = stdUpdate.getAge();
					String address = stdUpdate.getAddress();
					pstmt.setString(1, name);
					pstmt.setInt(2, age);
					pstmt.setString(3, address);
					pstmt.setInt(4, id);
				}
				Integer rowsEffected = pstmt.executeUpdate();
				if (rowsEffected == 1) {
					return "Success";
				}
			}
		} catch (SQLException | IOException e) {

			e.printStackTrace();
		}
		return "Failure";
	}

	@Override
	public String deleteStudent(Integer id) {
		String sqlDeleteQuery = "DELETE FROM students WHERE id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, id);
				int rowCount = pstmt.executeUpdate();
				if (rowCount == 1) {
					return "Success";
				} else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		// if any failure in query this statement will be returned
		return "failure";
	}

}
