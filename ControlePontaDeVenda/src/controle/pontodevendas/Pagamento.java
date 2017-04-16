package controle.pontodevendas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Pagamento extends JFrame implements ActionListener {
	public JButton bcartao, bdinheiro;
	public PontoDeVendaGUI PontoDeVenda;
	private PagamentoEmCartao pc;
	private PagamentoEmDinheiro pd;
	private int parcelas;
	private double troco;
	private double vtc;

	public Pagamento() {
		super("Forma de Pagamento");

		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());

		JPanel baixo = new JPanel();
		baixo.setLayout(new GridLayout(1, 2));

		bcartao = new JButton("Pagamento em Cartão");
		bdinheiro = new JButton("Pagamento em Dinheiro");

		bcartao.addActionListener(this);
		bdinheiro.addActionListener(this);

		baixo.add(bcartao);
		baixo.add(bdinheiro);

		cont.add(baixo, BorderLayout.CENTER);

		setSize(350, 100);
		setResizable(false);
		setLocation(200, 200);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == bcartao) {
			try {
				String c = JOptionPane.showInputDialog("Informe o CPF");
				String b = JOptionPane.showInputDialog("Informe o valor da Compra");
				String a = JOptionPane.showInputDialog("Informe a quantidade de parcelas");
				pc = new PagamentoEmCartao(Integer.parseInt(a), Double.parseDouble(b));

				String d = "********************** Nota Fiscal ********************** " + "\n\n" + "CPF: " + c + "\n"
						+ "Valor da compra: " + b + "\nQuantidade de parcelas: " + a;

				JOptionPane.showMessageDialog(null, "" + pc.exibir(), "Pagamento em Cartão", -1);

				JOptionPane.showConfirmDialog(null, "Deseja imprimir nota de compra?", "Pagamento efetuado",
						JOptionPane.YES_NO_OPTION);

				JOptionPane.showMessageDialog(null, d);

			} catch (Exception ex) {

			}

		}

		if (evento.getSource() == bdinheiro) {
			try {
				String c = JOptionPane.showInputDialog("Informe o valor da Compra");
				String d = JOptionPane.showInputDialog("Informe o valor recebido");
				pd = new PagamentoEmDinheiro(Double.parseDouble(c), Double.parseDouble(d));

				JOptionPane.showMessageDialog(null, "" + pd.exibir(), "Pagamento em Dinheiro", -1);

				JOptionPane.showConfirmDialog(null, "Deseja imprimir nota de compra?", "Pagamento efetuado",
						JOptionPane.YES_NO_OPTION);
			} catch (Exception ex) {

			}

		}
	}

	public void retornaCartao() {
		PontoDeVenda.a.append("Cartão. \n");
		PontoDeVenda.a.append("Quantidade de parcelas: " + getParcelas() + "\n");
		PontoDeVenda.a.append(
				"-----------------------------------------------------------------------------------------------------------------------------\n");
	}

	public void setParcela(int p) {
		parcelas = p;
	}

	public int getParcelas() {
		return parcelas;
	}

	public double getTroco() {
		return troco;
	}

	public double getVtc() {
		return vtc;
	}
}