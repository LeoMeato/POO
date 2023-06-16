package poo_trabalho;

public class Duração {
	
	private int segundos;
	private int minutos;
	
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public Duração(int segundos, int minutos) {
		this.segundos = segundos;
		this.minutos = minutos;
	}

}
