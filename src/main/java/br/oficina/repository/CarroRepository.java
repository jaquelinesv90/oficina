package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.model.Carro;

public interface CarroRepository extends JpaRepository<Carro,Long> {
	
	

}
