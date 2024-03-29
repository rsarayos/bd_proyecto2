package org.itson.bdavanzadas.agencia_fiscal_negocioAux;

import java.util.Random;

public class GenerarNumeroPlaca {

    public GenerarNumeroPlaca() {
    }
    
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
