package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico,Long>{

}
