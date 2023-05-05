package br.com.rafael.userapi.resources;

import br.com.rafael.userapi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<User> findyById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<User>> findAll();
}
