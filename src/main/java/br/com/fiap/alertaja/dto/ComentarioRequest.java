package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class ComentarioRequest {
@NotNull @NotBlank private String texto;
@NotNull @NotBlank private String autorNome;
private Boolean visivel;
private String origem;
private Boolean moderado;
@NotNull private Long ocorrenciaId;
@NotNull private Long usuarioId;
public String getTexto(){return texto;} public void setTexto(String value){this.texto=value;}
public String getAutorNome(){return autorNome;} public void setAutorNome(String value){this.autorNome=value;}
public Boolean getVisivel(){return visivel;} public void setVisivel(Boolean value){this.visivel=value;}
public String getOrigem(){return origem;} public void setOrigem(String value){this.origem=value;}
public Boolean getModerado(){return moderado;} public void setModerado(Boolean value){this.moderado=value;}
public Long getOcorrenciaId(){return ocorrenciaId;} public void setOcorrenciaId(Long value){this.ocorrenciaId=value;}
public Long getUsuarioId(){return usuarioId;} public void setUsuarioId(Long value){this.usuarioId=value;}
}
