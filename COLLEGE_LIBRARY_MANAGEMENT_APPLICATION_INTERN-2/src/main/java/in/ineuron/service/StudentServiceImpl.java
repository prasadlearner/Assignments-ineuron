package in.ineuron.service;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Book;
import in.ineuron.dto.Student;
import in.ineuron.dto.StudentBookTracker;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String studentRegistration(Student student) {
	IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studentRegistration(student);
	}

	@Override
	public String studentLogin(String sid, String spassword) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studentLogin(sid, spassword);
	}

	@Override
	public List<Book> studentBooks(String sid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.studentBooks(sid);
	}

	@Override
	public Integer studentFines(String sid, String bid) {
		java.sql.Date date1 = null;
		java.sql.Date date2 = null;
		Integer fineAmount = 0;
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		
	    // getting the date from database
		StudentBookTracker bookTracker = getBorrowDateAndSubmDate(sid,bid);
	
		if(bookTracker != null) {
          System.out.println(bookTracker);
             date1  = bookTracker.getBorrowdate();
             date2  = bookTracker.getSubmitdate();
             System.out.println(date1);
            
           
             
             if(date2 == null) 
             {
            	 System.out.println("_________________________________________________");
             date2 = Date.valueOf(LocalDate.now());
             System.out.println(date2);
                
           
			long diff = date2.getTime() - date1.getTime();
			int daysDiff = (int) (diff / (24 * 60 * 60 * 1000) % 365);

	   // after the 15 days fine was calculated 10Rs/day
			 fineAmount = (daysDiff - 15) * 10;
             
			if(fineAmount >0)
			{
				String dbFineStatus = addFineIntoDB(fineAmount,sid,bid);
				System.out.println(dbFineStatus);
				
				return fineAmount;
			}
			else 
			{
				String dbFineStatus = addFineIntoDB(0,sid,bid);
				System.out.println(dbFineStatus);
				
				return 0;
			}
			
			}
            }
     		 
		return 999;
		
	}

	@Override
	public StudentBookTracker getBorrowDateAndSubmDate(String sid, String bid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		
		return  studentDao.getBorrowDateAndSubmDate(sid, bid);
	}

	@Override
	public String addFineIntoDB(Integer fine,String sid, String bid) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
		
		return studentDao.addFineIntoDB(fine, sid, bid) ;
	}

	@Override
	public Book bookSearchInLib(String attribute,String value) {
		IStudentDao studentDao = StudentDaoFactory.getStudentDao();
				
		return studentDao.bookSearchInLib(attribute, value);
	}

}
