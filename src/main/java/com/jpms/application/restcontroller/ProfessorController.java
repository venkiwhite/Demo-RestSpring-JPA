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

import com.jpms.application.model.Department;
import com.jpms.application.model.Professor;
import com.jpms.application.repository.DepartmentRepository;
import com.jpms.application.repository.ProfessorRepository;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class ProfessorController {
	
	@Autowired(required = true)
	ProfessorRepository professorRepository;
	DepartmentRepository departmentRepository;


	@RequestMapping(value = "/professor",method = RequestMethod.GET)
	public List<Professor> getAllProfessor() {
		return professorRepository.findAll(); 
	}
	
	@RequestMapping(value = "/professor/{id}",method = RequestMethod.GET)
	public Optional<Professor> getProfessor(@PathVariable Integer id) {
		return professorRepository.findById(id);
	}

	@RequestMapping(value = "/professor",method = RequestMethod.POST)
	public Professor saveProfessor(@RequestBody Professor professor) {
		
		Optional<Department> department = departmentRepository.findById(professor.getDepartment().getId());
		
		// Professor professorData = new Prof
		if(department.isPresent()) {
			professor.setDepartment(department.get());		
			
			professorRepository.save(professor);
		}
		
		return professor;
	}
	
	@RequestMapping(value = "/professor/{id}",method = RequestMethod.DELETE)
	public List<Professor> deleteProfessor(@PathVariable Integer id) {
		professorRepository.deleteById(id);
		return professorRepository.findAll(); 
	}
	
	@RequestMapping(value = "/professor/{id}",method = RequestMethod.PUT)
	public Professor updateProfessor(@RequestBody Professor professor,@PathVariable Integer id) {
	return	professorRepository.findById(professor.getId())
		.map(professorData -> 
		{
			professorData.setName(professor.getName());;
			return professorRepository.save(professorData);
		}).orElseGet(() -> {
			professor.setId(id);
			return professorRepository.save(professor); 
	});
	}
}
