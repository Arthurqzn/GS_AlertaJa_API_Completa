package br.com.fiap.alertaja.repository;
import br.com.fiap.alertaja.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {}
