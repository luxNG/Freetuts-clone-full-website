package com.freetuts.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.freetuts.entity.Author;
//import com.freetuts.entity.Author;
import com.freetuts.repository.AuthorRepository;

@SpringBootApplication
@ComponentScan("com.freetuts")
@EntityScan("com.freetuts.entity")
@EnableJpaRepositories("com.freetuts.repository")
public class FreetutsProjectApplication /* implements CommandLineRunner */ {

	public static void main(String[] args) {
		SpringApplication.run(FreetutsProjectApplication.class, args);
	}

	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	/*
	 * @Override public void run(String... args) throws Exception { // Khi
	 * chươngtrình chạy // Insert vào csdl một user. Author author = new Author();
	 * author.setAuthorName("user");
	 * author.setPassword(passwordEncoder.encode("123")); author.setRoleId(2);
	 * authorRepository.save(author); }
	 */
	 
	 

}
