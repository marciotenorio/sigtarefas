package br.com.esig.sigtarefas.service;

import br.com.esig.sigtarefas.model.GenericEntity;
import br.com.esig.sigtarefas.repository.GenericRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Top level service para persistências padrão.
 *
 * @param <T> Modelo da entidade.
 *
 * @param <R> Repositório da entidade.
 */
@RequiredArgsConstructor
public class GenericService<T extends GenericEntity, R extends GenericRepository<T>> {

    protected final R repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public void save(T entity){
        entity.setActive(true);
        repository.save(entity);
    }

    public void delete(T entity){
        repository.delete(entity);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public T update(T entity){
        return repository.save(entity);
    }
}
