package com.ifg.revisaotextual.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.ifg.revisaotextual.entities.Revisao;
import com.ifg.revisaotextual.repository.RevisaoRepository;

@Service
public class RevisaoService {
	@Autowired
	private RevisaoRepository repository;
	
	public List<Revisao> findAll(){
		return repository.findAll();
	}
	
	public Revisao findById(Integer id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND)  );
	}
	
	public Revisao insert(Revisao revisao) {
		return repository.save(revisao);
	}
	
	public void delete (Integer id) {
			repository.findById(id).map(
					aluno -> {
							repository.delete(aluno);
							return Void.TYPE;
						 }).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND)  );		
	}
	
	public Revisao update (Integer id, Revisao obj) {
		return repository.findById(id).map(
				revisao -> { 
					revisao.setCaracteristicas(  obj.getCaracteristicas() );
					revisao.setDescricao(obj.getDescricao());
							    return repository.save(revisao);
							 }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
}
