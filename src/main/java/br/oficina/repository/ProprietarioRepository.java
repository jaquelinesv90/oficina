package br.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.model.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario,Long>{

}
