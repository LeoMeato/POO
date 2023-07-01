package poo_trabalho;

import java.nio.ByteBuffer;
import java.util.Arrays;

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
	
	public byte[] toByte(){
		byte[]aux;
		byte[] struct = super.toByte();
		ByteBuffer bb = ByteBuffer.wrap(struct);
		aux = nomeArquivoPartitura.getBytes();
		bb.put(204,aux);
		bb.put(224, "musicainstrumental".getBytes());
		struct = bb.array();
		return struct;
	}

	public String getNomeArquivo() {
		return nomeArquivoPartitura;
	}

	public void setNomeArquivo(String nomeArquivoPartitura) {
		this.nomeArquivoPartitura = nomeArquivoPartitura;
	}
}
