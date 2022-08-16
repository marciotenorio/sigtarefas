package br.com.esig.sigtarefas.controller;

import br.com.esig.sigtarefas.model.Task;
import br.com.esig.sigtarefas.service.TaskService;
import br.com.esig.sigtarefas.utils.EndPoints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndPoints.TASK)
public class TaskController extends GenericController<Task, TaskService>{
    public TaskController(TaskService service) {
        super(service);
    }

    @GetMapping("/withParams")
    public List<Task> findAllWithParams(@RequestBody Task task) {
        return service.findAllWithParams(task);
    }
}
