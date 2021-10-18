package br.com.ana.projeto_integrador.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection connect() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro", "root", "root");
	}
	
}
