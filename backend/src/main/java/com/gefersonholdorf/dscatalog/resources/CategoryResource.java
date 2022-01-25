package com.gefersonholdorf.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gefersonholdorf.dscatalog.dto.CategoryDTO;
import com.gefersonholdorf.dscatalog.services.CategoryService;

@RestController
@RequestMapping (value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService services;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll (){
		List <CategoryDTO> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById (@PathVariable Long id){
		CategoryDTO dto = services.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert (@RequestBody CategoryDTO dto) {
		dto = services.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> update (@PathVariable Long id, @RequestBody CategoryDTO dto) {
		dto = services.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
