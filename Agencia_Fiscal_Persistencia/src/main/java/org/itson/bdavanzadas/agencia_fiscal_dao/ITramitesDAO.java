package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_auxiliar.FiltroReportes;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;
import org.itson.bdavanzadas.agencia_fiscal_excepciones.PersistenciaException;

public interface ITramitesDAO {

    /**
     * Permite consultar todos los trámites realizados por una persona,
     *
     * @param persona La persona de la cual se desean consultar los trámites
     * @return Una lista con los trámites que ha realizado la persona
     * @throws PersistenciaException Si no se pueden consultar los trámites
     */
    public List<Tramite> consultarTramitesPersona(Persona persona) throws PersistenciaException;
    
    public List<Tramite> consultarTramites(FiltroReportes filtro) throws PersistenciaException;

}
