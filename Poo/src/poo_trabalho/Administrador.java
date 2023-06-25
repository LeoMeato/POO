package poo_trabalho;

import java.nio.ByteBuffer;

public class Administrador extends Usuario {
	
	private String tipo = "adm";
	
	public Administrador(String nome, int identificador, String login, String senha) {
		super(nome, identificador, login, senha);
	}
	
	public void vizualizar(String titulo) {
		Musica m = ColeçãoMusicas.recuperar(titulo);
		if (m != null) System.out.println("Resultado para '" + titulo + "':\n\n" + m.toStringVizualizar());
		else System.out.println("Música não encontrada.");
	}
	
    public byte[] toByte(){
		byte[] struct = super.toByte();
		ByteBuffer bb = ByteBuffer.wrap(struct);
		bb.put(124, "administrador".getBytes());
		return struct;
	}

	public byte[] toLogInByte(){
		return super.toLogInByte();
	}
	
	public String getTipo() {
		return tipo;
	}

}
