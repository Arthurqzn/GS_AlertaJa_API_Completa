package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class OcorrenciaResponse {
private Long id;
private String titulo;
private String descricao;
private String endereco;
private String gravidade;
private String status;
private Long usuarioId;
private Long categoriaId;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getTitulo(){return titulo;} public void setTitulo(String value){this.titulo=value;}
public String getDescricao(){return descricao;} public void setDescricao(String value){this.descricao=value;}
public String getEndereco(){return endereco;} public void setEndereco(String value){this.endereco=value;}
public String getGravidade(){return gravidade;} public void setGravidade(String value){this.gravidade=value;}
public String getStatus(){return status;} public void setStatus(String value){this.status=value;}
public Long getUsuarioId(){return usuarioId;} public void setUsuarioId(Long value){this.usuarioId=value;}
public Long getCategoriaId(){return categoriaId;} public void setCategoriaId(Long value){this.categoriaId=value;}
}
