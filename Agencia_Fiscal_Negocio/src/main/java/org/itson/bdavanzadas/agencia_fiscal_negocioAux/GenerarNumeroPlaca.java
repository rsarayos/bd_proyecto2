package org.itson.bdavanzadas.agencia_fiscal_negocioAux;

import java.util.Random;

/**
 * La clase GenerarNumeroPlaca proporciona un método para generar un número de placa aleatorio.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class GenerarNumeroPlaca {

    /**
     * Constructor por defecto de la clase GenerarNumeroPlaca.
     */
    public GenerarNumeroPlaca() {
    }
    
    /**
     * Genera un número de placa aleatorio compuesto por tres letras y tres dígitos separados por un guion.
     *
     * @return Un número de placa aleatorio.
     */
    public String generarNumeroDePlaca() {
        StringBuilder placa = new StringBuilder();

        // Generar las tres letras aleatorias
        for (int i = 0; i < 3; i++) {
            char letra = (char) (new Random().nextInt(26) + 'A');
            placa.append(letra);
        }

        // Agregar el "-" en la posición 3
        placa.append("-");

        // Generar los tres dígitos aleatorios
        for (int i = 0; i < 3; i++) {
            int digito = new Random().nextInt(10);
            placa.append(digito);
        }

        return placa.toString();
    }

}
