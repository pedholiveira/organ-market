package br.com.organmarket.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.organmarket.dao.DadosVendaDAO;
import br.com.organmarket.entity.DadosVenda;

/**
 * Servlet responsável por realizar as operações 
 * http dos dados de venda.
 * 
 * @author pedholiveira
 */
@WebServlet("/dadosvenda")
public class DadosVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DadosVendaDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = DadosVendaDAO.newInstance();
	}
	
	@Override
	public void destroy() {
		try {
			dao.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtém um registro específico dos dados de venda.
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		DadosVenda dados = dao.obter(id);
		
		response.getWriter().append("Dados encontrados: ").append(dados.toString());
	}

	/**
	 * Insere um novo registro no banco.
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DadosVenda dados = new DadosVenda();
		dados.setOrgao(request.getParameter("orgao"));
		dados.setPreco(Double.valueOf(request.getParameter("preco")));
		dados.setDadosDoador(request.getParameter("dadosDoador"));
		dao.criar(dados);
		
		response.getWriter().append("Dados inseridos com sucesso!");
	}

	/**
	 * Rota responsável por remover um registro.
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.deletar(Long.valueOf(request.getParameter("id")));
		
		response.getWriter().append("Dados removidos com sucesso!");
	}
	
	/**
	 * Altera um registro já existente.
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DadosVenda dados = new DadosVenda();
		dados.setId(Long.valueOf(request.getParameter("id")));
		dados.setOrgao(request.getParameter("orgao"));
		dados.setPreco(Double.valueOf(request.getParameter("preco")));
		dados.setDadosDoador(request.getParameter("dadosDoador"));
		dao.atualizar(dados);
		
		response.getWriter().append("Dados atualizados com sucesso!");
	}
}
