package br.com.organmarket.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.organmarket.entity.DadosVenda;

/**
 * Classe DAO dos dados de venda.
 * 
 * @author pedholiveira
 */
public class DadosVendaDAO implements Closeable {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/organ_market";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static DadosVendaDAO instance;
	
	private Connection connection; 
	
	/**
	 * Construtor privado da classe. 
	 */
	private DadosVendaDAO() {
		criarConnection();
	}

	/**
	 * Retorna a instancia do objeto dao.
	 * 
	 * @return dao
	 */
	public static DadosVendaDAO newInstance() {
		if(instance == null) {
			instance = new DadosVendaDAO();
		}
		return instance;
	}

	@Override
	public void close() throws IOException {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Busca um registro específico de {@link DadosVenda} no banco.
	 * 
	 * @param id
	 * @return dadosVenda
	 */
	public DadosVenda obter(Long id) {
		try {
			PreparedStatement stmt = criarPreparedStatement("SELECT * FROM dados_venda WHERE id = ?");
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			DadosVenda dados = new DadosVenda();
			dados.setId(rs.getLong("id"));
			dados.setOrgao(rs.getString("orgao"));
			dados.setPreco(rs.getDouble("preco"));
			dados.setDadosDoador(rs.getString("dados_doador"));
			
			stmt.close();
			return dados;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere um novo {@link DadosVenda} no banco.
	 * 
	 * @param dados
	 */
	public void criar(DadosVenda dados) {
		try {
			PreparedStatement stmt = criarPreparedStatement("INSERT INTO dados_venda (orgao, preco, dados_doador) values (?, ?, ?)");
			stmt.setString(1, dados.getOrgao());
			stmt.setDouble(2, dados.getPreco());
			stmt.setString(3, dados.getDadosDoador());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Atualiza um {@link DadosVenda} no banco.
	 * 
	 * @param dados
	 */
	public void atualizar(DadosVenda dados) {
		try {
			PreparedStatement stmt = criarPreparedStatement("UPDATE dados_venda SET orgao = ?, preco = ?, dados_doador = ?) WHERE id = ?");
			stmt.setString(1, dados.getOrgao());
			stmt.setDouble(2, dados.getPreco());
			stmt.setString(3, dados.getDadosDoador());
			stmt.setLong(4, dados.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deleta um registro do banco
	 * 
	 * @param id
	 */
	public void deletar(Long id) {
		try {
			//Falha de segurança a ser listada pelo relatório.
			PreparedStatement stmt = criarPreparedStatement("DELETE FROM dados_venda WHERE id = " + id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cria o objeto {@link Connection} que será utilizado 
	 * para realizar as conexões no banco.
	 */
	private void criarConnection() {
		try {
			registarJdbcDriver();
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Registra o driver jdbc no classpath da aplicação.
	 */
	private void registarJdbcDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cria um objeto {@link PreparedStatement} para realizar operações no banco.
	 * 
	 * @param sql
	 * @return preparedStatement
	 */
	private PreparedStatement criarPreparedStatement(String sql) {
		try {
			return connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
