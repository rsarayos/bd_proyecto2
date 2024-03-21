package org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio;

/**
 *
 * @author alex_
 */
public class NegociosException extends Exception{

    public NegociosException() {
    }

    public NegociosException(String message) {
        super(message);
    }

    public NegociosException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegociosException(Throwable cause) {
        super(cause);
    }

    public NegociosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
