package com.frigildo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.frigildo.workshopmongo.domain.User;
import com.frigildo.workshopmongo.dto.UserDto;
import com.frigildo.workshopmongo.repositories.UserRepository;
import com.frigildo.workshopmongo.services.exceptions.DataBaseException;
import com.frigildo.workshopmongo.services.exceptions.ResourceNotFound;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		List<User> list = repository.findAll();
		return list;
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFound(id));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public void deleteById(String id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(String id, User obj) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFound(id));
		update(user, obj);
		return repository.save(user);
	}

	private void update(User user, User obj) {

		if (obj.getName() != null) {
			user.setName(obj.getName());
		}

		if (obj.getName() != null) {
			user.setEmail(obj.getEmail());
		}
	}

	public User fromDto(UserDto obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}
