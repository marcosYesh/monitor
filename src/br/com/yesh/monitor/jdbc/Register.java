package br.com.yesh.monitor.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register {
	
	
	public static void setActive(Boolean ativo) {
		String evento = "Servidor Desligou";
		Integer tipoEvento = 0;
		if (ativo) {
			evento = "Servidor Religou";
			tipoEvento = 1;
		}
		String sql = "INSERT INTO `monitor`.`evento` (`evento`,`tipoEvento`) VALUES (?,?);";
		try {
			Connection connection = FabricaDeConexao.getConexaoMySQL();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, evento);
			stmt.setInt(2, tipoEvento);
			stmt.execute();
			stmt.close();
			connection.close();
			stmt = null;
			connection = null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	
	
	
	
	
}
