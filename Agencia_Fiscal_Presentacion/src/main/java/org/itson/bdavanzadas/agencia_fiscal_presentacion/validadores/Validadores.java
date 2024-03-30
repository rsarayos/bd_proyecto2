package org.itson.bdavanzadas.agencia_fiscal_presentacion.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase Validadores contiene métodos para validar diferentes tipos de datos,
 * como números de serie, marcas, líneas, colores, modelos, números de placa y RFCs.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class Validadores {

    /**
     * Valida si el número de serie proporcionado cumple con el formato
     * permitido.
     *
     * @param NoSerie Número de serie a validar.
     * @return true si el número es válido, false de lo contrario.
     */
    public boolean validaNoSerie(String NoSerie) {
        Pattern patron = Pattern.compile("^[A-Z0-9]{17}$");
        Matcher matcher = patron.matcher(NoSerie);

        return matcher.matches();
    }

    /**
     * Valida si la marca del vehículo proporcionada cumple con el formato
     * permitido.
     *
     * @param marca Marca a validar.
     * @return true si la marca es válida, false de lo contrario.
     */
    public boolean validaMarca(String marca) {
        Pattern patron = Pattern.compile("^[A-Za-z&\\s]{1,50}$");
        Matcher matcher = patron.matcher(marca);

        return matcher.matches();
    }
    
    /**
     * Valida si la línea del vehículo proporcionada cumple con el formato
     * permitido.
     *
     * @param linea Línea a validar.
     * @return true si la línea es válida, false de lo contrario.
     */
    public boolean validaLinea(String linea) {
        Pattern patron = Pattern.compile("^[A-Za-z0-9\\s&-]{1,50}$");
        Matcher matcher = patron.matcher(linea);

        return matcher.matches();
    }
    
    /**
     * Valida si el color del vehículo proporcionada cumple con el formato
     * permitido.
     *
     * @param color Color a validar.
     * @return true si el color es válido, false de lo contrario.
     */
    public boolean validaColor(String color) {
        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúüÁÉÍÓÚÜ\\s]{1,50}$");
        Matcher matcher = patron.matcher(color);

        return matcher.matches();
    }
    
    /**
     * Valida si el modelo del vehículo proporcionada cumple con el formato
     * permitido.
     *
     * @param modelo Modelo a validar.
     * @return true si el color es válido, false de lo contrario.
     */
    public boolean validaModelo(String modelo) {
        Pattern patron = Pattern.compile("^[0-9]{4}$");
        Matcher matcher = patron.matcher(modelo);

        return matcher.matches();
    }
    
    /**
     * Valida si el número de placa proporcionado cumple con el formato
     * permitido.
     *
     * @param NoPlaca Número de placa a validar.
     * @return true si el número es válido, false de lo contrario.
     */
    public boolean validaNoPlaca(String NoPlaca) {
        Pattern patron = Pattern.compile("[A-Z]{3}-[0-9]{3}");
        Matcher matcher = patron.matcher(NoPlaca);

        return matcher.matches();
    }
    
    /**
     * Valida si el RFC proporcionado cumple con el formato
     * permitido.
     *
     * @param rfc RFC a validar.
     * @return true si el RFC es válido, false de lo contrario.
     */
    public boolean validaRfc(String rfc) {
        Pattern patron = Pattern.compile("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
        Matcher matcher = patron.matcher(rfc);

        return matcher.matches();
    }
}
