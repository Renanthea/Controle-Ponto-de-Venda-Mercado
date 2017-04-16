package controle.pontodevendas;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ItemCompra {

	private int idItemCompra;
	private int quantidade;
	private int idMercadoria;
	private int idCompra;

	private PreparedStatement st;
	private Connection conn;
	private DatabaseConnect db;

	// Construtor Padrão
	public ItemCompra() {
		idItemCompra = 0;
		quantidade = 0;
		idMercadoria = 0;
		idCompra = 0;
	}

	// Construtor com Parâmetros
	public ItemCompra(int id) {
		idItemCompra = id;
		quantidade = 0;
		idMercadoria = id;
		idCompra = id;
	}

	public ItemCompra(int iic, int q, int im, int ic) {
		setIdItemCompra(iic);
		setQuantidade(q);
		setIdMercadoria(im);
		setIdCompra(ic);
		db = new DatabaseConnect();
		conn = db.getConnection();
	}

	public void search() {
		String sql = "SELECT * FROM compra WHERE id = ?";
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, getIdItemCompra());
			st.setInt(1, getIdMercadoria());
			st.setInt(1, getIdCompra());
			rs = st.executeQuery();

			if (rs.next()) {
				setQuantidade(rs.getInt("quantidade"));
			}

			st.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		db.closeConnection();
	}

	// Modificadores
	public void setIdItemCompra(int iic) {

		if (iic != 0)
			idItemCompra = iic;
		else {
			try {
				// criar String para inserir nova compra
				String sql = "SELECT MAX(idItemCompra) AS idItemCompra FROM itemCompra WHERE idCompra = ?";
				db = new DatabaseConnect();
				conn = db.getConnection();
				st = conn.prepareStatement(sql);
				st.setInt(1, getIdCompra());
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					idItemCompra = (rs.getInt("idItemCompra") + 1);
				}

				// insere registro no itemCompra
				sql = "INSERT INTO itemCompra (idItemCompra, quantidade, idMercadoria, idCompra) values (?, ?, ?, ?)";
				db = new DatabaseConnect();
				conn = db.getConnection();
				st = conn.prepareStatement(sql);

				st.setInt(1, getIdItemCompra());
				st.setInt(2, getQuantidade());
				st.setInt(3, getIdMercadoria());
				st.setInt(4, getIdCompra());

				st.executeUpdate();
				// fecha conexao
				db.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setQuantidade(int q) {
		quantidade = q;
	}

	public void setIdMercadoria(int im) {
		idMercadoria = im;
	}

	public void setIdCompra(int ic) {
		idCompra = ic;
	}

	// Acesso
	public int getIdItemCompra() {
		return idItemCompra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getIdMercadoria() {
		return idMercadoria;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public String listarProdutos() {
		String sql = "";
		String retorno = "Lista vazia!";
		ResultSet rs = null;

		try {
			retorno = "";
			sql = "SELECT * FROM compra ORDER BY id";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				retorno += "\n# " + rs.getInt("id") + " -" + "  " + rs.getString("data") + " -"
						+ "----------------------------------------------------------------------------------------------";
			}
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return retorno;
	}

}