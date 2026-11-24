package br.com.fiap.alertaja.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="usuarios") public class Usuario {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false) private String nome;
@Column(nullable=false) private String email;
@Column(nullable=true) private String telefone;
@Column(nullable=true) private String bairro;
@Column(nullable=true) private Boolean ativo;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public String getEmail(){return email;} public void setEmail(String value){this.email=value;}
public String getTelefone(){return telefone;} public void setTelefone(String value){this.telefone=value;}
public String getBairro(){return bairro;} public void setBairro(String value){this.bairro=value;}
public Boolean getAtivo(){return ativo;} public void setAtivo(Boolean value){this.ativo=value;}
}
