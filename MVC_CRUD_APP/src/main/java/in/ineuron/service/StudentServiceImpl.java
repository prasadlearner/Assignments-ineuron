package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;

public class StudentServiceImpl implements IStudentService {
     IStudentDao stdDao;
	@Override
	public String addStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer id) {
		stdDao =StudentDaoFactory.getStudentDao();	
		return stdDao.searchStudent(id);
	}

	@Override
	public String updateStudent(Student stdUpdate) {
       stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(stdUpdate);
	}

	@Override
	public String deleteStudent(Integer id) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(id);
	}

}
