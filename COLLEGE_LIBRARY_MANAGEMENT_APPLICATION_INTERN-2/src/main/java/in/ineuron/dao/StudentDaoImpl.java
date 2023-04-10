package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.dto.StudentBookTracker;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String studentRegistration(Student student) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement("INSERT INTO student(`sid`,`sname`,`slastname`,`sage`, `smail`,`saddress`,`spwd`) VALUES(?,?,?,?,?,?,?)");
			}
			if (pstmt != null) {
				pstmt.setString(1, student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setString(3, student.getSlastname());
				pstmt.setInt(4, student.getSage());
				pstmt.setString(5, student.getSmail());
				pstmt.setString(6, student.getSaddress());
				pstmt.setString(7, student.getSpassword());

				int rowEffected = pstmt.executeUpdate();

				if (rowEffected == 1) {
					return "Success";
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return "Failure";
	}

	@Override
	public String studentLogin(String sid, String spassword) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement("SELECT spwd FROM student WHERE sid = ?");
			}
			if (pstmt != null) {
				pstmt.setString(1, sid);

				resultSet = pstmt.executeQuery();
			}
			if (resultSet.next()) {
				String spwd = resultSet.getString("spwd");
				if (spassword.equals(spwd)) {
					return "Success";
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return "Failure";
	}

	@Override
	public List<Book> studentBooks(String sid) {
		String sqlQuery1 = "SELECT bid FROM studentbooktracker WHERE sid = ?";
		String sqlQuery2 = "SELECT * FROM book WHERE bid = ?";

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;

		List<String> bidList = new ArrayList<String>();
		List<Book> books = new ArrayList<Book>();

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt1 = connection.prepareStatement(sqlQuery1);

				if (pstmt1 != null) {
					pstmt1.setString(1, sid);

					resultSet = pstmt1.executeQuery();
					while (resultSet.next()) {
						String bid = resultSet.getString("bid");
						bidList.add(bid);
					}

				}

				pstmt2 = connection.prepareStatement(sqlQuery2);

				if (pstmt2 != null) {
					for (String bid : bidList) {
						System.out.println(bid);
						pstmt2.setString(1, bid);
						resultSet2 = pstmt2.executeQuery();
						while (resultSet2.next()) {
							Book book = new Book();
							book.setBid(resultSet2.getString("bid"));
							book.setBtitle(resultSet2.getString("btitle"));
							book.setBauthor(resultSet2.getString("bauthor"));
							book.setBcategory(resultSet2.getString("bcategory"));
							System.out.println(book);
							books.add(book);
						}
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Integer studentFines(String sid, String bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentBookTracker getBorrowDateAndSubmDate(String sid, String bid) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Date bdate = null;
		Date sdate = null;
		StudentBookTracker bookTracker = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(
						"SELECT borrowdate,submitdate FROM studentbooktracker WHERE  sid = ? AND bid=?");
			}
			if (pstmt != null) {
				pstmt.setString(1, sid);
				pstmt.setString(2, bid);

				resultSet = pstmt.executeQuery();

			}
			if (resultSet.next()) {
				bookTracker = new StudentBookTracker();
				bdate = resultSet.getDate("borrowdate");
				sdate = resultSet.getDate("submitdate");
				System.out.println(sdate);
				bookTracker.setBorrowdate(bdate);
				bookTracker.setSubmitdate(sdate);
				System.out.println(bookTracker);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return bookTracker;
	}

	@Override
	public String addFineIntoDB(Integer fine, String sid, String bid) {
		PreparedStatement pstmt = null;
		Connection connection = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement("UPDATE studentbooktracker SET fine=? WHERE  sid=? AND bid=?");
			}
			if (pstmt != null) {
				pstmt.setInt(1, fine);
				pstmt.setString(2, sid);
				pstmt.setString(3, bid);

				int rowEffected = pstmt.executeUpdate();
				if (rowEffected == 1) {
					return "Success";
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return "Failure";
	}

	@Override
	public Book bookSearchInLib(String attribute, String value) {

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Book book = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {

				// pstmt = connection.prepareStatement( "SELECT * FROM book WHERE bauthor LIKE ?
				// AND btitle LIKE ? AND bcategory LIKE ? ");
				pstmt = connection.prepareStatement("SELECT * FROM  book WHERE " + attribute + " LIKE  ? ");

			}
			if (pstmt != null) {

				pstmt.setString(1, value);

				resultSet = pstmt.executeQuery();
			}
			if (resultSet.next()) {

				book = new Book();
				

				book.setBid(resultSet.getString("bid"));
				book.setBtitle(resultSet.getString("btitle"));
				book.setBauthor(resultSet.getString("bauthor"));
				book.setBcategory(resultSet.getString("bcategory"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return book;
	}

}
