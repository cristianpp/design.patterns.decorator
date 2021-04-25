package com.br.design.decorator.autorizador.test;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Scanner;

import com.br.design.decorator.autorizador.model.CartaoCredito;
import com.br.design.decorator.autorizador.model.Cliente;
import com.br.design.decorator.autorizador.service.AnalisadorDeRiscoClearSale;
import com.br.design.decorator.autorizador.service.AutorizadorCartaoCredito;
import com.br.design.decorator.autorizador.service.AutorizadorCielo;

public class TestAutorizador {

	public static void main(String[] args) {

		try (Scanner entrada = new Scanner(System.in)) {
			System.out.printf("Cliente: ");
			String nomeCliente = entrada.nextLine();

			System.out.printf("CPF: ");
			String cpf = entrada.nextLine();

			System.out.println();
			System.out.printf("Valor da compra: R$");
			BigDecimal valor = entrada.nextBigDecimal();
			entrada.nextLine();

			System.out.println();
			System.out.println("Informações de pagamento");
			System.out.printf("Número do cartão: ");
			String cartao = entrada.nextLine();
			System.out.printf("Nome do cartão: ");
			String nomeCartao = entrada.nextLine();
			System.out.printf("Ano vencimento: ");
			int anoVencimento = entrada.nextInt();
			System.out.printf("Mês vencimento: ");
			int mesVencimento = entrada.nextInt();
			System.out.printf("Código segurança: ");
			int codigoSeguranca = entrada.nextInt();

			Cliente cliente = new Cliente(nomeCliente, cpf);
			CartaoCredito cartaoCredito = new CartaoCredito(cartao, nomeCartao,
					YearMonth.of(anoVencimento, mesVencimento), codigoSeguranca);

			AutorizadorCartaoCredito autorizador = new AnalisadorDeRiscoClearSale(new AutorizadorCielo());
			autorizador.autorizar(cliente, cartaoCredito, valor);
		}

	}

}
