package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Automovil;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Vehiculo;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public interface IAutomovilesDAO {
    
    public void agregarAutomovil(Automovil automovilNuevo) throws PersistenciaException;
    
    public List<Automovil> consultarAutomoviles(Persona persona) throws PersistenciaException;
    
}
