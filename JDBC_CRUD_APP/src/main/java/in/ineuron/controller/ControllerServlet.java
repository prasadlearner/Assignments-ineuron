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

	}

}
