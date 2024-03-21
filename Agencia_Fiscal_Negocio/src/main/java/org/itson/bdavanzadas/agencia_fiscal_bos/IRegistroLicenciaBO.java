package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.PersonaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public interface IRegistroLicenciaBO {
    
    public Licencia registrarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException;
    public List<Licencia> obtenerLicencias(PersonaNuevaDTO personaNueva) throws NegociosException;
    public Licencia obtenerLicencia(Long id) throws NegociosException;
    public Licencia modificarVigencia(Long id) throws NegociosException;
    
}
