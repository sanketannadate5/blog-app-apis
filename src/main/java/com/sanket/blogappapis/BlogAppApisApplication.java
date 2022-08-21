package com.sanket.blogappapis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sanket.blogappapis.commonUtils.CommonConstansts;
import com.sanket.blogappapis.entity.Role;
import com.sanket.blogappapis.repositories.RoleRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("sanket"));
		
		try {
			Role role = new Role();
			role.setRoleId(CommonConstansts.USER_ROLE_ADMIN);
			role.setName(CommonConstansts.USER_ROLE_ADMIN_NAME);
			
			Role role2 = new Role();
			role2.setRoleId(CommonConstansts.USER_ROLE_NORMAL);
			role2.setName(CommonConstansts.USER_ROLE_NORMAL_NAME);
			
			List<Role> roles = List.of(role,role2);
			List<Role> savedRoles =roleRepo.saveAll(roles);
			
			savedRoles.forEach(r->{
				System.out.println(r.getRoleId()+ " "+ r.getName());
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
