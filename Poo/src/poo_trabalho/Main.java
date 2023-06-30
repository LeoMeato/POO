package poo_trabalho;

public class Main {
	
	public static void main(String[] args) {
			
			Sistema s = new Sistema();
			
			s.recuperarPersistência();
			s.executar();
			s.guardarPersistência();

	}
}