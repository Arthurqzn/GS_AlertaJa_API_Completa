package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class UsuarioRequest {
@NotNull @NotBlank private String nome;
@NotNull @NotBlank private String email;
private String telefone;
private String bairro;
private Boolean ativo;
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public String getEmail(){return email;} public void setEmail(String value){this.email=value;}
public String getTelefone(){return telefone;} public void setTelefone(String value){this.telefone=value;}
public String getBairro(){return bairro;} public void setBairro(String value){this.bairro=value;}
public Boolean getAtivo(){return ativo;} public void setAtivo(Boolean value){this.ativo=value;}
}
