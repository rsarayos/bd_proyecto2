package org.itson.bdavanzadas.agencia_fiscal_bos;

import java.util.List;
import org.itson.bdavanzadas.agencia_fiscal_dtos.FiltroReportesDTO;
import org.itson.bdavanzadas.agencia_fiscal_dtos.TramiteReporteDTO;
import org.itson.bdavanzadas.agencia_fiscal_excepciones_negocio.NegociosException;

/**
 * La interfaz IGeneradorReportesBO define los métodos necesarios para generar reportes de trámites.
 * Los trámites se pueden filtrar y posteriormente generar un archivo PDF con la información solicitada.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public interface IGeneradorReportesBO {

    /**
     * Permite obtener los trámites deseados para realizar el reporte.
     *
     * @param filtro El filtro que se aplicará a la consulta de trámites
     * @return La lista de los trámites consultados
     * @throws NegociosException Si no se pueden consultar los trámites
     */
    public List<TramiteReporteDTO> obtenerTramites(FiltroReportesDTO filtro) throws NegociosException;

    /**
     * Permite generar el archivo PDF del reporte.
     *
     * @param listaTramites La lista de trámites que contendrá el archivo PDF
     * @throws NegociosException Si no se puede generar el archivo
     */
    public void generarReporte(List<TramiteReporteDTO> listaTramites) throws NegociosException;

}
