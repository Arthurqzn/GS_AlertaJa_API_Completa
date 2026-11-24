package br.com.fiap.alertaja.controller;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/v1/usuarios") public class UsuarioController {
private final UsuarioService service;
public UsuarioController(UsuarioService service){this.service=service;}
@GetMapping public List<UsuarioResponse> list(){return service.list();}
@GetMapping("/{id}") public UsuarioResponse get(@PathVariable Long id){return service.get(id);}
@PostMapping public ResponseEntity<UsuarioResponse> create(@Valid @RequestBody UsuarioRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
@PutMapping("/{id}") public UsuarioResponse update(@PathVariable Long id,@Valid @RequestBody UsuarioRequest request){return service.update(id,request);}
@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
