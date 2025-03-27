package br.com.educandoweb.springbootmongodb.repository;

import br.com.educandoweb.springbootmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
