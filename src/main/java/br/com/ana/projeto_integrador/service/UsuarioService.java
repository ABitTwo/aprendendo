package br.com.ana.projeto_integrador.service;

import br.com.ana.projeto_integrador.modelo.Usuario;
import br.com.ana.projeto_integrador.modelo.UsuarioAutenticador;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("usuario")
public class UsuarioService {
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario)  {
		try {
			UsuarioDAO.inserir(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("chegou aqui");
		
		try {
			UsuarioDAO.inserirUser(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
