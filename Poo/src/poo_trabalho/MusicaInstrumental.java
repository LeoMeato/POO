package poo_trabalho;

public class MusicaInstrumental extends Musica {

	private String nomeArquivoPartitura;

	public MusicaInstrumental(int identificador, String título, Duração duração, String autores, Data data,
			String gênero_musical, String nomeArquivoPartitura) {
		super(identificador, título, duração, autores, data, gênero_musical);
		this.nomeArquivoPartitura = nomeArquivoPartitura;
	}
	
	public MusicaInstrumental() {}
	
	public String toStringVizualizar() {
		return super.toStringVizualizar() + "\nNome do Arquivo da Partitura: " + nomeArquivoPartitura;
	}
	
}
