package in.ineuron.daofactory;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dao.StudenDaoImpl;

public class StudentDaoFactory {
private StudentDaoFactory()
{
	
}
private static IStudentDao studentDao = null;
public static IStudentDao getStudentDao()
{
	if(studentDao== null)
	{
	studentDao = new StudenDaoImpl();
	}
	return studentDao;
}
}
