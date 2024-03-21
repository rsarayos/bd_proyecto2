
package org.itson.bdavanzadas.agencia_fiscal_entidades_jpa;

/**
 * Clase que define los costos asociados a diferentes productos del sistema.
 */
public class Costos {

    // Costo de una licencia normal con duración de un año.
    public static final float COSTO_NORMAL_UN_ANIO = 600f;
    // Costo de una licencia normal con duración de dos años.
    public static final float COSTO_NORMAL_DOS_ANIOS = 900f;
    // Costo de una licencia normal con duración de tres años.
    public static final float COSTO_NORMAL_TRES_ANIOS = 1100f;

    // Costo de una licencia para personas discapacitadas con duración de un año.
    public static final float COSTO_DISCAPACITADOS_UN_ANIO = 200f;
    // Costo de una licencia para personas discapacitadas con duración de dos años.
    public static final float COSTO_DISCAPACITADOS_DOS_ANIOS = 500f;
    // Costo de una licencia para personas discapacitadas con duración de tres años.
    public static final float COSTO_DISCAPACITADOS_TRES_ANIOS = 700f;

    // Costo de la tramitación de placas para un automóvil nuevo.
    public static final float COSTO_PLACAS_AUTO_NUEVO = 1500f;
    // Costo de la tramitación de placas para un automóvil usado.
    public static final float COSTO_PLACAS_AUTO_USADO = 1000f;

    /**
     * Método que obtiene el costo de una licencia en base al tipo de licencia y
     * si la persona es discapacitada o no.
     *
     * @param tipoLicencia Tipo de licencia.
     * @param esDiscapacitado Indicador de si la persona es discapacitada o no.
     * @return El costo de la licencia.
     * @throws IllegalArgumentException Si el tipo de licencia no es válido.
     */
    public static float obtenerCostoLicencia(TipoLicencia tipoLicencia, Boolean esDiscapacitado) {
        switch (tipoLicencia) {
            case UN_ANIO:
                return esDiscapacitado ? COSTO_DISCAPACITADOS_UN_ANIO : COSTO_NORMAL_UN_ANIO;
            case DOS_ANIOS:
                return esDiscapacitado ? COSTO_DISCAPACITADOS_DOS_ANIOS : COSTO_NORMAL_DOS_ANIOS;
            case TRES_ANIOS:
                return esDiscapacitado ? COSTO_DISCAPACITADOS_TRES_ANIOS : COSTO_NORMAL_TRES_ANIOS;
            default:
                throw new IllegalArgumentException("Tipo de licencia no válido");
        }
    }

    /**
     * Método que obtiene el costo de tramitación de placas para un automóvil,
     * dependiendo de si es nuevo o usado.
     *
     * @param estado Indica si el automóvil es nuevo (true) o usado (false).
     * @return El costo de tramitación de placas para el automóvil.
     */
    public static float obtenerCostoPlaca(Boolean estado) {
        if (estado) {
            return COSTO_PLACAS_AUTO_NUEVO;
        }

        return COSTO_PLACAS_AUTO_USADO;
    }

}
