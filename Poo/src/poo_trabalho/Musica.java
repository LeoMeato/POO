package poo_trabalho;

public class Musica {
	
	private int identificador;
	private String título;
	private Duração duração;
	private String autores;
	private Data data;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getTítulo() {
		return título;
	}
	public void setTítulo(String título) {
		this.título = título;
	}
	public Duração getDuração() {
		return duração;
	}
	public void setDuração(Duração duração) {
		this.duração = duração;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getGênero_musical() {
		return gênero_musical;
	}
	public void setGênero_musical(String gênero_musical) {
		this.gênero_musical = gênero_musical;
	}
	String gênero_musical;
	
}
