package br.com.fiap.alertaja.service;
import br.com.fiap.alertaja.entity.Comentario;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.repository.ComentarioRepository;
import br.com.fiap.alertaja.repository.OcorrenciaRepository;
import br.com.fiap.alertaja.repository.UsuarioRepository;
import br.com.fiap.alertaja.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service public class ComentarioService {
private final ComentarioRepository repository;private final ModelMapper mapper;private final OcorrenciaRepository ocorrenciaRepository;
private final UsuarioRepository usuarioRepository;
public ComentarioService(ComentarioRepository repository, ModelMapper mapper, OcorrenciaRepository ocorrenciaRepository, UsuarioRepository usuarioRepository){this.repository=repository;this.mapper=mapper;this.ocorrenciaRepository=ocorrenciaRepository;this.usuarioRepository=usuarioRepository;}
private ComentarioResponse toResponse(Comentario entity){var result=mapper.map(entity, ComentarioResponse.class);
result.setOcorrenciaId(entity.getOcorrencia().getId());
result.setUsuarioId(entity.getUsuario().getId());
return result;}
@Transactional(readOnly=true) public List<ComentarioResponse> list(){return repository.findAll().stream().map(this::toResponse).toList();}
@Transactional(readOnly=true) public ComentarioResponse get(Long id){return toResponse(find(id));}
private Comentario find(Long id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Comentario não encontrado: "+id));}
private void apply(Comentario entity,ComentarioRequest dto){mapper.map(dto,entity);entity.setOcorrencia(ocorrenciaRepository.findById(dto.getOcorrenciaId()).orElseThrow(()->new ResourceNotFoundException("Ocorrencia não encontrado")));
entity.setUsuario(usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(()->new ResourceNotFoundException("Usuario não encontrado")));}
@Transactional public ComentarioResponse create(ComentarioRequest dto){Comentario entity=new Comentario();apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public ComentarioResponse update(Long id,ComentarioRequest dto){Comentario entity=find(id);apply(entity,dto);return toResponse(repository.save(entity));}
@Transactional public void delete(Long id){Comentario entity=find(id);repository.delete(entity);}
}
