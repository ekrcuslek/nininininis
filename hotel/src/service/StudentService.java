package service;
import java.util.List;

import dao.StudentDAO;
import domain.Student;
public class StudentService {
	private StudentDAO studentDAO = new StudentDAO();

	// C
	public void create() {
		studentDAO.createTable();
	}
	
	// R
	public Student selectOne(int studentId) {
		return studentDAO.selectOne(studentId);
	}
	
	public List<Student> selectAll() {
		return studentDAO.selectAll();
	}
	
	// U
	public void update(Student student) {
		studentDAO.update(student);
	}
	
	// D
	public void delete(int studentId) {
		studentDAO.delete(studentId);
	}
	public int countvisit() {
		int count=studentDAO.countvisit();
		return count;
	}
}
