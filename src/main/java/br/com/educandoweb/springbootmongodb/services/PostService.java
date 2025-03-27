package br.com.educandoweb.springbootmongodb.services;

import br.com.educandoweb.springbootmongodb.domain.Post;
import br.com.educandoweb.springbootmongodb.repository.PostRepository;
import br.com.educandoweb.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
