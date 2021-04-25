package com.br.design.decorator.pagamento.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import com.br.design.decorator.pagamento.model.CartaoCredito;
import com.br.design.decorator.pagamento.model.Cliente;

public class AutorizadorCielo implements AutorizadorCartaoCredito{

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, BigDecimal valor) {
		
		try (PrintStream writer = new PrintStream(new FileOutputStream("debitos.txt", true))){
			writer.print(cliente + " | " + cartaoCredito + " | R$" + valor);
		}catch(FileNotFoundException execption){
			throw new RuntimeException("Impossível salvar arquivo");
		}
	}
	
	
	

}
