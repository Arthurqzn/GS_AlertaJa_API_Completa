package br.com.fiap.alertaja.controller;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/v1/comentarios") public class ComentarioController {
private final ComentarioService service;
public ComentarioController(ComentarioService service){this.service=service;}
@GetMapping public List<ComentarioResponse> list(){return service.list();}
@GetMapping("/{id}") public ComentarioResponse get(@PathVariable Long id){return service.get(id);}
@PostMapping public ResponseEntity<ComentarioResponse> create(@Valid @RequestBody ComentarioRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
@PutMapping("/{id}") public ComentarioResponse update(@PathVariable Long id,@Valid @RequestBody ComentarioRequest request){return service.update(id,request);}
@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
