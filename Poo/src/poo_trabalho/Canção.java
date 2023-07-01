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
		byte[] struct = super.toByte();
		ByteBuffer bb = ByteBuffer.wrap(struct);
		aux = nomeArquivoLetra.getBytes();
		bb.put(204,aux);
		bb.put(224, "cancao".getBytes());
		struct = bb.array();
		return struct;
	}
	
}
