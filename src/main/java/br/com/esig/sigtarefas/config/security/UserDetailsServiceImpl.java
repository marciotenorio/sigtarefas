package br.com.esig.sigtarefas.config.security;

import br.com.esig.sigtarefas.config.security.UserDetailsData;
import br.com.esig.sigtarefas.model.User;
import br.com.esig.sigtarefas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }
        return new UserDetailsData(user);
    }
}
