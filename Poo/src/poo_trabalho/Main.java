package poo_trabalho;

public class Main {

	public static void main(String[] args) {
	Duração dur = new Duração();
	dur.setMinutos(2);
	dur.setSegundos(10);
	Data dat = new Data();
	dat.setDia(22);
	dat.setMês(2);
	dat.setAno(2003);
	Musica teste = new Canção(0, "love of my life", dur, "eu", dat, "Rock","letra.txt");
	System.out.println(teste.getLetra());
	System.out.println(teste.getTítulo());

}
}