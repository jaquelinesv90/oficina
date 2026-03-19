package br.oficina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.oficina.models.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado,Long>{
	
	@Query(value="select s from ServicoPrestado s join s.tipoServico tp where tp.id = ?1")
	List<ServicoPrestado> findAllServicoPrestadoByIdTipoServico(Long id);

}
