package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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
			RequestDispatcher rd = null;
			if (status.equalsIgnoreCase("success")) {
				request.setAttribute("status", status);
				rd = request.getRequestDispatcher("../insert.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("status", status);
				rd = request.getRequestDispatcher("../insert.jsp");
				rd.forward(request, response);
			}
		}

		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			Student student = studentService.searchStudent(Integer.parseInt(sid));
			request.setAttribute("student", student);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("deleteform"))

		{
			String sid = request.getParameter("sid");
			String status = studentService.deleteStudent(Integer.parseInt(sid));
			RequestDispatcher rd = null;
			if (status.equalsIgnoreCase("Success")) {
				request.setAttribute("status", status);
				rd = request.getRequestDispatcher("../delete.jsp");
				rd.forward(request, response);
			} else if (status.equalsIgnoreCase("Failure")) {
				request.setAttribute(status, response);
				rd = request.getRequestDispatcher("../delete.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", status);
				rd = request.getRequestDispatcher("../delete.jsp");
				rd.forward(request, response);
			}
		}

		if (request.getRequestURI().endsWith("editform")) {

			String sid = request.getParameter("sid");

			Student student = studentService.searchStudent(Integer.parseInt(sid));
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = null;
			// if (student != null) {
			request.setAttribute("student", student);
			rd = request.getRequestDispatcher("../updateform.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("update")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setId(Integer.parseInt(sid));
			student.setName(sname);
			student.setAge(Integer.parseInt(sage));
			student.setAddress(saddr);
			String status = studentService.updateStudent(student);
			RequestDispatcher rd = null;

			if (status.equalsIgnoreCase("success")) {
				rd = request.getRequestDispatcher("../../Update_Success.html");
				System.out.println(rd);
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../../Update_Failure.html");
				rd.forward(request, response);
			}

		}
	}
}
