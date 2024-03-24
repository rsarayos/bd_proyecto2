/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.agencia_fiscal_dao.Conexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IConexion;
import org.itson.bdavanzadas.agencia_fiscal_dao.IPlacaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dao.PlacaDAO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PlacaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;
import org.itson.bdavanzadas.agencia_fiscal_negocioAux.GenerarNumeroPlaca;

/**
 *
 * @author alex_
 */
public class RegistroPlacaBO implements IRegistroPlacaBO{
    
    private final IConexion conexion;
    private final IPlacaDAO placaDAO;
    static final Logger logger = Logger.getLogger(RegistroPlacaBO.class.getName());

    public RegistroPlacaBO() {
        this.conexion = new Conexion();
        this.placaDAO = new PlacaDAO(conexion);
    }

    @Override
    public PlacaNuevaDTO tramitarPlaca(PlacaNuevaDTO placaNueva) throws NegociosException {
        // se verifica si el vehiculo ya tenia una placa previamente
        Vehiculo vehiculo = new Vehiculo(placaNueva.getVehiculo().getNumeroSerie());
        Persona persona = new Persona(placaNueva.getPersona().getRfc());
        // se generar el numero de placa
        GenerarNumeroPlaca genNumPlaca = new GenerarNumeroPlaca();
        String numPlaca = genNumPlaca.generarNumeroDePlaca();
        boolean placaNoReg = false;
        try {
            // se verifica si la placa no se encuentra registrada
            while (!placaNoReg) {
                Placa placaNu = this.placaDAO.obtenerPlaca(numPlaca);
                if (placaNu == null) {
                    placaNoReg = true;
                }
            }
            // Una ves se determina el numero de placa se crea la nueva placa
            Placa placa = new Placa(numPlaca,
                    null,
                    placaNueva.getEstado(),
                    vehiculo,
                    placaNueva.getFechaTramite(),
                    placaNueva.getCosto(),
                    persona);
            List<Placa> placas;

            placas = this.placaDAO.obtenerPlacasVehiculo(vehiculo);
            // si el vehiculo no tenia una placa previa se realiza el registro sin modificar vigencias
            if (placas.isEmpty()) {
                this.placaDAO.agregarPlaca(placa);
                logger.log(Level.INFO, "Se registro la placa exitosamente");
                return placaNueva;
            } else {
                // se obtiene la ultima placa activa del vehiculo y se modifica su estado y fecha de recepcion
                Placa placaAnterior = this.placaDAO.obtenerPlacaActiva(vehiculo);
                this.placaDAO.modificarVigencia(placaAnterior);
                // posteriormente se registra la nueva placa
                this.placaDAO.agregarPlaca(placa);
                logger.log(Level.INFO, "Se registro la placa exitosamente");
                return placaNueva;
            }
        } catch (PersistenciaException pe) {
            logger.log(Level.SEVERE, "No se pudo consultar las placas del vehiculo");
            throw new NegociosException("Error al tramitar Placa");
        }

    }

}
