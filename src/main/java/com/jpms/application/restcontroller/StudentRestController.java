/**
 * 
 */
package com.jpms.application.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpms.application.model.Student;
import com.jpms.application.repository.StudentRepository;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class StudentRestController {
	
	@Autowired(required = true)
	StudentRepository studentRepository;

	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public List<Student> getAllStudent() {
		return studentRepository.findAll(); 
	}
	
	@RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
	public Optional<Student> getStudent(@PathVariable Integer id) {
		return studentRepository.findById(id);
	}

	@RequestMapping(value = "/student",method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
	@RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
	public List<Student> deleteStudent(@PathVariable Integer id) {
		studentRepository.deleteById(id);
		return studentRepository.findAll(); 
	}
	
	@RequestMapping(value = "/student/update/{id}",method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student,@PathVariable Integer id) {
	return	studentRepository.findById(student.getId())
		.map(studentData -> 
		{
			studentData.setName(student.getName());;
			studentData.setEmail(student.getEmail());
			return studentRepository.save(studentData);
		}).orElseGet(() -> {
			student.setId(id);
			return studentRepository.save(student); 
	});
	}
}
