package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class ComentarioResponse {
private Long id;
private String texto;
private String autorNome;
private Boolean visivel;
private String origem;
private Boolean moderado;
private Long ocorrenciaId;
private Long usuarioId;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getTexto(){return texto;} public void setTexto(String value){this.texto=value;}
public String getAutorNome(){return autorNome;} public void setAutorNome(String value){this.autorNome=value;}
public Boolean getVisivel(){return visivel;} public void setVisivel(Boolean value){this.visivel=value;}
public String getOrigem(){return origem;} public void setOrigem(String value){this.origem=value;}
public Boolean getModerado(){return moderado;} public void setModerado(Boolean value){this.moderado=value;}
public Long getOcorrenciaId(){return ocorrenciaId;} public void setOcorrenciaId(Long value){this.ocorrenciaId=value;}
public Long getUsuarioId(){return usuarioId;} public void setUsuarioId(Long value){this.usuarioId=value;}
}
