package br.com.fiap.alertaja.controller;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/v1/ocorrencias") public class OcorrenciaController {
private final OcorrenciaService service;
public OcorrenciaController(OcorrenciaService service){this.service=service;}
@GetMapping public List<OcorrenciaResponse> list(){return service.list();}
@GetMapping("/{id}") public OcorrenciaResponse get(@PathVariable Long id){return service.get(id);}
@PostMapping public ResponseEntity<OcorrenciaResponse> create(@Valid @RequestBody OcorrenciaRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
@PutMapping("/{id}") public OcorrenciaResponse update(@PathVariable Long id,@Valid @RequestBody OcorrenciaRequest request){return service.update(id,request);}
@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
