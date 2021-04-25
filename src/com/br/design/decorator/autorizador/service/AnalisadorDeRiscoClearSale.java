package com.br.design.decorator.autorizador.service;

import java.math.BigDecimal;
import java.time.YearMonth;

import com.br.design.decorator.autorizador.exception.RiscoCreditoException;
import com.br.design.decorator.autorizador.model.CartaoCredito;
import com.br.design.decorator.autorizador.model.Cliente;

public class AnalisadorDeRiscoClearSale implements AutorizadorCartaoCredito {

	private AutorizadorCartaoCredito autorizador;

	public AnalisadorDeRiscoClearSale(AutorizadorCartaoCredito autorizador) {
		this.autorizador = autorizador;
	}

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, BigDecimal valor) {

		if (cartaoCredito.getVencimento().isBefore(YearMonth.now())) {
			throw new RiscoCreditoException("Possível fraude, negando pagamento");
		}
		autorizador.autorizar(cliente, cartaoCredito, valor);
	}
}
