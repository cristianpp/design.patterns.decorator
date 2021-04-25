package com.br.design.decorator.autorizador.service;

import java.math.BigDecimal;

import com.br.design.decorator.autorizador.model.CartaoCredito;
import com.br.design.decorator.autorizador.model.Cliente;

public interface AutorizadorCartaoCredito {

	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, BigDecimal valor);
}
