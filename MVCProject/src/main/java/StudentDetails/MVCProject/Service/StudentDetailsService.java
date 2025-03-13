package StudentDetails.MVCProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentDetails.MVCProject.Entity.Student;
import StudentDetails.MVCProject.Repository.StudentDetailsRepository;

@Service
public class StudentDetailsService {

	private StudentDetailsRepository Repository;
	
	@Autowired
	public StudentDetailsService(StudentDetailsRepository Repository) {
		this.Repository = Repository;
	}
	public List<Student> getAllData() {
		return Repository.findAll();
	}
	public Optional<Student> getData(Long id) {
		return Repository.findById(id);
	}
	public Student postData(Student student) {
		return Repository.save(student);
	}
	public Student putData(Student student) {
		return Repository.save(student);
	}
	public void deleteData(Long id) {
		 Repository.deleteById(id);
	}
	public Student search(Student studen) {
		Student student = new Student();
		    student.setId(student.getId());
		    student.setName(student.getName());
		return student;
	}
}
