package controle.pontodevendas;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

abstract class MysqlConnect implements Connect {

	public Connection conn;

	public MysqlConnect() {
		conn = null;
		String url = "jdbc:mysql://localhost/";
		String dbName = "mercado2015";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "alunos";
		String password = "alunos";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
					"Erro...", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}