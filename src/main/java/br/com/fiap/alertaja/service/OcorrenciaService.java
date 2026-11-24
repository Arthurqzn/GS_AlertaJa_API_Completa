package br.com.fiap.alertaja.service;
import br.com.fiap.alertaja.entity.Ocorrencia;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.repository.OcorrenciaRepository;
import br.com.fiap.alertaja.repository.UsuarioRepository;
import br.com.fiap.alertaja.repository.CategoriaRepository;
import br.com.fiap.alertaja.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service public class OcorrenciaService {
private final OcorrenciaRepository repository;private final ModelMapper mapper;private final UsuarioRepository usuarioRepository;
private final CategoriaRepository categoriaRepository;
public OcorrenciaService(OcorrenciaRepository repository, ModelMapper mapper, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository){this.repository=repository;this.mapper=mapper;this.usuarioRepository=usuarioRepository;this.categoriaRepository=categoriaRepository;}
private OcorrenciaResponse toResponse(Ocorrencia entity){var result=mapper.map(entity, OcorrenciaResponse.class);
result.setUsuarioId(entity.getUsuario().getId());
result.setCategoriaId(entity.getCategoria().getId());
return result;}
@Transactional(readOnly=true) public List<OcorrenciaResponse> list(){return repository.findAll().stream().map(this::toResponse).toList();}
@Transactional(readOnly=true) public OcorrenciaResponse get(Long id){return toResponse(find(id));}
private Ocorrencia find(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Ocorrencia não encontrado: "+id));}
private void apply(Ocorrencia entity,OcorrenciaRequest dto){mapper.map(dto,entity);entity.setUsuario(usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(()->new ResourceNotFoundException("Usuario não encontrado")));
entity.setCategoria(categoriaRepository.findById(dto.getCategoriaId()).orElseThrow(()->new ResourceNotFoundException("Categoria não encontrado")));}
@Transactional public OcorrenciaResponse create(OcorrenciaRequest dto){Ocorrencia entity=new Ocorrencia();apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public OcorrenciaResponse update(Long id,OcorrenciaRequest dto){Ocorrencia entity=find(id);apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public void delete(Long id){Ocorrencia entity=find(id);repository.delete(entity);}
}
