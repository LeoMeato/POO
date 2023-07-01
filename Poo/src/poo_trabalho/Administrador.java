package poo_trabalho;

import java.nio.ByteBuffer;

public class Administrador extends Usuario {
	
	@Override
	public String toString() {
		return "Administrador [tipo=" + tipo + ", toString()=" + super.toString() + ", getNome()=" + getNome()
				+ ", getIdentificador()=" + getIdentificador() + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + "]";
	}

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
		bb.put(124, "adm".getBytes());
		struct = bb.array();
		return struct;
	}

	public byte[] toLogInByte(){
		return super.toLogInByte();
	}
	
	public String getTipo() {
		return tipo;
	}

}
