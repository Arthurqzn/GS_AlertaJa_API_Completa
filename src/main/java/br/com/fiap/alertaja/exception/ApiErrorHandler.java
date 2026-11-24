package br.com.fiap.alertaja.exception;
import java.time.Instant;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
@RestControllerAdvice public class ApiErrorHandler {
private Map<String,Object> body(int status,String message){return Map.of("timestamp",Instant.now().toString(),"status",status,"message",message);}
@ExceptionHandler(ResourceNotFoundException.class) public ResponseEntity<?> missing(ResourceNotFoundException e){return ResponseEntity.status(404).body(body(404,e.getMessage()));}
@ExceptionHandler({MethodArgumentNotValidException.class,MethodArgumentTypeMismatchException.class,IllegalArgumentException.class}) public ResponseEntity<?> bad(Exception e){return ResponseEntity.badRequest().body(body(400,"Dados inválidos na requisição"));}
@ExceptionHandler(Exception.class) public ResponseEntity<?> error(Exception e){return ResponseEntity.status(500).body(body(500,"Erro interno ao processar a requisição"));}
}
