package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.ReporteTramiteDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public interface IGenerarReporteBO {
    
    public List<ReporteTramiteDTO> generarListaReporte() throws NegociosException;
    public void generarReporte(List<ReporteTramiteDTO> listaTramites) throws NegociosException;
    
    
}
