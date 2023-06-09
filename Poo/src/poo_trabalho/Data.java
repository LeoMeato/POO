package poo_trabalho;

public class Data {
	
	private int dia;
	private int mês;
	private int ano;
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMês() {
		return mês;
	}
	public void setMês(int mês) {
		this.mês = mês;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Data(int dia, int mês, int ano) {
		this.dia = dia;
		this.mês = mês;
		this.ano = ano;
	}
	
	public String toStringVizualizar() {
		return "\nData: " + dia + "/" + mês + "/" + ano;
	}

}
