package br.com.fiap.alertaja.service;
import br.com.fiap.alertaja.entity.Usuario;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.repository.UsuarioRepository;

import br.com.fiap.alertaja.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service public class UsuarioService {
private final UsuarioRepository repository;private final ModelMapper mapper;
public UsuarioService(UsuarioRepository repository, ModelMapper mapper){this.repository=repository;this.mapper=mapper;}
private UsuarioResponse toResponse(Usuario entity){var result=mapper.map(entity, UsuarioResponse.class);

return result;}
@Transactional(readOnly=true) public List<UsuarioResponse> list(){return repository.findAll().stream().map(this::toResponse).toList();}
@Transactional(readOnly=true) public UsuarioResponse get(Long id){return toResponse(find(id));}
private Usuario find(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuario não encontrado: "+id));}
private void apply(Usuario entity,UsuarioRequest dto){mapper.map(dto,entity);}
@Transactional public UsuarioResponse create(UsuarioRequest dto){Usuario entity=new Usuario();apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public UsuarioResponse update(Long id,UsuarioRequest dto){Usuario entity=find(id);apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public void delete(Long id){Usuario entity=find(id);repository.delete(entity);}
}
