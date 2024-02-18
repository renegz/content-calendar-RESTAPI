package com.renegz.contentcalendar.controller;

import com.renegz.contentcalendar.model.Content;
import com.renegz.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController //anotacion para asignar peticiones http a cada metodo
@RequestMapping("/api/content") //define la ruta para cada metodo get
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    //@pathvariable indica que tome la variable que se envia en la ruta
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found")) ;
    }

    @ResponseStatus(HttpStatus.CREATED) //Devuelve en la respuesta es estado de creado (codigo 201)
    @PostMapping("")//ruta para un metodo post
    public void create(@RequestBody Content content){
        //@RequestBody indica que el parametro debe venir en el body de la web
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")//ruta para un metodo post
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.delete(id);
    }

}
