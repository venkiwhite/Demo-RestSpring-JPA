/**
 * 
 */
package com.jpms.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpms.application.model.Department;
import com.jpms.application.model.Student;
import com.jpms.application.model.Users;


/**
 * @author Administrator
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
