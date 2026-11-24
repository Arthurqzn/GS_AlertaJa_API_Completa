package br.com.fiap.alertaja.repository;
import br.com.fiap.alertaja.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {}
