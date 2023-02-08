package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		System.out.println(request.getRequestURI());
		System.out.println(request.getPathInfo());

		if (request.getRequestURL().toString().endsWith("addform")) {

			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setName(sname);
			student.setAge(Integer.parseInt(sage));
			student.setAddress(saddr);

			String status = studentService.addStudent(student);
			PrintWriter out = response.getWriter();
			if (status.equalsIgnoreCase("success")) {
				out.println("<h1 style='color:green; text-align:center;'>Registration Successfull</h1>");
			} else {
				out.println("<h1 style='color:orange; text-align:center;'>Registration Failed</h1>");
			}
			out.close();
		}

		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			Student student = studentService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				out.println("<html>");
				out.println("<body>");
				out.println("<center>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr> <th> ID </th> <td>" + student.getId() + "</td></tr>");
				out.println("<tr> <th> Name </th> <td>" + student.getName() + "</td></tr>");
				out.println("<tr> <th> AGE </th> <td>" + student.getAge() + "</td></tr>");
				out.println("<tr> <th>ADDRESS </th> <td>" + student.getAddress() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
			} else {
				out.println(
						"<h1 style='color:orange; text-align:center'>RECORD NOT AVAILABLE FOR THE GIVEN STUDENT ID :"
								+ sid + "</h1>");
			}
			out.close();

		}

		if (request.getRequestURI().endsWith("deleteform"))

		{
			PrintWriter out = response.getWriter();
			String sid = request.getParameter("sid");
			String status = studentService.deleteStudent(Integer.parseInt(sid));
			if (status.equalsIgnoreCase("Success")) {
				out.println("<body>");
				out.println("<h1 style='color:green; text-align:center'>RECORD DELETED SUCCESSFULLY</h1>");
				out.println("</body>");
			} else if (status.equalsIgnoreCase("failure")) {
				out.println("<body>");
				out.println("<h1 style='color:orange; text-align:center'>RECORD DELETION FAILED</h1>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<h1 style='color:orange; text-align:center'>RECORD NOT FOUND FOR DELETION</h1>");
				out.println("</body>");
			}
			out.close();
		}

		if (request.getRequestURI().endsWith("editform")) {

			String sid = request.getParameter("sid");

			Student student = studentService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			if (student != null) {

				out.println("<body>");
				out.println("<form method='POST' action='http://localhost:9999/JDBC_CRUD_APP/controller/updateform'>");
				out.println("<center>");
				out.println("<table>");
				out.println("<tr><th>SID</th><td><input type='number' name='sid' value='" + student.getId()
						+ "' readonly /></td></tr>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getName()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='number' name='sage' value='" + student.getAge()
						+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + student.getAddress()
						+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</form>");
				out.println("</body>");
			} else {
				out.println("<body>");
				out.println("<h1 style='color:orange; text-align:center'>RECORD NOT FOUND FOR THE GIVEN ID :" + sid
						+ "</h1>");
				out.println("/<body>");
			}
			out.close();
		}

		if (request.getRequestURI().endsWith("updateform")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setId(Integer.parseInt(sid));
			student.setName(sname);
			student.setAge(Integer.parseInt(sage));
			student.setAddress(saddr);
			PrintWriter out = response.getWriter();
			String status = studentService.updateStudent(student);
			if (status.equalsIgnoreCase("success")) {
				out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATED SUCCESSFULLY</h1>");
			} else {
				out.println("<h1 style='color:orange; text-align:center;'>STUDENT RECORD UPDATION FAILED</h1>");
			}
			out.close();

		}
	}
}
