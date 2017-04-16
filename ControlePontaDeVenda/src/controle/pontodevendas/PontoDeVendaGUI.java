package controle.pontodevendas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class PontoDeVendaGUI extends JFrame implements ActionListener {
	// Atributos
	private JButton bNovaC, bCancelarC, bFecharC, bFecharPDV, bAddM, bCancelarM, bExibirM, bExibirTop, bSim, bNao;
	private JLabel lTotalC, lTotalRs, lCodM, lQuantM, lMsg;
	private JTextField tCodM, tQuantM;
	public JTextArea a;
	private SimpleDateFormat df, dh;
	private Compra newCompra;
	protected Compra comp;
	ArrayList<String> pro = new ArrayList<>();

	private DecimalFormat df2, df03;

	double soma = 0.0;
	double sub = 0.0;

	public PontoDeVendaGUI() {
		super("Mercado USJT - Ponto de Venda (PDV)");

		df2 = new DecimalFormat("#,##0.00");
		df03 = new DecimalFormat("000");

		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());

		JPanel direita = new JPanel();
		direita.setLayout(new GridLayout(8, 1));

		JPanel meio = new JPanel();
		meio.setLayout(new GridLayout(1, 1));

		JPanel esquerda = new JPanel();
		esquerda.setLayout(new GridLayout(6, 1));

		a = new JTextArea(5, 30);
		a.setFont(new Font("Courier New", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(a);
		setPreferredSize(new Dimension(450, 110));

		lTotalC = new JLabel("Total Da Compra: ");
		lTotalRs = new JLabel("R$: ");
		lCodM = new JLabel("Código Mercadoria");
		lQuantM = new JLabel("Quantidade Mercadoria");

		tCodM = new JTextField(10);
		tQuantM = new JTextField(10);

		// Botões
		bNovaC = new JButton("Nova Compra");
		bCancelarC = new JButton("Cancelar Compra");
		bFecharC = new JButton("Fechar Compra");
		bFecharPDV = new JButton("Fechar PDV");
		bAddM = new JButton("Adicionar Mercadoria");
		bCancelarM = new JButton("Cancelar Mercadoria");
		bExibirM = new JButton("Exibir Mercadorias");
		bExibirTop = new JButton("Exibir TOP 10");

		// Ativar Botões
		bNovaC.addActionListener(this);
		bCancelarC.addActionListener(this);
		bFecharC.addActionListener(this);
		bFecharPDV.addActionListener(this);
		bAddM.addActionListener(this);
		bCancelarM.addActionListener(this);
		bExibirM.addActionListener(this);
		bExibirTop.addActionListener(this);

		bAddM.setEnabled(false);
		bCancelarM.setEnabled(false);

		esquerda.add(bNovaC);
		esquerda.add(bCancelarC);
		esquerda.add(bFecharC);
		esquerda.add(lTotalC);
		esquerda.add(lTotalRs);
		esquerda.add(bFecharPDV);

		direita.add(lCodM);
		direita.add(tCodM);
		direita.add(lQuantM);
		direita.add(tQuantM);
		direita.add(bAddM);
		direita.add(bCancelarM);
		direita.add(bExibirM);
		direita.add(bExibirTop);

		meio.add(scrollPane, BorderLayout.CENTER);
		a.setEditable(false);

		cont.add(esquerda, BorderLayout.WEST);
		cont.add(meio, BorderLayout.CENTER);
		cont.add(direita, BorderLayout.EAST);

		setSize(800, 500);
		setResizable(false);
		setLocation(200, 200);

		setVisible(true);
		bCancelarC.setEnabled(false);
		bFecharC.setEnabled(false);
		bExibirTop.setEnabled(false);

	}

	// Nova Compra
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == bNovaC) {
			try {

				bAddM.setEnabled(true);
				bCancelarM.setEnabled(true);
				bNovaC.setEnabled(false);
				bFecharC.setEnabled(true);
				bExibirTop.setEnabled(true);
				bCancelarC.setEnabled(true);
				bNovaC.setEnabled(true);

				newCompra = new Compra();

				a.append("Nova Compra Iniciada - " + newCompra.getId() + " Data: " + newCompra.getData() + "\n");
				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");
				tCodM.requestFocus();
			}

			catch (Exception ex) {
				a.append("Error");
			}
		}

		// Exibir Mercadorias
		if (evento.getSource() == bExibirM) {
			try {

				MercadoriaGUI mer = new MercadoriaGUI();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao exibir Mercadorias", "Erro", -1);
			}
		}

		// Fechar PDV
		if (evento.getSource() == bFecharPDV) {
			try {
				System.exit(0);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro a fechr o programa", "Erro", -1);
			}
		}

		// Fechar Compra
		if (evento.getSource() == bFecharC) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja fechar a compra? ");
		}

		if (evento.getSource() == bAddM) {
			try {

				Mercadoria m = new Mercadoria(Integer.parseInt(tCodM.getText()));
				m.setQuant(Integer.parseInt(tQuantM.getText()));
				m.search();

				ItemCompra itCompra = new ItemCompra();

				itCompra.setIdCompra(newCompra.getId());
				itCompra.setQuantidade(m.getQuant());
				itCompra.setIdMercadoria(m.getId());
				itCompra.setIdItemCompra(0);

				a.append("" + df03.format(itCompra.getIdItemCompra()));
				a.append(" - " + m.getDescricao().substring(0, 20));
				a.append(" - " + m.getQuant());
				a.append(" x " + df2.format(m.getPreco()));
				a.append(" = " + df2.format(m.getPreco() * m.getQuant()) + "\n");

				tCodM.setText("");
				tQuantM.setText("");

				soma += m.precoTotal();

				lTotalRs.setText("R$: " + df2.format(soma));
				tCodM.requestFocus();
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao adionar Mercadoria", "Erro", -1);
			}
		}

		if (evento.getSource() == bFecharC) {
			try {
				Pagamento pag = new Pagamento();

				Date hoje = new Date();
				Date date = new Date();
				df = new SimpleDateFormat("dd/MM/yyyy");
				dh = new SimpleDateFormat("HH:mm:ss");

				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");
				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");
				a.append("Compra Finalizada." + df.format(hoje) + " - " + dh.format(date) + "\n");
				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");
				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");
				a.append("Total a Pagar: " + lTotalRs.getText() + "\n");
				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");
				a.append(
						"-----------------------------------------------------------------------------------------------------------------------------\n");

				bAddM.setEnabled(false);
				bCancelarM.setEnabled(false);
				bCancelarC.setEnabled(false);
				bFecharC.setEnabled(false);
				bNovaC.setEnabled(true);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error ao fechar compra.", "Atenção!", -1);
			}
		}

		// Cancelar Mercadoria
		if (evento.getSource() == bCancelarM) {
			int n = 0;
			int i = 0;
			Iterator<String> iterator = pro.iterator();

			String msg = "";
			while (iterator.hasNext()) {
				msg += "\nCod. " + (i + 1) + iterator.next();
				i++;
			}
			JOptionPane.showMessageDialog(null, msg);

			n = Integer.parseInt(JOptionPane.showInputDialog("\nInforme a posição a ser excluída:\n"));

			try {
				pro.remove(n);
			}

			catch (IndexOutOfBoundsException p) {
				System.out.printf("\nErro: posição inválida (%s).");
			}
		}

		// Exibir TOP 10
		if (evento.getSource() == bExibirTop) {
			try {
				Mercadoria merc = new Mercadoria();
				JTextArea a = new JTextArea(merc.top10());
				JScrollPane v = new JScrollPane(a);
				a.setEditable(false);
				a.setLineWrap(true);
				a.setWrapStyleWord(true);
				a.setPreferredSize(new Dimension(400, 350));
				JOptionPane.showMessageDialog(null, a, "TOP10", -1);
			}

			catch (Exception ex) {

			}
		}
	}

}
