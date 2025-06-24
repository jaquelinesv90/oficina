package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.Documento;

@Repository
public interface DocumentoRepository  extends JpaRepository<Documento,Long>{

}
