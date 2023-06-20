package poo_trabalho;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class Persistência {
    public static <T> boolean WriteBin(Collection<byte[]> coleção, int arquivo) {
        try {
            String nomearquivo="Hola";
        
            if((arquivo-1)==0) nomearquivo = "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\users.txt";
            else if((arquivo-2)==0) nomearquivo = "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\songs.txt";
            else nomearquivo = "C:\\Users\\estev\\OneDrive\\\u00C1rea de Trabalho\\POO\\Poo\\src\\poo_trabalho\\login.txt";
            
            OutputStream outputstream = new FileOutputStream(nomearquivo);
            DataOutputStream out = new DataOutputStream(outputstream);
            for(byte[] b:coleção){
                out.write(b);
            }
            out.close();
            outputstream.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
            
    }
}

//criar variável b; consertar T genérico e ver questão do seletor de arquivos