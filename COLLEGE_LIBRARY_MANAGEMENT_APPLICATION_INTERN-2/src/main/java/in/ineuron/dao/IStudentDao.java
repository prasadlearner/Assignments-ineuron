package in.ineuron.dao;

import java.sql.Date;
import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.dto.StudentBookTracker;

public interface IStudentDao {

	public String studentRegistration(Student student);

	public String studentLogin(String sid, String spassword);

	public List<Book> studentBooks(String sid);

	public Integer studentFines(String sid, String bid);
	
	public StudentBookTracker getBorrowDateAndSubmDate(String sid, String bid);
	
	public String addFineIntoDB(Integer fine,String sid, String bid); 
	
	public Book bookSearchInLib(String attribute, String value);
}
