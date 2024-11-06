package br.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.oficina.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo,Long>{
	
	@Query(value="SELECT modelo\r\n"
			+ "FROM marca marca\r\n"
			+ "JOIN modelo modelo\r\n"
			+ "WHERE marca.fk_modelo =  modelo.cod_modelo\r\n"
			+ "AND marca.nome LIKE ?1",nativeQuery = true )
	public List<Modelo> findByMarca(String marca);
	
	

}
