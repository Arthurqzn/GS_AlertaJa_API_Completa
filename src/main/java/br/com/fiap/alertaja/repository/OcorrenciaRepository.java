package br.com.fiap.alertaja.repository;
import br.com.fiap.alertaja.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Long> {}
