package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;

public interface ITramitesDAO {
    
    public List<Tramite> consultarTramites(Persona persona);
    
}
