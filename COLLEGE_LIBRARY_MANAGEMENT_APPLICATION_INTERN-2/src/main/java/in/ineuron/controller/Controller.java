package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Book;
import in.ineuron.dto.Management;
import in.ineuron.dto.Student;
import in.ineuron.service.IManagementService;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.ManagementServiceFactory;
import in.ineuron.servicefactory.StudentServiceFactory;


@WebServlet(urlPatterns = "/controller/*",loadOnStartup = 1)
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// <-----******------- STUDENT FUNCTIONS BEGIN -----******------>
	
	public void studentReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		Student student = new Student();

		student.setSid(request.getParameter("sid"));
		student.setSname(request.getParameter("sname"));
		student.setSlastname(request.getParameter("slastname"));
		student.setSage(Integer.parseInt(request.getParameter("sage")));
		student.setSmail(request.getParameter("smail"));
		student.setSaddress(request.getParameter("saddress"));
		student.setSpassword(request.getParameter("spassword"));
		 
		String status = studentService.studentRegistration(student);
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentRegStatus.jsp");
		requestDispatcher.forward(request, response);

	}
	public void studentLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
     IStudentService studentService = StudentServiceFactory.getStudentService();
		String sid = request.getParameter("sid");
		String password = request.getParameter("spassword");
		String status = studentService.studentLogin(sid, password);
		if(status.equals("Success"))
		{
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentHomePage.html");
		requestDispatcher.forward(request, response);
		}else
		{
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentLoginFailure.jsp");
		requestDispatcher.forward(request, response);
		}
	}
	public void studentBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String sid = request.getParameter("sid");
		List<Book> studentBooks = studentService.studentBooks(sid);
	
		request.setAttribute("books", studentBooks);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentMyBooksResult.jsp");
		requestDispatcher.forward(request, response);
		
		
	}
	public void studentFineOnEachBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");
		Integer fine = studentService.studentFines(sid, bid);
		
		request.setAttribute("fine", fine);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/studentMyFineResult.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public void searchAvailableBooksInLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String attribute = request.getParameter("attribute");
		String value = request.getParameter("value");
		
		Book bookInLib = studentService.bookSearchInLib(attribute, value );
		//System.out.println( bookInLib);
		request.setAttribute("status", bookInLib);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bookSearchResult.jsp");
		requestDispatcher.forward(request, response);
			
	}
	
	//<-----******------STUDENT FUNCTIONS END-----*******---------->
	
	
	
	
	//<-----*****----- MANAGEMENT FUNCTIONS BEGIN ------*****------->
	
    public void managementReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	IManagementService managementService = ManagementServiceFactory.getManagementService();
    	
    	Management mang = new Management();
		mang.setMid(request.getParameter("mid"));
		mang.setMname(request.getParameter("mname"));
		mang.setMemail(request.getParameter("memail"));
		mang.setMpwd(request.getParameter("mpwd"));
		
		String status = managementService.mangReg(mang);
		System.out.println(status);
		
		request.setAttribute("status",status );
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangRegStatus.jsp");
		requestDispatcher.forward(request, response);
    }

	public void managementLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		
		String mid = request.getParameter("mid");
		String password = request.getParameter("mpwd");
		
		String status = managementService.mangLogin(mid, password);
		
		if(status.equals("Success"))
		{
		System.out.println(status);
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangHomePage.html");
		requestDispatcher.forward(request, response);
		}else
		{
		System.out.println(status);	
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangLoginFailure.jsp");
		requestDispatcher.forward(request, response);
		}	
		
	}
	
	public void  mangAddBookInLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		
		Book book = new Book();
		book.setBid(request.getParameter("bid"));
		book.setBtitle(request.getParameter("btitle"));
		book.setBauthor(request.getParameter("bauthor"));
		book.setBcategory(request.getParameter("bcategory"));
		
		String status = managementService.mangAddBookInLib(book);
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangAddBookInLibResult.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	public void mangSearchBookInLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		
		String attribute = request.getParameter("attribute");
		String value = request.getParameter("value");
		Book bookInLib = managementService.mangSearchBookInLib(attribute, value);
		
		request.setAttribute("book", bookInLib);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangBooksSearchResult.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public void mangRemoveBookInLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		
		String bid = request.getParameter("bid");
		
		String status = managementService.mangRemoveBookInLib(bid);
		System.out.println(status);
		 
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangDeleteBookResult.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	public void availableBooksInLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		
		List<Book> availableBooksInLib = managementService.availableBooksInLib();
		
		request.setAttribute("totalBooks", availableBooksInLib);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/booksAvailableInLibResult.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public void mangIssueBookToStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");
		
		String status = managementService.mangIssueBookStud(sid, bid);
		
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangIssueBookResult.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public void mangCollectBookFromStdt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");
		
		String status = managementService.mangstdtBookSubmiton(sid, bid);
		
		request.setAttribute("status", status);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangBookSubmitResult.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
	public void mangSearchForFineOnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		IManagementService managementService = ManagementServiceFactory.getManagementService();
		String sid = request.getParameter("sid");
		String bid = request.getParameter("bid");
		Integer searchFineOnBook = managementService.searchFineOnBook(sid, bid);
		
		request.setAttribute("fine", searchFineOnBook);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mangSearchFineResult.jsp");
		requestDispatcher.forward(request, response);
	}
	
	// <----------*****-----------MANAGEMENT FUNCTIONS END-----------******----------->

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());
		
		String uri = request.getRequestURI();
	
		/*
		 * Students can search books based on AUTHOR, CATEGORY, BOOKTITLE from library
		 * and see their fines , borrowed books
		 */
		
		if(uri.endsWith("reg"))
		{
			studentReg(request,  response);
		}
		if(uri.endsWith("login"))
		{
			studentLogin(request,  response);
		}
		if(uri.endsWith("books"))
		{
			studentBooks(request,  response);
		}
		if(uri.endsWith("fines"))
		{
			studentFineOnEachBook(request,  response);
		}
		if(uri.endsWith("bookSearch"))
		{
			searchAvailableBooksInLib(request,  response);
		}
		
	
		/*
		 * College Management can Add,Remove and Delete books from library
		 * 
		 * Management can also issue Three books per student and collect from them
		 */
		
		if(uri.endsWith("mangReg"))
		{
			managementReg(request,  response);
		}
		if(uri.endsWith("mangLogin"))
		{
			managementLogin(request,  response);
		}
	
		if(uri.endsWith("mangAddBook"))
		{
			mangAddBookInLib(request,  response);
		}
		
		if(uri.endsWith("mangSearchbook"))
		{
			mangSearchBookInLib(request,  response);
		}
		if(uri.endsWith("mangRemovebook"))
		{
			mangRemoveBookInLib(request,  response);
		}
		if(uri.endsWith("availableBooks"))
		{
			availableBooksInLib(request,  response);
		}
		if(uri.endsWith("issueBook"))
		{
			mangIssueBookToStudents(request, response);
		}
		if(uri.endsWith("submitBook"))
		{
			mangCollectBookFromStdt(request, response);
		}
		if(uri.endsWith("mangFineSearch"))
		{
			mangSearchForFineOnBook(request, response);
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doProcess(request,  response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doProcess(request, response);
	}

}
