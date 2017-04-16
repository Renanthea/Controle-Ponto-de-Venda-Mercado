package controle.pontodevendas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MercadoriaGUI extends JFrame {
	private JTextArea taLista;
	private JScrollPane barraRolagem;
	private JPanel painel;
	private JTable tabela;

	public MercadoriaGUI() {

		super("Todas Mercadorias");

		Container tela = getContentPane();

		tela.setLayout(new BorderLayout());

		Object[][] mercadorias = { { "1", "Sabão em Pó", "R$8.70" }, { "2", "Amaciante 500ml", "R$12.10" },
				{ "3", "Detergente 500ml", "R$3.20" }, { "4", "Água sanitária", "R$9.94" },
				{ "5", "Esponja de Aço", "R$1.20" }, { "6", "Buchinha de pia", "R$1.13" },
				{ "7", "Sabão em pedra", "R$2.00" }, { "8", "Sabonete", "R$1.50" }, { "9", "Shampoo 250Ml", "R$13.45" },
				{ "10", "Condicionador 250Ml", "R$14.13" }, { "11", "Desinfetante", "R$3.50" },
				{ "12", "Lustra móveis", "R$15.89" }, { "13", "Tira manchas 150Ml", "R$6.80" },
				{ "14", "Limpa Vidros 150Ml", "R$8.90" }, { "15", "Alcool 1L", "R$4.50" },
				{ "16", "Saco de lixo 30l", "R$8.97" }, { "17", "Saco de lixo 50l", "R$12.34" },
				{ "18", "Refrigerante 2l", "R$4.50" }, { "19", "Suco garrafa 1l", "R$5.67" },
				{ "20", "Suco caixinha 500ml", "R$2.34" }, { "21", "Suco sachê", "R$0.89" },
				{ "22", "Leite integral 1L", "R$3.89" }, { "23", "Leite desnatado 1L", "R$3.89" },
				{ "24", "Arroz 5kg", "R$18.45" }, { "25", "Feijão 2kg", "R$19.40" }, { "26", "Macarrão 500g", "R$" },
				{ "27", "Extrato de tomate 350g", "R$12.10" }, { "28", "Molho de tomate 350g", "R$3.20" },
				{ "29", "Sal 500g", "R$9.94" }, { "30", "Açucar 1kg", "R$1.20" },
				{ "31", "Achocolatado 500g", "R$1.13" }, { "32", "Bolacha 200g", "R$2.00" },
				{ "33", "Café 500g", "R$1.50" }, { "34", "Farofa pronta 500g", "R$13.45" },
				{ "35", "Fubá 500g", "R$14.13" }, { "36", "Farinha de trigo 1kg", "R$3.50" },
				{ "37", "Farinha de milho 500g", "R$15.89" }, { "38", "Farinha de mandioca 500g", "R$6.80" },
				{ "39", "Sardinha 250g", "R$8.90" }, { "40", "Atum 250g", "R$4.50" },
				{ "41", "Maionese 250g", "R$8.97" }, { "42", "Molho de pimenta 100g", "R$12.34" },
				{ "43", "Ervilha 350g", "R$4.50" }, { "44", "Milho verde 350g", "R$5.67" },
				{ "45", "Seleta 350g", "R$2.34" }, { "46", "Doce de leite 200g", "R$0.89" },
				{ "47", "Goiabada 300g", "R$3.89" }, { "48", "Milho de pipoca 300g", "R$3.89" },
				{ "49", "Óleo de Cozinha 1L", "R$18.45" }, { "50", "Leite em pó 500g", "R$19.40" },
				{ "51", "Creme de leite 350g", "R$8.70" }, { "52", "Leite condensado 350g", "R$12.10" },
				{ "53", "Pão de forma 400g", "R$3.20" }, { "54", "Alface un", "R$9.94" },
				{ "55", "Couve un", "R$1.20" }, { "56", "Batata 1kg", "R$1.13" }, { "57", "Tomate 1kg", "R$2.00" },
				{ "58", "Cenoura 500g", "R$1.50" }, { "59", "Beterraba 500g", "R$13.45" },
				{ "60", "Chicória un", "R$14.13" }, { "61", "Mandioca 1Kg", "R$3.50" },
				{ "62", "Chuchu 500g", "R$15.89" }, { "63", "Espinafre un", "R$6.80" },
				{ "64", "Banana 500g", "R$8.90" }, { "65", "Ovo dz", "R$4.50" }, { "66", "Uva 1kg", "R$8.97" },
				{ "67", "Abacate un", "R$12.34" }, { "68", "Mamão un", "R$4.50" }, { "69", "Melancia un", "R$5.67" },
				{ "70", "Melão un", "R$2.34" }, { "71", "Jiló 350g", "R$0.89" }, { "72", "Quiabo 300g", "R$3.89" },
				{ "73", "Salsa un", "R$3.89" }, { "74", "Cheiro verde un", "R$18.45" },
				{ "75", "Cebola 1kg", "R$19.40" }, { "76", "Queijo Minas 400g", "R$8.70" },
				{ "77", "Queijo Mussarela 300g", "R$12.10" }, { "78", "Queijo outros 300g", "R$3.20" },
				{ "79", "Manteiga 250g", "R$9.94" }, { "80", "Margarina 250g", "R$1.20" },
				{ "81", "Iogurte 500ml", "R$1.13" }, { "82", "Presunto 300g", "R$2.00" },
				{ "83", "Peixe 350g", "R$1.50" }, { "84", "Frango 1kg", "R$13.45" },
				{ "85", "Carne vermelha 1kg", "R$14.13" }, { "86", "Carne seca 500g", "R$3.50" },
				{ "87", "Salsicha 500g", "R$15.89" },

		};

		String[] colunas = { "Cod", "Descrição", "Preço" };

		painel = new JPanel();
		painel.setLayout(new GridLayout(1, 1));
		tabela = new JTable(mercadorias, colunas);
		barraRolagem = new JScrollPane(tabela);
		painel.add(barraRolagem);
		tela.add(painel, BorderLayout.CENTER);

		setSize(600, 600);
		setLocation(200, 200);
		setVisible(true);

	}
}