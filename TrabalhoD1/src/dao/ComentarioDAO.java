package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

import java.sql.ResultSet;

public class ComentarioDAO {
	
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario comentario) {
			
		String inserir = "INSERT INTO comentario "
				+ " (id, nome, texto) "
				+ " VALUES (?, ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			pst.setString(2, comentario.getNome());
			pst.setString(4, comentario.getTexto());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Comentario comentario) {
		
		String inserir = "UPDATE comentario "
				+ "SET nome = ?, texto = ? "
				+ " WHERE i = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			pst.setInt(4, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Comentario comentario) {
		
		String inserir = "DELETE FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
	}
	
	public Comentario consultar(int id) {
		
		String inserir = "SELECT * FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Comentario c = new Comentario();
			if (resultado.next()) {
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setId(id);
			}
			return c;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Comentario> listarComentario() {
		
		String inserir = "SELECT * FROM comentario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setNome(resultado.getString("titulo"));
				c.setTexto(resultado.getString("texto"));
				c.setId(resultado.getInt("id"));
				lista.add(c);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

}