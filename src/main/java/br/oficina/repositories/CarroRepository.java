package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.models.Carro;

public interface CarroRepository extends JpaRepository<Carro,Long> {
	
	

}
