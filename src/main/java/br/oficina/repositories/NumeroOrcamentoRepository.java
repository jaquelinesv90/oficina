package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.oficina.models.NumeroOrcamento;

public interface NumeroOrcamentoRepository extends JpaRepository<NumeroOrcamento,Long> {

}
