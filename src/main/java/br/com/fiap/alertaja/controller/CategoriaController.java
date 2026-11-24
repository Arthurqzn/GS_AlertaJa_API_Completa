package br.com.fiap.alertaja.controller;
import br.com.fiap.alertaja.dto.*;
import br.com.fiap.alertaja.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/v1/categorias") public class CategoriaController {
private final CategoriaService service;
public CategoriaController(CategoriaService service){this.service=service;}
@GetMapping public List<CategoriaResponse> list(){return service.list();}
@GetMapping("/{id}") public CategoriaResponse get(@PathVariable Long id){return service.get(id);}
@PostMapping public ResponseEntity<CategoriaResponse> create(@Valid @RequestBody CategoriaRequest request){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));}
@PutMapping("/{id}") public CategoriaResponse update(@PathVariable Long id,@Valid @RequestBody CategoriaRequest request){return service.update(id,request);}
@DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){service.delete(id);return ResponseEntity.noContent().build();}
}
