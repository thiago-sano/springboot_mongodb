package br.com.educandoweb.springbootmongodb.repository;

import br.com.educandoweb.springbootmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    // Consulta simples com Query Methods
    // https://docs.spring.io/spring-data/mongodb/reference/
    // https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
    // https://docs.spring.io/spring-data/data-document/docs/current/reference/html/#mongodb.repositories.queries
    List<Post> findByTitleContainingIgnoreCase(String text);

    // Consulta simples com @Query
    // https://docs.spring.io/spring-data/mongodb/reference/
    // https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
    // https://www.mongodb.com/pt-br/docs/manual/reference/operator/query/regex/
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
}
