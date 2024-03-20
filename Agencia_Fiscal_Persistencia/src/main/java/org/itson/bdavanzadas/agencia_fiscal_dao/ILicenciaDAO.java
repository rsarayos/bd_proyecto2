/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.agencia_fiscal_dao;

import org.itson.bdavanzadas.agencia_fiscal_dtos.LicenciaNuevaDTO;
import org.itson.bdavanzadas.agencia_fiscal_entidades_jpa.Licencia;

/**
 *
 * @author alex_
 */
public interface ILicenciaDAO {
    
    public Licencia agregarLicencia(LicenciaNuevaDTO licenciaNueva);
}
