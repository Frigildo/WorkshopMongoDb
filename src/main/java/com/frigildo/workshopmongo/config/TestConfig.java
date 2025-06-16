package com.frigildo.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.frigildo.workshopmongo.domain.Post;
import com.frigildo.workshopmongo.domain.User;
import com.frigildo.workshopmongo.dto.Author;
import com.frigildo.workshopmongo.dto.CommentDto;
import com.frigildo.workshopmongo.repositories.PostRepository;
import com.frigildo.workshopmongo.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User u1 = new User(null, "Alex Green", "alex@gmail.com");
		User u2 = new User(null, "Maria Brown", "maria@gmail.com");
		User u3 = new User(null, "Bob Gray", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		postRepository.deleteAll();

		Post p1 = new Post(null, Instant.parse("2025-03-25T12:30:45Z"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", new Author(u2));
		Post p2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new Author(u2));

		postRepository.saveAll(Arrays.asList(p1, p2));

		u2.getPosts().addAll(Arrays.asList(p1, p2));

		CommentDto c1 = new CommentDto("Boa viagem mano!", Instant.parse("2018-03-21T00:00:00Z"), new Author(u1));
		CommentDto c2 = new CommentDto("Aproveite!", Instant.parse("2018-03-22T00:00:00Z"), new Author(u3));

		p1.getComments().addAll(Arrays.asList(c1, c2));

		postRepository.save(p1);

		userRepository.save(u2);
	}

}
