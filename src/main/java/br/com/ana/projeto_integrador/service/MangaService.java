package br.com.ana.projeto_integrador.service;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.com.ana.projeto_integrador.modelo.Manga;
import br.com.ana.projeto_integrador.modelo.Usuario;

@Path("manga")
public class MangaService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Manga> listar(Usuario usuario){
		
		
		try {
			return MangaDAO.listar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Manga manga) {
		
	}
}
