package br.com.esig.sigtarefas.repository;

import br.com.esig.sigtarefas.model.Priority;
import br.com.esig.sigtarefas.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends GenericRepository<Task> {

    @Query("select t from Task t " +
            "where t.title = ?1 " +
                "and t.idResponsible = ?2 " +
                "and t.priority = ?3" +
                "and t.deadline = ?4")
    public List<Task> findAllWithParams(String title,
                                        Long responsible,
                                        Priority priority,
                                        LocalDateTime deadline);
}
