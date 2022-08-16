package br.com.esig.sigtarefas.service;

import br.com.esig.sigtarefas.model.User;
import br.com.esig.sigtarefas.repository.GenericRepository;
import br.com.esig.sigtarefas.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends GenericService<User, UserRepository>{

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        super.save(user);
    }

    public Optional<User> findByLogin(String login){
        return this.repository.findByLogin(login);
    }

    public Boolean passwordMatches(String firstPassword, String secondPassword){
        return passwordEncoder.matches(firstPassword, secondPassword);
    }
}
