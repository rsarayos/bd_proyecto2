package org.itson.bdavanzadas.agencia_fiscal_excepciones;

/**
 * La clase PersistenciaException extiende la clase Exception y representa una
 * excepción específica relacionada con operaciones de persistencia en el
 * sistema.
 *
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricaardo Alán Gutiérrez Garcés
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor predeterminado de la excepción.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que recibe un mensaje para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause Causa subyacente de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa para la excepción.
     *
     * @param cause Causa subyacente de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que recibe un mensaje, una causa, y configuraciones
     * adicionales para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause Causa subyacente de la excepción.
     * @param enableSuppression Indica si la supresión de la excepción está
     * habilitada o no.
     * @param writableStackTrace Indica si se debe generar un rastreo de pila
     * adicional.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
