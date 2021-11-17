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
import com.jpms.application.repository.DepartmentRepository;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class DepartmentController {
	
	@Autowired(required = true)
	DepartmentRepository departmentRepository;

	@RequestMapping(value = "/department",method = RequestMethod.GET)
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll(); 
	}
	
	@RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
	public Optional<Department> getDepartment(@PathVariable Integer id) {
		return departmentRepository.findById(id);
	}

	@RequestMapping(value = "/department",method = RequestMethod.POST)
	public Department saveDepartment(@RequestBody Department department) {
		departmentRepository.save(department);
		return department;
	}
	
	@RequestMapping(value = "/department/{id}",method = RequestMethod.DELETE)
	public List<Department> deleteDepartment(@PathVariable Integer id) {
		departmentRepository.deleteById(id);
		return departmentRepository.findAll(); 
	}
	
	@RequestMapping(value = "/department/{id}",method = RequestMethod.PUT)
	public Department updateDepartment(@RequestBody Department department,@PathVariable Integer id) {
	return	departmentRepository.findById(department.getId())
		.map(departmentData -> 
		{
			departmentData.setName(department.getName());;
			return departmentRepository.save(departmentData);
		}).orElseGet(() -> {
			department.setId(id);
			return departmentRepository.save(department); 
	});
	}
}
