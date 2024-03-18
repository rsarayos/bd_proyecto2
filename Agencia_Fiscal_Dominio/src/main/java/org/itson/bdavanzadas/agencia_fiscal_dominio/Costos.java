/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dominio;

/**
 *
 * @author alex_
 */
public class Costos {
    
    public static final float COSTO_NORMAL_UN_ANIO = 600f;
    public static final float COSTO_NORMAL_DOS_ANIOS = 900f;
    public static final float COSTO_NORMAL_TRES_ANIOS = 1100f;

    public static final float COSTO_DISCAPACITADOS_UN_ANIO = 200f;
    public static final float COSTO_DISCAPACITADOS_DOS_ANIOS = 500f;
    public static final float COSTO_DISCAPACITADOS_TRES_ANIOS = 700f;
    
    public static final float COSTO_PLACAS_AUTO_NUEVO = 1500f;
    public static final float COSTO_PLACAS_AUTO_USADO = 1000f;
    
    public static float obtenerCostoLicencia(TipoLicencia tipoLicencia, boolean esDiscapacitado) {
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
    
    public static float obtenerCostoPlaca(boolean estado) {
        if(estado)
            return COSTO_PLACAS_AUTO_NUEVO;
        
        return COSTO_PLACAS_AUTO_USADO;
    }
    
}
