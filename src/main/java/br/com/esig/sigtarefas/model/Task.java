package br.com.esig.sigtarefas.model;

import br.com.esig.sigtarefas.utils.DBSchemas;
import br.com.esig.sigtarefas.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "task", schema = DBSchemas.TAREFAS)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_task"))
@Data
@EqualsAndHashCode(callSuper = true)
public class Task extends GenericEntity {
    @Length(max = 255)
    @NotNull
    private String title;

    private Long idResponsible;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(pattern = DateUtils.DATETIME_UNTIL_MINUTES)
    @Future
    private LocalDateTime deadline;
}
