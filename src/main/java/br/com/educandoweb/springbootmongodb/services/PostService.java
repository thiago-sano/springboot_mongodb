package br.com.educandoweb.springbootmongodb.services;

import br.com.educandoweb.springbootmongodb.domain.Post;
import br.com.educandoweb.springbootmongodb.repository.PostRepository;
import br.com.educandoweb.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        // Consulta simples com Query Methods
        // return repo.findByTitleContainingIgnoreCase(text);

        // Consulta simples com @Query
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        // Por padrão, a comparação seria feita baseado em 00:00 do dia informado. Para contornar, foi adicionado 24h.
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
