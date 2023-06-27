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
		byte[] struct = new byte[231];
		Arrays.fill(struct, (byte)0);
		ByteBuffer bb = ByteBuffer.wrap(struct);
		bb.putInt(0,getIdentificador());
		aux = getTítulo().getBytes();
		bb.put(4,aux);
		bb.putInt(64,getDuração().getSegundos());
		bb.putInt(68,getDuração().getMinutos());
		aux=getAutores().getBytes();
		bb.put(72,aux);
		bb.putInt(132, getData().getDia());
		bb.putInt(136, getData().getMês());
		bb.putInt(140, getData().getAno());
		aux = nomeArquivoPartitura.getBytes();
		bb.put(144,aux);
		bb.put(164, "musicainstrumental".getBytes());
		struct = bb.array();
		return struct;
	}
}
