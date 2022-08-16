package br.com.esig.sigtarefas.model;

import br.com.esig.sigtarefas.utils.DBSchemas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "user", schema = DBSchemas.TAREFAS)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_user"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends GenericEntity {
    @Length(max = 255)
    private String name;

    @Length(max = 255)
    @Column(unique = true)
    @NotNull
    private String login;

    @Length(max = 255)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
