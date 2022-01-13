package com.gefersonholdorf.dscatalog.resources;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gefersonholdorf.dscatalog.entities.Category;
import com.gefersonholdorf.dscatalog.services.CategoryService;

@RestController
@RequestMapping (value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService services;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll (){
		List <Category> list = services.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
