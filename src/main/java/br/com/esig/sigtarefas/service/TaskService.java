package br.com.esig.sigtarefas.service;

import br.com.esig.sigtarefas.model.Task;
import br.com.esig.sigtarefas.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService extends GenericService<Task, TaskRepository>{

    public TaskService(TaskRepository repository) {
        super(repository);
    }

    @Override
    public void save(Task entity) {
        super.save(entity);
    }

    public List<Task> findAllWithParams(Task task){
        return repository.findAllWithParams(task.getTitle(),
                task.getIdResponsible(),
                task.getPriority(),
                task.getDeadline());
    }
}
