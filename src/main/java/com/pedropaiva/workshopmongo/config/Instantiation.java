package com.pedropaiva.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedropaiva.workshopmongo.domain.Post;
import com.pedropaiva.workshopmongo.domain.User;
import com.pedropaiva.workshopmongo.repository.PostRepository;
import com.pedropaiva.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null,"Maria Brown","maria@gmai.com");
		User alex = new User(null,"Alex Green","alex@gmai.com");
		User bob = new User(null,"Bob Grey","bob@gmai.com");
		User jarlene = new User(null,"Jarlene Maria","jarlenemariaoliveira@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",maria);
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia !","Acordei feliz hoje !",maria);
		
		userRepository.save(Arrays.asList(maria, alex, bob, jarlene));
		postRepository.save(Arrays.asList(post1,post2));
	}

	
}
