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

import com.jpms.application.model.Users;
import com.jpms.application.repository.UserRepository;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/rest")
public class UserRestController {
	
	@Autowired(required = true)
	UserRepository userRepository;

	@RequestMapping(value = "/usersdetails",method = RequestMethod.GET)
	public List<Users> getAllUsers() {
		return userRepository.findAll(); 
	}
	
	@RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
	public Optional<Users> getUser(@PathVariable Integer id) {
		return userRepository.findById(id);
	}

	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public List<Users> saveUser(@RequestBody Users users) {
		userRepository.save(users);
		return userRepository.findAll(); 
	}
	
	@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
	public List<Users> deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return userRepository.findAll(); 
	}
	
	@RequestMapping(value = "/users/update/{id}",method = RequestMethod.PUT)
	public Users updateUser(@RequestBody Users users,@PathVariable Integer id) {
	return	userRepository.findById(users.getId())
		.map(user -> {
			user.setSalary(users.getSalary());
			user.setName(users.getName());;
			user.setAddress(users.getAddress());
			return userRepository.save(user);
		}).orElseGet(() -> {
			users.setId(id);
			return userRepository.save(users); 
	});
	}
}
