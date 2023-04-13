package com.spro.manyToMany;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spro.entity.Role;
import com.spro.entity.User;
import com.spro.repository.RoleRepository;
import com.spro.repository.UserRepository;

@SpringBootTest
public class ManyToManyTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;

//	@Test

	void saveUser() {
		User user = new User();
		user.setFirstName("Pasha");
		user.setLastName("Tro");
		user.setEmail("hhro@gmail.com");
		user.setPassword("pord123");
		user = userRepo.save(user);
		
		Role admin = new Role();
		Role customer = new Role();
		admin.setName("ROLE_ADMIN");
		customer.setName("ROLE_CUSTOMER");
		
//		System.out.println(customer);
//		System.out.println(admin);
		user.getRoles().add(admin);
		user.getRoles().add(customer);
		
		User savedUser =  userRepo.save(user);
		System.out.println(savedUser);
	}
	
//	@Test
	void updateUser() {
		User user = userRepo.findById(1L).get();
		user.setEmail("newEmail@eee.com");
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		
		user.getRoles().add(roleUser);
		
		userRepo.save(user);
	}
	
//	@Test
	void fetchUser() {
		User user = userRepo.findById(1L).get();
		System.out.println(user.getEmail());
		user.getRoles().forEach((r)->System.out.println(r.getName()) );
	}
	
//	@Test
	void deleteUser() {
		userRepo.deleteById(7L);
	}
	
	//----------------------bidirectional test-----------------
	
	
//	@Test
	void saveRole() {
		User user = new User();
		user.setFirstName("Dasha");
		user.setLastName("AAAro");
		user.setEmail("AAro@gmail.com");
		user.setPassword("1234");
		
		User user2 = new User();
		user2.setFirstName("Krisha");
		user2.setLastName("BBBro");
		user2.setEmail("BBBro@gmail.com");
		user2.setPassword("4321");
		
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		
		role.getUsers().add(user2);
		role.getUsers().add(user);
		
		user.getRoles().add(role);
		user2.getRoles().add(role);
		
		roleRepo.save(role);
	}
	
	@Test
	void fetchRole() {
		List<Role> roles = roleRepo.findAll();
//		roles.forEach(r ->{
//			System.out.println( r.getName());
//			r.getUsers().forEach(u-> System.out.println(u.getFirstName()));
//		});
	}
	
}
