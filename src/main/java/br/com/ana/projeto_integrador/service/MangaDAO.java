package br.com.ana.projeto_integrador.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ana.projeto_integrador.modelo.Manga;
import br.com.ana.projeto_integrador.modelo.Usuario;

public class MangaDAO {
	
	public static List<Manga> listar(Usuario usuario) throws Exception{
		String sql = "SELECT * FROM manga WHERE usuario = ?";
		
		List<Manga> list = new ArrayList<Manga>();
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, (int) usuario.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Manga manga = new Manga();
				manga.setId(rs.getInt("mangaid"));
				manga.setNome(rs.getString("nome"));
				manga.setAtor(rs.getString("ator"));
				manga.setTipo(rs.getString("tipo"));
				manga.setVolume(rs.getInt("volume"));
				manga.setValor(rs.getDouble("valor"));
				
				list.add(manga);
			}
			
			return list;
		}
		
	}
	
	public static void inserir(Manga manga) throws Exception {
		String sql = "INSERT INTO manga(nome,ator,tipo,volume,nota) VALUE(?,?,?,?,?)";
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, manga.getNome());
			ps.setString(2, manga.getAtor());
			ps.setString(3, manga.getTipo());
			ps.setInt(4, manga.getVolume());
			ps.setDouble(5, manga.getValor());

			
			ps.execute();
		}
	}
	
	
}
