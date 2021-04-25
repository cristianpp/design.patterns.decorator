package com.br.design.decorator.pagamento.service;

import java.math.BigDecimal;

import com.br.design.decorator.pagamento.model.CartaoCredito;
import com.br.design.decorator.pagamento.model.Cliente;

public interface AutorizadorCartaoCredito {

	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, BigDecimal valor);
}
