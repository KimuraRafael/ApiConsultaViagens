package br.com.ifsp.ApiConsultaViagens.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Passagem {
	
	private Long passagemId;
	
	private String passagemOrigem;
	
	private String passagemDestino;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataCompra;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataChegada;
	
	private BigDecimal passagemValor;
	
	private String veiculo;

	
	public Passagem() {
		
	}
	
	public Passagem(long passagemId, String passagemOrigem, String passagemDestino, LocalDateTime dataCompra,
			LocalDateTime dataChegada, BigDecimal passagemValor, String veiculo) {
		super();
		this.passagemId = passagemId;
		this.passagemOrigem = passagemOrigem;
		this.passagemDestino = passagemDestino;
		this.dataCompra = dataCompra;
		this.dataChegada = dataChegada;
		this.passagemValor = passagemValor;
		this.veiculo = veiculo;
	}

	public long getPassagemId() {
		return passagemId;
	}

	public void setPassagemId(long passagemId) {
		this.passagemId = passagemId;
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
