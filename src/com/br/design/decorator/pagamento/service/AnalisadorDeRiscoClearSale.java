package com.br.design.decorator.pagamento.service;

import java.math.BigDecimal;
import java.time.YearMonth;

import com.br.design.decorator.pagamento.exception.RiscoCreditoException;
import com.br.design.decorator.pagamento.model.CartaoCredito;
import com.br.design.decorator.pagamento.model.Cliente;

public class AnalisadorDeRiscoClearSale implements AutorizadorCartaoCredito {

	private AutorizadorCartaoCredito autorizador;

	public AnalisadorDeRiscoClearSale(AutorizadorCartaoCredito autorizador) {
		this.autorizador = autorizador;
	}

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, BigDecimal valor) {

		if (cartaoCredito.getVencimento().isBefore(YearMonth.now())) {
			throw new RiscoCreditoException("Poss�vel fraude, negando pagamento");
		}
		autorizador.autorizar(cliente, cartaoCredito, valor);
	}
}
