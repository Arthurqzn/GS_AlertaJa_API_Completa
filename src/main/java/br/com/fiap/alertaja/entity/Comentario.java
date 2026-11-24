package br.com.fiap.alertaja.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="comentarios") public class Comentario {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false) private String texto;
@Column(nullable=false) private String autorNome;
@Column(nullable=true) private Boolean visivel;
@Column(nullable=true) private String origem;
@Column(nullable=true) private Boolean moderado;
@ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="ocorrencia_id",nullable=false) private Ocorrencia ocorrencia;
@ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="usuario_id",nullable=false) private Usuario usuario;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getTexto(){return texto;} public void setTexto(String value){this.texto=value;}
public String getAutorNome(){return autorNome;} public void setAutorNome(String value){this.autorNome=value;}
public Boolean getVisivel(){return visivel;} public void setVisivel(Boolean value){this.visivel=value;}
public String getOrigem(){return origem;} public void setOrigem(String value){this.origem=value;}
public Boolean getModerado(){return moderado;} public void setModerado(Boolean value){this.moderado=value;}
public Ocorrencia getOcorrencia(){return ocorrencia;} public void setOcorrencia(Ocorrencia value){this.ocorrencia=value;}
public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario value){this.usuario=value;}
}
