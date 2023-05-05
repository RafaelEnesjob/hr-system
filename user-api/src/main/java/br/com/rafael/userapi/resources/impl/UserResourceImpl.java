package br.com.rafael.userapi.resources.impl;

import br.com.rafael.userapi.domain.User;
import br.com.rafael.userapi.resources.UserResource;
import br.com.rafael.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {

    private final UserService service;
    @Override
    public ResponseEntity<User> findyById(Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
