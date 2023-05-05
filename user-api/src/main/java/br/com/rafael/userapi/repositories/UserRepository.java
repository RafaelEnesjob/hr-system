package br.com.rafael.userapi.repositories;

import br.com.rafael.userapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
