package com.ifg.revisaotextual.util;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/*
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
*/

//Classe utilizada para fazer o calculo para cada tipo de servico e retornar a pagina de orcamento

public class CalculaPDF {
/*
	// O metodo vai receber a requisicao e a resposta e vai fazer os calculos do
	// orcamento e retornar a pagina

	public void executa(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		res.setContentType("text/html;charset=UTF-8");

		Integer servicoId = Integer.valueOf(req.getParameter("servicoId"));

		try {
			final Part filePart = (Part) req.getPart("file"); // Pegando o arquivo que o usuario enviou

			InputStream pdfFileBytes = null;
			final PrintWriter writer = res.getWriter();

			// No if abaixo verifica o tipo do arquivo e se for diferente de pdf, o arquivo
			// é invalido
			if (!filePart.getContentType().equals("application/pdf")) {
				writer.println("<br/> Arquivo Invalido");
				return;
			}

			pdfFileBytes = filePart.getInputStream(); // para obter os dados da requisicao

			ParseContext pcontext = new ParseContext();
			Metadata metadata = new Metadata();
			BodyContentHandler handler = new BodyContentHandler();

			// Fazendo o parsing do documento com PDF parser
			PDFParser pdfparser = new PDFParser();
			pdfparser.parse(pdfFileBytes, handler, metadata, pcontext);
			String caracteres = handler.toString();// colocando o conteudo do documento em uma variavel
			caracteres = caracteres.replace("\n", ""); // colocando na variavel os caracteres do documento, ignorando as
														// quebras de linhas
			String[] palavras = caracteres.split(" ");// Colocando na variavel as palavras do documento, quebrando nos
														// espacos em branco

			ServicoDAO servicoDAO = new ServicoDAO(); // Instanciando objeto DAO para buscar as informacoes do servico
			Servico servico = servicoDAO.buscaServico(servicoId); // de acordo com o id selecionado

			for (ServicoValor servicoValor : servico.getServicoValores()) {

				// O if verifica se a forma escolhida é por lauda e se for, realiza o calculo
				if (servicoValor.getFormaPagamento().compareTo(CobrancaEnum.POR_LAUDA) == 0) {
					Double valorLauda = servicoValor.getValor();
					// se a quantidade de caracteres for menor que 1250, deve ser considerado no
					// minimo uma lauda.
					if (caracteres.length() >= 1250) {
						valorLauda = (caracteres.length() / 1250) * servicoValor.getValor();// valorLauda = (quantidade
																							// de caracteres / 1250) x o
																							// valor do servico
					}
					session.setAttribute("valorPorLauda", valorLauda);
				}

				// O if verifica se a forma escolhida é por pagina e se for, realiza o calculo
				else if (servicoValor.getFormaPagamento().compareTo(CobrancaEnum.POR_PAGINA) == 0) {
					Double valor = (Integer.valueOf(metadata.get("xmpTPg:NPages")) * servicoValor.getValor());// valor =
																												// quantidade
																												// de
																												// paginas
																												// x
																												// valor
																												// do
																												// servico

					session.setAttribute("valorPorPagina", valor);// Setando o valor por pagina na sessao
				}

				// O if verifica se a forma escolhida é por palavra e se for, realiza o calculo

				else if (servicoValor.getFormaPagamento().compareTo(CobrancaEnum.POR_PALAVRA) == 0) {
					Double valor = (palavras.length * servicoValor.getValor());// valor = quantidade de palavras x o
																				// valor do servico

					session.setAttribute("valorPorPalavra", valor);// Setando o valor por palavra na sessao
				}
			}

			res.sendRedirect("orcamento.jsp");// redirecionando para a pagina de orcamento com os valores de cada
												// servico calculado
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/
}