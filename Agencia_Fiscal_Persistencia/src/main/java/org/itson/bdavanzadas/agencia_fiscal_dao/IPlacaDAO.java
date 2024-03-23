package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Placa;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

/**
 *
 * @author alex_
 */
public interface IPlacaDAO {
    
    public Placa agregarPlaca(Placa placa) throws PersistenciaException;
    
    public List<Placa> obtenerPlacas(Vehiculo vehiculo) throws PersistenciaException;
    
    public Placa obtenerPlacaActiva(Vehiculo vehiculo) throws PersistenciaException;
    
    public Placa modificarVigencia(Placa placa) throws PersistenciaException;
    
}
