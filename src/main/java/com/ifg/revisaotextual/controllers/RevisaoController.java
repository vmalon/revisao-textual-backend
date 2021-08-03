package com.ifg.revisaotextual.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ifg.revisaotextual.entities.Revisao;
import com.ifg.revisaotextual.services.RevisaoService;

@RestController
@RequestMapping("/api/revisao")
public class RevisaoController {

	@Autowired
	private RevisaoService service;
	
	@GetMapping
	public ResponseEntity<List<Revisao>> findAll(){
		List<Revisao>  listaAluno = service.findAll();
		return ResponseEntity.ok().body(listaAluno);
	}
	
	@GetMapping ( value = "/{id}")
	public ResponseEntity<Revisao> findById(@PathVariable Integer id){
		Revisao aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Revisao> insert(@RequestBody Revisao aluno) {
		   aluno = service.insert(aluno);
		   return ResponseEntity.ok().body(aluno);
	}
	
	@DeleteMapping (value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Integer id){
		service.delete(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)		
	public ResponseEntity<Revisao> update (@PathVariable Integer id, @RequestBody Revisao aluno){
		aluno = service.update(id, aluno);
		return ResponseEntity.ok().body(aluno);
	}
}
