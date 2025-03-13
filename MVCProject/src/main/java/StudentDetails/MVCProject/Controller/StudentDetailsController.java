package StudentDetails.MVCProject.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import StudentDetails.MVCProject.Entity.Student;
import StudentDetails.MVCProject.Service.StudentDetailsService;

@Controller
@RequestMapping("/student")
public class StudentDetailsController {

	private StudentDetailsService service;
	@Autowired
	public StudentDetailsController(StudentDetailsService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String getAllData(Model model) {
		model.addAttribute("student",service.getAllData());
		 return"student";
	}
	
	@GetMapping("/add")
	public String details() {
		return"details";
	}
	
	@PostMapping("/added")// Add product "View"
    public String addProduct(@ModelAttribute Student student) {
        service.postData(student);
        return "redirect:/student/"; // redirects to the list of products
    }

	@GetMapping("/edit")
	public String getData(Model model,@RequestParam Long id) {
		Optional<Student> student= service.getData(id);
		model.addAttribute("student", student.get());
		 return"update";
	}
	
	@PostMapping("/update")
	public String putDAta(@ModelAttribute Student student) {
		service.putData(student);
		 return"redirect:/student/";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		 service.deleteData(id);
		 return"redirect:/student/";
	}
	@GetMapping("/search")
	public Student search(@ModelAttribute Student student) {
		return service.search(student);
	}
}
