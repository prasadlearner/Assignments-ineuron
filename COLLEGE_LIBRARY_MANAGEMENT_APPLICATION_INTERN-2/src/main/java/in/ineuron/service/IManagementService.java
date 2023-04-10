package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.Book;
import in.ineuron.dto.Management;
import in.ineuron.dto.StudentBookTracker;

public interface IManagementService {

	public String mangReg(Management mang);

	public String mangLogin(String mid, String mpwd);

	public String mangIssueBookStud(String sid, String bid);

	public String mangAddBookInLib(Book book);

	public String mangUpdateBookInLib(Book book);

	public String mangRemoveBookInLib(String bid);

	public Book mangSearchBookInLib(String attr, String val);

	public String mangstdtBookSubmiton(String sid, String bid);

	public List<Book> availableBooksInLib();

	public Integer searchFineOnBook(String sid, String bid);

}
