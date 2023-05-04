package in.ineuron.service;

import java.util.List;

import in.ineuron.dao.IManagementDao;
import in.ineuron.daofactory.ManagementDaoFactory;
import in.ineuron.dto.Book;
import in.ineuron.dto.Management;
import in.ineuron.servicefactory.StudentServiceFactory;

public class ManagementServiceImpl implements IManagementService {

	@Override
	public String mangReg(Management mang) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangReg(mang);
	}

	@Override
	public String mangLogin(String mid, String mpwd) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangLogin(mid, mpwd);
	}

	@Override
	public String mangIssueBookStud(String sid, String bid) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();

		Integer stdtBookcount = managementDao.studentBorrowedbooksCount(sid);

		if (stdtBookcount < 3) {
			String status = managementDao.mangIssueBookStud(sid, bid);

			return status;
		}

		return "limitOver";
	}

	@Override
	public String mangAddBookInLib(Book book) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangAddBookInLib(book);
	}

	@Override
	public Book mangSearchBookInLib(String attr, String val) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangSearchBookInLib(attr, val);
	}

	@Override
	public String mangUpdateBookInLib(Book book) {
		
		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangUpdateBookInLib(book);
	}

	@Override
	public String mangRemoveBookInLib(String bid) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.mangRemoveBookInLib(bid);
	}

	@Override
	public String mangstdtBookSubmiton(String sid, String bid) {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();

		return managementDao.mangstdtBookSubmiton(sid, bid);
	}

	@Override
	public List<Book> availableBooksInLib() {

		IManagementDao managementDao = ManagementDaoFactory.getManagementDao();
		return managementDao.availableBooksInLib();
	}

	@Override
	public Integer searchFineOnBook(String sid, String bid) {

		// <-------------------------------------------------------------------------------------------->

		Integer fine = StudentServiceFactory.getStudentService().studentFines(sid, bid);

		// <------------------------------------------------------------------------------------------->

		return fine;
	}

}
