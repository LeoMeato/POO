package poo_trabalho;

public class CryptoException extends Exception {
 
    public CryptoException() {
    }
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}