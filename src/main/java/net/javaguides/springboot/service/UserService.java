
package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	User findByEmail(String email);
	void updatePassword(User user, String newPassword);
	User saveAdmin(User user);
	Iterable<User> findAllUsers();
	void deleteUserById(Long id);

}
