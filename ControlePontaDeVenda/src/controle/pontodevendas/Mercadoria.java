package controle.pontodevendas;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mercadoria {

	private int idMercadoria;
	private String descricao;
	private double preco;
	private int quantidade;
	protected double precoTotal;
	private int idCompra;

	private PreparedStatement st;
	private Connection conn;
	private DatabaseConnect db;

	public Mercadoria() {
		this(0, "", 0.0);
	}

	public Mercadoria(int id) {
		this(id, "", 0.0);
	}

	public Mercadoria(int c, String d, double p) {
		setId(c);
		setDescricao(d + "                    ");
		setPreco(p);
		db = new DatabaseConnect();
		conn = db.getConnection();
	}

	public void search() {
		String sql = "SELECT * FROM mercadoria WHERE id = ?";
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, getId());
			rs = st.executeQuery();
			if (rs.next()) {
				setDescricao(rs.getString("descricao") + "                    ");
				setPreco(rs.getDouble("preco"));
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
	}

	public void del() {
		String sql = "SELECT * FROM mercadoria WHERE id = ?";
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, getId());
			rs = st.executeQuery();
			if (rs.next()) {
				setDescricao(rs.getString("descricao"));
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
	}

	public void setId(int c) {
		this.idMercadoria = c;
	}

	public void setDescricao(String d) {
		this.descricao = d;
	}

	public void setPreco(double p) {
		this.preco = p;
	}

	public void setQuant(int q) {
		quantidade = q;
	}

	public void setPrecoTotal(int p) {
		precoTotal = p;
	}

	public int getId() {
		return idMercadoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuant() {
		return quantidade;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public String listarProdutos() {
		String sql = "";
		String retorno = "Lista vazia!";
		ResultSet rs = null;

		try {
			retorno = "";
			sql = "SELECT * FROM mercadoria ORDER BY id";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				retorno += "\n# " + rs.getInt("id") + " -" + "  " + rs.getString("descricao") + " -" + "  R$: "
						+ rs.getDouble("preco") + "\n"
						+ "----------------------------------------------------------------------------------------------";
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return retorno;
	}

	public double precoTotal() {

		return getPreco() * getQuant();

	}

	public boolean deletar() {
		boolean sucesso = false;
		String sql = "";

		try {
			sql = "delete FROM itemmercadoria WHERE id_compra = " + idCompra;
			st = conn.prepareStatement(sql);
			st.executeUpdate();

			sql = "delete FROM compra ORDER BY id_compra DESC LIMIT 1";
			st = conn.prepareStatement(sql);
			st.executeUpdate();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}

	public boolean top() {
		String sql = "";
		boolean sucesso = false;
		try {
			sql = "INSERT INTO top (descricao , quantidade) VALUES (? , ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, getDescricao());
			st.setInt(2, getQuant());

			st.executeUpdate();
			sucesso = true;
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return sucesso;
	}

	public String top10() {
		String sql = "";
		String retorno = "Lista vazia!";
		ResultSet rs = null;
		try {
			retorno = "";
			sql = "SELECT * FROM top ORDER BY quantidade desc";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			int i = 1;
			while (rs.next()) {

				retorno += "\n#" + i + " Cod. " + rs.getInt("id") + " -" + "  Descricão" + rs.getString("descricao")
						+ " -" + "  Qtd. " + rs.getInt("quantidade") + "\n"
						+ "----------------------------------------------------------------------------------------------";
				i++;
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return retorno;
	}
}
