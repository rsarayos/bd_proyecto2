package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroReportesDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.ReporteTramiteDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 *
 * @author alex_
 */
public interface IGeneradorReportesBO {

    public List<ReporteTramiteDTO> generarListaReporte(FiltroReportesDTO filtro) throws NegociosException;

    public void generarReporte(List<ReporteTramiteDTO> listaTramites) throws NegociosException;

}
