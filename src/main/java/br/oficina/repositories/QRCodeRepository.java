package br.oficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.oficina.models.QRCode;

@Repository
public interface QRCodeRepository  extends JpaRepository<QRCode,Long>{

}
