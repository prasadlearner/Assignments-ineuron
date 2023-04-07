package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Management;
import in.ineuron.dto.StudentBookTracker;
import in.ineuron.util.JdbcUtil;

public class ManagementDaoImpl implements IManagementDao {

	
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		@Override
		public String mangReg(Management management) {
			String sqlQuery = "";
			int i = 0;
			String msg = "";

			try {
				connection = JdbcUtil.getJdbcConnection();
				sqlQuery = "INSERT INTO management(mid, mname, memail, mpwd) VALUES(?,?,?,?)";

				if (connection != null) {
					pstmt = connection.prepareStatement(sqlQuery);
					pstmt.setString(1, management.getMid());
					pstmt.setString(2, management.getMname());
					pstmt.setString(3, management.getMemail());
					pstmt.setString(4, management.getMpwd());
					if (pstmt != null) {
						i = pstmt.executeUpdate();
					}
				}

			} catch (SQLException | IOException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (i == 1) {
				msg = "success";
			} else
				msg = "failed";

			return msg;
		}

	@Override
	public String mangLogin(String mid, String mpwd) {
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
			try {
				connection = JdbcUtil.getJdbcConnection();
				if (connection != null) {	
					pstmt = connection.prepareStatement("SELECT mpwd FROM management WHERE mid = ?");
				}
				if (pstmt != null) {
					pstmt.setString(1, mid);
					
					resultSet = pstmt.executeQuery();
				}
				if(resultSet.next())
				{
					String mpassword = resultSet.getString("mpwd");
					if(mpassword.equals(mpwd))
					{
						return "Success";
					}
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
		return "Failure";
	}
	


	@Override
	public String mangAddBookInLib(Book book) {
		String msg = "";
		Boolean flag = true;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "INSERT INTO book(bid,btitle,bauthor,bcategory) VALUES(?,?,?,?)";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, book.getBid());
					pstmt.setString(2, book.getBtitle());
					pstmt.setString(3, book.getBauthor());
					pstmt.setString(4, book.getBcategory());

					flag = pstmt.execute();
					if (!flag) {
						msg = "success";
					} else
						msg = "failed";
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Book mangSearchBookInLib(String attribute, String value) {
		
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Book book = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				
				
				
				pstmt = connection.prepareStatement("SELECT * FROM  book WHERE " + attribute + " LIKE  ? ");
				
			}
			if (pstmt != null) {
				
				pstmt.setString(1, value);
				
				
				resultSet = pstmt.executeQuery();
			}
			if(resultSet.next())
			{
				
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

	@Override
	public String mangUpdateBookInLib(Book book) {
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		return null;
	}

	@Override
	public String mangRemoveBookInLib(String bid) {
		
		String msg = "";
		int count = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "DELETE FROM book WHERE bid = ?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, bid);

					count = pstmt.executeUpdate();
					if (count == 1) {
						msg = "success";
					}else
					{
						msg = "notfound";
						
					}
				}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			msg = "failed";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "failed";
		}
		return msg;
	}


	@Override
	public String mangstdtBookSubmiton(String sid, String bid) {
		
		int count;

		try {
			connection = JdbcUtil.getJdbcConnection();
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

			String sqlQuery = "UPDATE studentbooktracker SET submitdate=?, fine=? WHERE sid=? AND bid=?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setDate(1, date);
					pstmt.setInt(2, 0);
					pstmt.setString(3, sid);
					pstmt.setString(4, bid);
					count = pstmt.executeUpdate();
					if (count == 1) {
						return  "success";
					}
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}

	@Override
	public String mangIssueBookStud(String sid, String bid) {
		
		String msg = "";
		int i = 0;

		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlQuery = "INSERT INTO studentbooktracker(sid, bid, borrowdate, fine) VALUES(?,?,?,?)";
			java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);
				if (pstmt != null) {
					pstmt.setString(1, sid);
					pstmt.setString(2, bid);
					pstmt.setDate(3, date);
					pstmt.setInt(4, 0);

					i = pstmt.executeUpdate();
					if (i == 1) {
						msg = "success";
					} else
						msg = "failed";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Book> availableBooksInLib() {
		
			List<Book> books = new ArrayList<Book>();
			try {
				connection = JdbcUtil.getJdbcConnection();
				String sqlQuery = "SELECT bid, btitle, bauthor, bcategory FROM book";
				if (connection != null) {
					pstmt = connection.prepareStatement(sqlQuery);

					if (pstmt != null) {
						resultSet = pstmt.executeQuery();
						while(resultSet.next()) {
							Book book = new Book();
							System.out.println(resultSet);
							book.setBid(resultSet.getString("bid"));
							book.setBauthor(resultSet.getString("bauthor"));
							book.setBtitle(resultSet.getString("btitle"));
							book.setBcategory(resultSet.getString("bcategory"));
							books.add(book);
							System.out.println(book.toString());
						}
					}
				}

			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return books;
		}

	
	@Override
	public Integer studentBorrowedbooksCount(String sid) {
		Integer count = 0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			//String sqlQuery = "SELECT COUNT(*)  FROM studentbooktracker WHERE sid = ?";
			String sqlQuery = "SELECT sid FROM studentbooktracker WHERE sid = ?";
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuery);

				if (pstmt != null) {

					pstmt.setString(1, sid);
					resultSet = pstmt.executeQuery();
					while (resultSet.next()) {
						
						String sid_s =  resultSet.getString("sid");
					
						if(sid_s != null)
						{
							count++;
						}
					}	
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return count;
	}

}


					
	
	
