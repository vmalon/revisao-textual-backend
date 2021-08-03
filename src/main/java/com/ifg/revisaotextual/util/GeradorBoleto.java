/*package com.ifg.revisaotextual.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;

import br.edu.ifg.model.Usuario;

public class GeradorBoleto { // Aqui será gerado o boleto

	public void criaBoleto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Metodo que vai criar o boleto
		response.setContentType("application/pdf");

		ContaBancaria contaBancaria = crieUmaContaBancaria();// Cria conta do cedente/ emissor do boleto
		Cedente cedente = crieUmCedente(); // Cria objeto Cedente

		Sacado sacado = crieUmSacado(request, response);// Cria o sacado/ quem vai pagar o boleto

		Titulo titulo = criaOsDadosDoTitulo(new Titulo(contaBancaria, sacado, cedente), 1);// Dados de input do
																							// boleto
		Boleto boleto = criaOsDadosDoBoleto(new Boleto(titulo));// Cria o titulo

		BoletoViewer boletoViewer = new BoletoViewer(boleto);// Visualizador do boleto

		byte[] arquivo = boletoViewer.getPdfAsByteArray();
		response.setContentLength(arquivo.length);

		//
		ServletOutputStream ouputStream = response.getOutputStream();// Output do boleto
		ouputStream.write(arquivo, 0, arquivo.length);
		ouputStream.flush();// salvar
		ouputStream.close();// fechar
	}

	private Boleto criaOsDadosDoBoleto(Boleto boleto) {
		// Cria informações adicionais que devem estar no boleto
		boleto.setLocalPagamento("Pagavel preferencialmente no Banco do Brasil ou em qualquer Banco até o vencimento.");
		boleto.setInstrucao1("ACEITAR SOMENTE ATE A DATA DE VENCIMENTO");

		return boleto;
	}

	private Titulo criaOsDadosDoTitulo(Titulo titulo, int numero) {
		// Dados que devem conter no titulo do boleto
		titulo.setNumeroDoDocumento("123456" + numero);
		titulo.setNossoNumero(String.format("99345678912", numero));
		titulo.setDigitoDoNossoNumero("5");
		titulo.setValor(BigDecimal.valueOf(10 + numero));
		titulo.setDataDoDocumento(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, numero);
		titulo.setDataDoVencimento(cal.getTime());
		titulo.setTipoDeDocumento(TipoDeTitulo.FAT_FATURA);
		titulo.setAceite(Aceite.A);

		return titulo;
	}

	private Sacado crieUmSacado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cria o sacado
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("userSession");

		Sacado sacado = new Sacado(usuario.getNome(), usuario.getCpf());// Nome e cpf do usuario
		// Informe o endereco do sacado
		Endereco enderecoSac = new Endereco();
		enderecoSac.setUF(UnidadeFederativa.GO);

		sacado.addEndereco(enderecoSac);

		return sacado;
	}

	private Cedente crieUmCedente() {
		// Nome e CNPJ do emissor do boleto
		return new Cedente("MYR Revisao Textual", "00.000.208/0001-00");
	}

	private ContaBancaria crieUmaContaBancaria() {
		// Cria informações da conta bancaria que ira receber o dinheiro
		ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
		contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
		contaBancaria.setCarteira(new Carteira(30));
		contaBancaria.setAgencia(new Agencia(1234, "1"));

		return contaBancaria;
	}
}*/