package com.hanyf.es.upgrade.rest;

import com.hanyf.es.upgrade.entity.ProductTestDto;
import com.hanyf.es.upgrade.repository.ProductTestRepository;
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
@RequestMapping("/product")
public class ProductSearchController {

    @Autowired
    private ProductTestRepository repository;


    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public ResponseEntity getItem(@PathVariable("id") String id) {
        ProductTestDto com = repository.findById(id).orElse(new ProductTestDto());
        return new ResponseEntity(com.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity createItem(@RequestBody ProductTestDto document) {
        repository.save(document);

        return new ResponseEntity(document.toString(), HttpStatus.OK);
    }

}
