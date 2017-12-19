package learning.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listAll() {
		System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
		for(Student student: Student.studentList){
			if(student.getId() == id)
				return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.GET, path = "hello")
	public String hello() {
		return "<html><body><p style=\"color: blue;\">Hello World!</p></body></html>";
	}
}
