package br.com.ana.projeto_integrador.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ana.projeto_integrador.modelo.Usuario;
import br.com.ana.projeto_integrador.modelo.UsuarioAutenticador;

public class UsuarioDAO {
	
	public static void inserir(Usuario usuario) throws Exception {
		String sql = "INSERT INTO usuario(nome,dataNascimento,email,nomeUsuario,senha) VALUE(?,?,?,?,?)" ;
		
		//try-with-resources
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1,usuario.getNome());
			ps.setString(2,usuario.getDataNascimento());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getNomeUsuario());
			ps.setString(5, usuario.getSenha());
			
			ps.execute();
		}
	}

	public static void inserirUser(Usuario usuario) throws Exception {
		
		UsuarioAutenticador user = new UsuarioAutenticador();
		user.setNomeUsuario(usuario.getNomeUsuario());
		user.setSenha(usuario.getSenha());
		
		String sql = "INSERT INTO autenticador(nomeUsuario,senha) VALUE(?,?)" ;
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, user.getNomeUsuario());
			ps.setString(2, user.getSenha());
			
			ps.execute();
		}
		
	}
}
