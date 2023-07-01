package poo_trabalho;

import java.nio.ByteBuffer;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ColeçãoMusicas {
	
	private static Collection<Musica> coleção = new ArrayList<Musica>();
	
	public static Musica recuperar(String nome) {            
		Iterator<Musica> it = coleção.iterator();
		Musica m;
		int tamanho = coleção.size();
		for (int i = 0; i < tamanho; i++) {
			m = it.next();
			if (m.getTítulo().toLowerCase().compareTo(nome.toLowerCase()) == 0) return m;
		}
		return null;
	}
	
	public static boolean cadastra(Musica musica) {
		boolean contém = coleção.contains(musica);
		if(!contém) coleção.add(musica);
		return !contém;
	}
	
	/*public boolean atualizar(Musica musica) {          // o que seria atualizar uma música? Só tirar a antiga e botar uma nova?
		
	}*/
	
	public static boolean remover(Musica musica) {
		boolean contém = coleção.contains(musica);
		if(contém) coleção.remove(musica);
		return contém;
	}

	public static void escrever(){
		Iterator<Musica> it = coleção.iterator();
		Musica m;
		Collection<byte[]> col = new ArrayList<byte[]>();
		for (int i = 0; i < coleção.size(); i++) {
			m = it.next();
			col.add(m.toByte());
		}
		Persistência.WriteBin(col, "songs.bin");
	}
	
	public static void vizualizar(String titulo) {
		Musica m = recuperar(titulo);
		if (m != null) System.out.println("Resultado para '" + titulo + "':\n\n" + m.toStringVizualizar());
		else System.out.println("Música não encontrada.");
	}

	public static void novaMusica() { //não sei se deixo aqui ou em Sistema
		
		Scanner s = new Scanner(System.in);
		int escolha;
		Musica m;
		String titulo;
		String autores;
		String genero;
		int identificador;
		Duração duracao;
		int segundos;
		int dia;
		int mes;
		int ano;
		Data data;
		
		System.out.println("\nTítulo: ");
		titulo = s.nextLine();
		System.out.println("\nIdentificador: ");
		identificador = s.nextInt();
		s.nextLine();
		System.out.println("\nAutores: ");
		autores = s.nextLine();
		System.out.println("\nGênero Musical: ");
		genero = s.nextLine();
		System.out.println("\nDuração (segundos): ");
		segundos = s.nextInt();
		System.out.println("\nDia: ");
		dia = s.nextInt();
		System.out.println("\nMês: ");
		mes = s.nextInt();
		System.out.println("\nAno: ");
		ano = s.nextInt();
		
		duracao = new Duração(segundos % 60, (segundos - (segundos % 60)) / 60);
		data = new Data(dia, mes, ano);
		
		System.out.println("\nMúsica Instrumental (1) ou Canção (2)? ");
		escolha = Sistema.tratarResposta(2, s);
		s.nextLine();
		if (escolha == 1) {
			System.out.println("\nNome do arquivo da partitura: ");
			m = new MusicaInstrumental(identificador, titulo, duracao, autores, data, genero, s.nextLine());
		}
		else {
			System.out.println("\nNome do arquivo da letra: ");
			m = new Canção(identificador, titulo, duracao, autores, data, genero, s.nextLine());
		}
		
		boolean foi = cadastra(m);
		if (foi) System.out.println("Música cadastrada com sucesso!");
		else System.out.println("Música já existe.");

	}
	
	public static void lê() {

	    Musica m = null;
	
	    try (DataInputStream input = Persistência.ReadBin("songs.bin")) {
	        while (input.available() > 0) {
	            byte[] titulob = new byte[60]; // Tamanho máximo da string 1
	            byte[] autoresb = new byte[60]; // Tamanho máximo da string 2
	            byte[] arquivob = new byte[20];
	            byte[] tipob = new byte[(231 - 164)];
	            byte[] generob = new byte[60];
	            int identificador, seg, min, dia, mes, ano;
	            identificador = input.readInt();
	            input.read(titulob); // Lê os bytes da string 1
	            seg = input.readInt();
	            min = input.readInt();
	            input.read(autoresb); // Lê os bytes da string 2
	            dia = input.readInt();
	            mes = input.readInt();
	            ano = input.readInt();
	            input.read(generob);
	            input.read(arquivob);
	            input.read(tipob);
	            String titulo = new String(titulob).trim();
	            String autores = new String(autoresb).trim();
	            String genero = new String(generob).trim();
	            String arquivo = new String(arquivob).trim();
	            String tipo = new String(tipob).trim();
	            if (tipo.compareTo("musicainstrumental") == 0) {
	            	m = new MusicaInstrumental(identificador, titulo, new Duração(seg, min), autores, new Data(dia, mes, ano), genero, arquivo);
	            } else if (tipo.compareTo("cancao") == 0) {
					m = new Canção(identificador, titulo, new Duração(seg, min), autores, new Data(dia, mes, ano), genero, arquivo);
				}
	            coleção.add(m);
	        }
	        input.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
        
    }
	
	public static Musica buscaID(int id) {
		Iterator<Musica> it = coleção.iterator();
		Musica m;
		for (int i = 0; i < coleção.size(); i++) {
			m = it.next();
			if (m.getIdentificador() == id) return m;
		}
		return null;
	}

}
