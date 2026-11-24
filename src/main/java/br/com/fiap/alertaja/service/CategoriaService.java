package br.com.fiap.alertaja.service;
import br.com.fiap.alertaja.entity.Categoria;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.repository.CategoriaRepository;

import br.com.fiap.alertaja.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service public class CategoriaService {
private final CategoriaRepository repository;private final ModelMapper mapper;
public CategoriaService(CategoriaRepository repository, ModelMapper mapper){this.repository=repository;this.mapper=mapper;}
private CategoriaResponse toResponse(Categoria entity){var result=mapper.map(entity, CategoriaResponse.class);

return result;}
@Transactional(readOnly=true) public List<CategoriaResponse> list(){return repository.findAll().stream().map(this::toResponse).toList();}
@Transactional(readOnly=true) public CategoriaResponse get(Long id){return toResponse(find(id));}
private Categoria find(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Categoria não encontrado: "+id));}
private void apply(Categoria entity,CategoriaRequest dto){mapper.map(dto,entity);}
@Transactional public CategoriaResponse create(CategoriaRequest dto){Categoria entity=new Categoria();apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public CategoriaResponse update(Long id,CategoriaRequest dto){Categoria entity=find(id);apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public void delete(Long id){Categoria entity=find(id);repository.delete(entity);}
}
