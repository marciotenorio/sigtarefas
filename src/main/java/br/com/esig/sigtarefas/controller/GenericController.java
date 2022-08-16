package br.com.esig.sigtarefas.controller;

import br.com.esig.sigtarefas.model.GenericEntity;
import br.com.esig.sigtarefas.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.OPTIONS, RequestMethod.DELETE })
@SuppressWarnings({"raw", "unchechked"})
@RequiredArgsConstructor
public class GenericController <T extends GenericEntity, S extends GenericService>{

    protected final S service;

    @GetMapping
    @SuppressWarnings("unchecked")
    public List<T> findAll(){
        return service.findAll();
    }

    @PostMapping
    @SuppressWarnings("unchecked")
    public void save(@RequestBody T entity){
        service.save(entity);
    }

    @DeleteMapping
    @SuppressWarnings("unchecked")
    public void delete(T entity){
        service.delete(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping
    @SuppressWarnings("unchecked")
    public @ResponseBody ResponseEntity<Object> update(T entity){
        T result = (T) service.update(entity);
        return ResponseEntity.ok(entity);
    }
}
