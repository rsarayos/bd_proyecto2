package org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio;

/**
 * Clase de excepción personalizada para manejar errores relacionados con operaciones de negocio.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class NegociosException extends Exception{

    /**
     * Constructor por defecto de la excepción de negocios.
     */
    public NegociosException() {
    }

    /**
     * Constructor con un mensaje para la excepción de negocios.
     *
     * @param message El mensaje que describe el error de negocios.
     */
    public NegociosException(String message) {
        super(message);
    }

    /**
     * Constructor con un mensaje y una causa para la excepción de negocios.
     *
     * @param message El mensaje que describe el error de negocios.
     * @param cause La causa que provocó la excepción de negocios.
     */
    public NegociosException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con una causa para la excepción de negocios.
     *
     * @param cause La causa que provocó la excepción de negocios.
     */
    public NegociosException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor con un mensaje, una causa, la opción de habilitar la supresión y la trazabilidad.
     *
     * @param message El mensaje que describe el error de negocios.
     * @param cause La causa que provocó la excepción de negocios.
     * @param enableSuppression Indica si la supresión está habilitada o no.
     * @param writableStackTrace Indica si la trazabilidad es editable o no.
     */
    public NegociosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
