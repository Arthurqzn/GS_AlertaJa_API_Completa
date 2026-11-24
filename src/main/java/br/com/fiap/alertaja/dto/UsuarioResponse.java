package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class UsuarioResponse {
private Long id;
private String nome;
private String email;
private String telefone;
private String bairro;
private Boolean ativo;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public String getEmail(){return email;} public void setEmail(String value){this.email=value;}
public String getTelefone(){return telefone;} public void setTelefone(String value){this.telefone=value;}
public String getBairro(){return bairro;} public void setBairro(String value){this.bairro=value;}
public Boolean getAtivo(){return ativo;} public void setAtivo(Boolean value){this.ativo=value;}
}
