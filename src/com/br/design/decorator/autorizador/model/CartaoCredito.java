package com.br.design.decorator.autorizador.model;

import java.time.YearMonth;

public class CartaoCredito {
	
	private String numero;
	private String nome;
	private YearMonth vencimento;
	private int codidoSeguranca;
	
	public CartaoCredito(String numero, String nome, YearMonth vencimento, int codidoSeguranca) {
		this.numero = numero;
		this.nome = nome;
		this.vencimento = vencimento;
		this.codidoSeguranca = codidoSeguranca;
	}

	public String getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public YearMonth getVencimento() {
		return vencimento;
	}

	public int getCodidoSeguranca() {
		return codidoSeguranca;
	}

	@Override
	public String toString() {
		return "CartaoCredito [numero=" + numero + ", nome=" + nome + "]";
	}
}
