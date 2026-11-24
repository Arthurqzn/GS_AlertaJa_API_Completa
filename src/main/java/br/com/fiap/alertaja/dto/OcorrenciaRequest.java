package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class OcorrenciaRequest {
@NotNull @NotBlank private String titulo;
@NotNull @NotBlank private String descricao;
private String endereco;
private String gravidade;
private String status;
@NotNull private Long usuarioId;
@NotNull private Long categoriaId;
public String getTitulo(){return titulo;} public void setTitulo(String value){this.titulo=value;}
public String getDescricao(){return descricao;} public void setDescricao(String value){this.descricao=value;}
public String getEndereco(){return endereco;} public void setEndereco(String value){this.endereco=value;}
public String getGravidade(){return gravidade;} public void setGravidade(String value){this.gravidade=value;}
public String getStatus(){return status;} public void setStatus(String value){this.status=value;}
public Long getUsuarioId(){return usuarioId;} public void setUsuarioId(Long value){this.usuarioId=value;}
public Long getCategoriaId(){return categoriaId;} public void setCategoriaId(Long value){this.categoriaId=value;}
}
