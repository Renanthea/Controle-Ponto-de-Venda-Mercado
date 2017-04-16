package controle.pontodevendas;

public class PagamentoEmCartao {
	protected double vtc;
	protected int parcelas;
	protected Mercadoria mer;
	protected PontoDeVendaGUI PontoDeVenda;

	public PagamentoEmCartao(int p, double v) {
		parcelas = p;
		vtc = v;
	}

	public void setParcelas(int a) {
		parcelas = a;
	}

	public void setVtc(double c) {
		vtc = c;
	}

	public int getParcelas() {
		return parcelas;
	}

	public double getVtc() {
		return vtc;
	}

	public String exibir() {
		return "Valor da Compra: " + getVtc() + "\n" + "Quantidades de Parcelas: " + getParcelas();
	}
}