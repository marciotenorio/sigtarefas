package br.com.esig.sigtarefas.repository;

import br.com.esig.sigtarefas.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User> {
    public Optional<User> findByLogin(String login);
}
