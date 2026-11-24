package br.com.fiap.alertaja.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="ocorrencias") public class Ocorrencia {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false) private String titulo;
@Column(nullable=false) private String descricao;
@Column(nullable=true) private String endereco;
@Column(nullable=true) private String gravidade;
@Column(nullable=true) private String status;
@ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="usuario_id",nullable=false) private Usuario usuario;
@ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="categoria_id",nullable=false) private Categoria categoria;
public Long getId(){return id;} public void setId(Long value){this.id=value;}
public String getTitulo(){return titulo;} public void setTitulo(String value){this.titulo=value;}
public String getDescricao(){return descricao;} public void setDescricao(String value){this.descricao=value;}
public String getEndereco(){return endereco;} public void setEndereco(String value){this.endereco=value;}
public String getGravidade(){return gravidade;} public void setGravidade(String value){this.gravidade=value;}
public String getStatus(){return status;} public void setStatus(String value){this.status=value;}
public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario value){this.usuario=value;}
public Categoria getCategoria(){return categoria;} public void setCategoria(Categoria value){this.categoria=value;}
}
