package com.hanyf.es.upgrade.rest;

import com.hanyf.es.upgrade.entity.ItemDocument;
import com.hanyf.es.upgrade.repository.ItemDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanyf on 2018/1/19 10:10.
 */
@RestController
@RequestMapping("/items")
public class SearchController {

    @Autowired
    private ItemDocumentRepository repository;


    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public ResponseEntity<String> getItem(@PathVariable("id") String id) {
        ItemDocument com = repository.findById(id).orElse(new ItemDocument());
        return new ResponseEntity<>(com.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<String> createItem(@RequestBody ItemDocument document) {
        repository.save(document);
        return new ResponseEntity<>(document.toString(), HttpStatus.OK);
    }

}
