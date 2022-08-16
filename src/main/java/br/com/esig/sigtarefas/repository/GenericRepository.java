package br.com.esig.sigtarefas.repository;

import br.com.esig.sigtarefas.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T extends GenericEntity> extends JpaRepository<T, Long> {
}
