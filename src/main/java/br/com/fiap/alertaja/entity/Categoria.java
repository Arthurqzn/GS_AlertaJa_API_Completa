package br.com.fiap.alertaja.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="categorias") public class Categoria {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false) private String nome;
@Column(nullable=false) private String descricao;
@Column(nullable=true) private String icone;
@Column(nullable=true) private String cor;
@Column(nullable=true) private Boolean ativa;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public String getDescricao(){return descricao;} public void setDescricao(String value){this.descricao=value;}
public String getIcone(){return icone;} public void setIcone(String value){this.icone=value;}
public String getCor(){return cor;} public void setCor(String value){this.cor=value;}
public Boolean getAtiva(){return ativa;} public void setAtiva(Boolean value){this.ativa=value;}
}
