package br.com.ifsp.ApiConsultaViagens.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PassagensDTO {
	
 private Long viagemId;
 private String passagemOrigem;
 private String passagemDestino;
 private LocalDateTime dataCompra;
 private LocalDateTime dataChegada;
 private BigDecimal passagemValor;
 private String veiculo;
 
 
 PassagensDTO(){}



public Long getViagemId() {
	return viagemId;
}



public void setViagemId(Long viagemId) {
	this.viagemId = viagemId;
}



public String getPassagemOrigem() {
	return passagemOrigem;
}



public void setPassagemOrigem(String passagemOrigem) {
	this.passagemOrigem = passagemOrigem;
}



public String getPassagemDestino() {
	return passagemDestino;
}



public void setPassagemDestino(String passagemDestino) {
	this.passagemDestino = passagemDestino;
}



public LocalDateTime getDataCompra() {
	return dataCompra;
}



public void setDataCompra(LocalDateTime dataCompra) {
	this.dataCompra = dataCompra;
}



public LocalDateTime getDataChegada() {
	return dataChegada;
}



public void setDataChegada(LocalDateTime dataChegada) {
	this.dataChegada = dataChegada;
}



public BigDecimal getPassagemValor() {
	return passagemValor;
}



public void setPassagemValor(BigDecimal passagemValor) {
	this.passagemValor = passagemValor;
}



public String getVeiculo() {
	return veiculo;
}



public void setVeiculo(String veiculo) {
	this.veiculo = veiculo;
}
 
 
	  
	

}
