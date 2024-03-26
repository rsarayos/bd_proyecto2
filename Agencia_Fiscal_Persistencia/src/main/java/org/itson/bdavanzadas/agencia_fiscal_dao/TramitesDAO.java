package org.itson.bdavanzadas.agencia_fiscal_dao;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Persona;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Tramite;

public class TramitesDAO implements ITramitesDAO {
    
    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(TramitesDAO.class.getName());
    
    /**
     * Constructor que recibe una conexión al sistema de persistencia.
     *
     * @param conexion La conexión al sistema de persistencia
     */
    public TramitesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Tramite> consultarTramites(Persona persona) {
        EntityManager entityManager = conexion.crearConexion();
        
        String jpqlQuery = """
                  SELECT t.tipo, t.fecha_tramite, t.costo, l.estado
                  FROM Tramites t
                  LEFT JOIN licencias l 
                  ON t.id_tramite = l.id_tramite
                  LEFT JOIN placas p
                  ON t.id_tramite = p.id_tramite
                  WHERE rfc_persona = :rfc;
                  """;
        
        TypedQuery<Tramite> query = entityManager.createQuery(jpqlQuery, Tramite.class);
        query.setParameter("rfc", persona.getRfc());
        List<Tramite> tramites = query.getResultList();
        
        return tramites;
    }
    
}
