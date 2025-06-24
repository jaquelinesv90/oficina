package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.TipoChavePix;

@Repository
public interface TipoChavePixRepository  extends JpaRepository<TipoChavePix,Long>{

}
