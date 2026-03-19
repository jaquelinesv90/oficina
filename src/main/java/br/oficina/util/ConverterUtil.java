package br.oficina.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterUtil {
	
	/*
	 *  Entity -> DTO
	 *  PostDto dto = converter.convert(postEntity, PostDto.class);
	 *  
	 *  DTO -> Entity
	 *  Post entity = converter.convert(postDto, Post.class);
	 *  
	 *  Lista de Entity -> Lista de DTO
	 *  List<PostDto> dtos = converter.convertList(postEntities, PostDto.class);
	 */

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	public ConverterUtil(ModelMapper modelmapper) {
		this.modelMapper = modelMapper;
	}
	
	 // Converter um objeto de origem para destino
	public <S,D> D convert(S source, Class<D> destinationClass) {
		if(source == null) return null;
		return modelMapper.map(source, destinationClass);
	}
	
	public <S,D> List<D> convertLists(List<S> sourceList, Class<D> destinationClass) {
		if(sourceList == null) return List.of();
		return sourceList.stream()
				.map(source -> convert(source, destinationClass))
				.collect(Collectors.toList());
	}
	

	

	
}
