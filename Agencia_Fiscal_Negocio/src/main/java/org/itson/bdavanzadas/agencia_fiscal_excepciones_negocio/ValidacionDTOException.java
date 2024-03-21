package org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio;

/**
 * Clase de excepción personalizada para manejar errores de validación en objetos DTO (Data Transfer Object).
 */
public class ValidacionDTOException extends Exception{
 
    /**
     * Constructor predeterminado de la excepción.
     */
    public ValidacionDTOException() {
    }

    /**
     * Constructor que recibe un mensaje para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     */
    public ValidacionDTOException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause   Causa subyacente de la excepción.
     */
    public ValidacionDTOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa para la excepción.
     *
     * @param cause Causa subyacente de la excepción.
     */
    public ValidacionDTOException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que recibe un mensaje, una causa, y configuraciones adicionales para la excepción.
     *
     * @param message            Mensaje descriptivo de la excepción.
     * @param cause              Causa subyacente de la excepción.
     * @param enableSuppression  Indica si la supresión de la excepción está habilitada o no.
     * @param writableStackTrace Indica si se debe generar un rastreo de pila adicional.
     */
    public ValidacionDTOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
