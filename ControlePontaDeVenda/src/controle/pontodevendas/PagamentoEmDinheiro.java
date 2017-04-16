package controle.pontodevendas;

public class PagamentoEmDinheiro {
	protected double vtc;
	protected double vr;
	protected double troco;
	protected Mercadoria mer;

	public PagamentoEmDinheiro(double v, double b) {
		vtc = v;
		vr = b;
		troco = getTroco();
	}

	public void setVr(double a) {
		vr = a;
	}

	public void setTroco(double x) {
		troco = x;
	}

	public void setVtc(double c) {
		vtc = c;
	}

	public double getVr() {
		return vr;
	}

	public double getTroco() {
		return troco = vr - vtc;
	}

	public double getVtc() {
		return vtc;
	}

	public String exibir() {
		return "Valor da Compra: " + getVtc() + "\n" + "Valor Recebido" + getVr() + "\n" + "Troco: " + getTroco();

	}
}