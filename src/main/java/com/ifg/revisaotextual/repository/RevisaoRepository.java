package com.ifg.revisaotextual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifg.revisaotextual.entities.*;

@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Integer>
{
	
}
 