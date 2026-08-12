package br.oficina.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.oficina.dto.QRCodeDTO;
import br.oficina.models.QRCode;
import br.oficina.models.TipoChavePix;

@Mapper
public interface QRCodeMapper {

	QRCodeMapper INSTANCE = Mappers.getMapper(QRCodeMapper.class);

	@Mapping(source = "tipoChavepix", target = "tipoChavepix")
	QRCodeDTO toDto(QRCode entity);

	@Mapping(source = "tipoChavepix", target = "tipoChavepix")
	QRCode toEntity(QRCodeDTO dto);
    
   // Converte objeto → String
    default String map(TipoChavePix value) {
        return value == null ? null : value.getDescricao(); 
        // ou value.getId().toString(), depende do que você quer guardar
    }

    // Converte String → objeto
    default TipoChavePix map(String value) {
        if (value == null) return null;
        TipoChavePix obj = new TipoChavePix();
        obj.setDescricao(value); // ou setId(Long.parseLong(value))
        return obj;
    }
}
