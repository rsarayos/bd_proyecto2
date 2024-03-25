package org.itson.bdavanzadas.agencia_fiscal_presentacion.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author victo
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
     * Valida si el número de serie proporcionado cumple con el formato
     * permitido.
     *
     * @param NoSerie Número de serie a validar.
     * @return true si el número es válido, false de lo contrario.
     */
    public boolean validaMarca(String NoSerie) {

        Pattern patron = Pattern.compile("^[A-Z0-9]{17}$");
        Matcher matcher = patron.matcher(NoSerie);

        return matcher.matches();

    }
}
