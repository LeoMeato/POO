package poo_trabalho;

import java.io.BufferedReader;
import java.io.FileReader;

public class Canção extends Musica {
	
	private String nomeArquivoLetra;
	private String letra="";
	public String getNomeArquivoLetra() {
		return nomeArquivoLetra;
	}
	public void setNomeArquivoLetra(String nomeArquivoLetra) {
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
	
}
