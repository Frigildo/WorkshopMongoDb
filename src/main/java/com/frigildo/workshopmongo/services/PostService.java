package com.frigildo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frigildo.workshopmongo.domain.Post;
import com.frigildo.workshopmongo.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repository;

	public List<Post> findAll() {
		List<Post> list = repository.findAll();
		return list;
	}

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.get();
	}

	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
