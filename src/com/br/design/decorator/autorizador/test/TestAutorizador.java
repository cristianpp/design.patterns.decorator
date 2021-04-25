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
			System.out.println("Informa��es de pagamento");
			System.out.printf("N�mero do cart�o: ");
			String cartao = entrada.nextLine();
			System.out.printf("Nome do cart�o: ");
			String nomeCartao = entrada.nextLine();
			System.out.printf("Ano vencimento: ");
			int anoVencimento = entrada.nextInt();
			System.out.printf("M�s vencimento: ");
			int mesVencimento = entrada.nextInt();
			System.out.printf("C�digo seguran�a: ");
			int codigoSeguranca = entrada.nextInt();

			Cliente cliente = new Cliente(nomeCliente, cpf);
			CartaoCredito cartaoCredito = new CartaoCredito(cartao, nomeCartao,
					YearMonth.of(anoVencimento, mesVencimento), codigoSeguranca);

			AutorizadorCartaoCredito autorizador = new AnalisadorDeRiscoClearSale(new AutorizadorCielo());
			autorizador.autorizar(cliente, cartaoCredito, valor);
		}

	}

}
