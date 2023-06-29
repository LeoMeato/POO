package poo_trabalho;

public abstract class Musica {
	
	private int identificador; // 4 bytes
	private String título;     // 8 bytes
	private Duração duração;   // 8 bytes
	private String autores;    // 8 bytes
	private Data data;         //12 bytes
	
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

	public Musica(int identificador, String título, Duração duração, String autores, Data data, String gênero_musical) {
		this.identificador = identificador;
		this.título = título;
		this.duração = duração;
		this.autores = autores;
		this.data = data;
		this.gênero_musical = gênero_musical;
	}
	public Musica() {}
	

	public String toStringVizualizar() {
		return "Identificador: " + identificador + "\nTítulo: " + título + duração.toStringVizualizar() + "\nAutores: " + autores + data.toStringVizualizar() + "\nGênero Musical: " + gênero_musical;
	}

	public byte[] toByte(){
		return null;
	}
	
	public String getNomeArquivo() {
		return null;
	}

	public void setNomeArquivo(String nomeArquivoPartitura) {
	
	}
	
	
}
