package org.itson.bdavanzadas.agencia_fiscal_presentacion;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * Clase personalizada para agregar botones a una columna de una tabla en un JTable.
 * Esta clase implementa tanto TableCellRenderer como TableCellEditor para personalizar la representación
 * y la edición de una celda que contiene un botón.
 * 
 * @author Víctor Humberto Encinas Guzmán
 * @author Alejandro Sauceda Rayos
 * @author Ricardo Alán Gutiérrez Garcés
 */
public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private final JButton renderButton;
    private final JButton editButton;
    private Object currentValue;

    /**
     * Constructor de la clase ButtonColumn.
     *
     * @param buttonText     Texto que mostrará el botón.
     * @param actionListener ActionListener para el botón.
     */
    public ButtonColumn(String buttonText, ActionListener actionListener) {
        renderButton = new JButton(buttonText);
        renderButton.setFocusPainted(false);

        editButton = new JButton(buttonText);
        editButton.setFocusPainted(false);
        editButton.addActionListener(actionListener);
    }

    /**
     * Retorna el componente para renderizar una celda de la tabla.
     *
     * @param table       JTable que contiene la celda.
     * @param value       Valor actual de la celda.
     * @param isSelected  Indica si la celda está seleccionada.
     * @param hasFocus    Indica si la celda tiene el foco.
     * @param row         Índice de la fila de la celda.
     * @param column      Índice de la columna de la celda.
     * @return Componente JButton para renderizar la celda.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(table.getBackground());
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(table.getBackground());
        }

        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    /**
     * Retorna el componente para editar una celda de la tabla.
     *
     * @param table       JTable que contiene la celda.
     * @param value       Valor actual de la celda.
     * @param isSelected  Indica si la celda está seleccionada.
     * @param row         Índice de la fila de la celda.
     * @param column      Índice de la columna de la celda.
     * @return Componente JButton para editar la celda.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentValue = value;
        editButton.setText((value == null) ? "" : value.toString());
        return editButton;
    }

    /**
     * Retorna el valor actual de la celda editada.
     *
     * @return Valor actual de la celda editada.
     */
    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    /**
     * Establece el texto del botón.
     *
     * @param text Texto para establecer en el botón.
     */
    public void setButtonText(String text) {
        renderButton.setText(text);
        editButton.setText(text);
    }

}
