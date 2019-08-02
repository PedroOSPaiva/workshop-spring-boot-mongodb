package com.pedropaiva.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedropaiva.workshopmongo.domain.User;
import com.pedropaiva.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		userRepository.deleteAll();
		
		User maria = new User(null,"Maria Brown","maria@gmai.com");
		User alex = new User(null,"Alex Green","alex@gmai.com");
		User bob = new User(null,"Bob Grey","bob@gmai.com");
		User jarlene = new User(null,"Jarlene Maria","jarlenemariaoliveira@gmail.com");
		
		
		userRepository.save(Arrays.asList(maria, alex, bob, jarlene));
		
	}

	
}
