package in.ineuron.daofactory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudenDaoImpl;
//abstraction
public class StudentDaoFactory {
private StudentDaoFactory()
{
	
}
private static IStudentDao studentDao = null;
public static IStudentDao getStudentDao()
{
	// Singleton pattern code
	if(studentDao== null)
	{
	studentDao = new StudenDaoImpl();
	}
	return studentDao;
}
}
