package br.com.fiap.alertaja.dto;
import jakarta.validation.constraints.*;
public class CategoriaRequest {
@NotNull @NotBlank private String nome;
@NotNull @NotBlank private String descricao;
private String icone;
private String cor;
private Boolean ativa;
public String getNome(){return nome;} public void setNome(String value){this.nome=value;}
public String getDescricao(){return descricao;} public void setDescricao(String value){this.descricao=value;}
public String getIcone(){return icone;} public void setIcone(String value){this.icone=value;}
public String getCor(){return cor;} public void setCor(String value){this.cor=value;}
public Boolean getAtiva(){return ativa;} public void setAtiva(Boolean value){this.ativa=value;}
}
