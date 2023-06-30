package poo_trabalho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Canção extends Musica {
	
	private String nomeArquivoLetra;
	private String letra="";
	public String getNomeArquivo() {
		return nomeArquivoLetra;
	}
	public void setNomeArquivo(String nomeArquivoLetra) {
		this.nomeArquivoLetra = nomeArquivoLetra;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public Canção(int identificador, String título, Duração duração, String autores, Data data,String gênero_musical, String nomeArquivoLetra) {
		super(identificador, título, duração, autores, data, gênero_musical);
		this.nomeArquivoLetra = nomeArquivoLetra;
		try {
			FileReader arq = new FileReader(nomeArquivoLetra);
			BufferedReader br = new BufferedReader(arq);
			boolean ioe = false;
			while(ioe == false){
				String s = br.readLine();
				if(s==null){
					ioe = true;
				}
				else{
					letra += "\n" + s;
				}
			}
			br.close();
			arq.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public Canção() {}
	
	public String toStringVizualizar() {
		return super.toStringVizualizar() + "\nLetra:\n" + letra;
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
		aux = nomeArquivoLetra.getBytes();
		bb.put(144,aux);
		bb.put(164, "cancao".getBytes());
		struct = bb.array();
		System.out.println("nem tão errado...");
		return struct;
	}
	
}
