package controle.pontodevendas;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.text.SimpleDateFormat;

public class Compra {

	private int idCompra;
	private String data;

	private PreparedStatement st;
	private Connection conn;
	private DatabaseConnect db;
	public static int returnID;

	// Construtor
	public Compra() {
		try {

			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dh = new SimpleDateFormat("HH:mm:ss");
			setData(df.format(date) + " - " + dh.format(date));
			String sql = "INSERT INTO compra (DATA) values (?)";
			db = new DatabaseConnect();
			conn = db.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, getData());
			st.executeUpdate();
			sql = "SELECT MAX(id) AS idCompra FROM compra";
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				setId(rs.getInt("idCompra"));
			}

			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Modificadores
	public void setId(int c) {
		this.idCompra = c;
	}

	public void setData(String d) {
		this.data = d;
	}

	// Acesso
	public int getId() {
		return idCompra;
	}

	public String getData() {
		return data;
	}
}