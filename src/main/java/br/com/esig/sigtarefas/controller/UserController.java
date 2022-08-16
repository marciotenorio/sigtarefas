package br.com.esig.sigtarefas.controller;

import br.com.esig.sigtarefas.model.User;
import br.com.esig.sigtarefas.service.UserService;
import br.com.esig.sigtarefas.utils.EndPoints;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(EndPoints.USER)
public class UserController extends GenericController<User, UserService>{
    public UserController(UserService service) {
        super(service);
    }

    @GetMapping("/passwordValidate")
    public ResponseEntity<Boolean> passwordValidate(@RequestParam String login, @RequestParam String password){
        Optional<User> user = this.service.findByLogin(login);

        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = false;

        valid = service.passwordMatches(password, user.get().getPassword());

        HttpStatus status = valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}
