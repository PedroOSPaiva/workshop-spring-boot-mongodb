package com.pedropaiva.workshopmongo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedropaiva.workshopmongo.Services.exception.ObjectNotFoundException;
import com.pedropaiva.workshopmongo.domain.User;
import com.pedropaiva.workshopmongo.dto.UserDTO;
import com.pedropaiva.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.delete(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}
