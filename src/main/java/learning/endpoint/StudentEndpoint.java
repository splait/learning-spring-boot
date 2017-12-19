package learning.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import learning.error.CustomErrorType;
import learning.model.Student;
import learning.util.DateUtil;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;

@RestController
@RequestMapping("student")
public class StudentEndpoint {

	private final DateUtil dateUtil;

	@Autowired
	public StudentEndpoint(DateUtil dateUtil){
		this.dateUtil = dateUtil;
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "/list")
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<?> listAll() {
		System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
	}
	
	//@RequestMapping(method = RequestMethod.GET, path="/{id}")
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
		Student student = new Student();
		student.setId(id);
		int index = Student.studentList.indexOf(student);
		if(index == -1)
			return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
	}

	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student.studentList.add(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	//@RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping
	public ResponseEntity<?> remove(@RequestBody Student student) {
		Student.studentList.remove(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//@RequestMapping(method = RequestMethod.PUT)
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {
		Student.studentList.remove(student);
		Student.studentList.add(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "hello")
	@GetMapping(path="/hello")
	public String hello() {
		return "<html><body><p style=\"color: blue;\">Hello World!</p></body></html>";
	}
}
