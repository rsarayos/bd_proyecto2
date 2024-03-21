package org.itson.bdavanzadas.agencia_fiscal_bos;

import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public interface IRegistroLicenciaBO {
    
    public Licencia registrarLicencia(LicenciaNuevaDTO licenciaNueva) throws NegociosException; 
    
}
