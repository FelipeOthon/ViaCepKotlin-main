package org.example

import org.example.ui.BuscarCepView
import javax.swing.SwingUtilities

fun main() {
    // Inicia a interface gráfica Swing para busca de CEP
    SwingUtilities.invokeLater {
        BuscarCepView().isVisible = true
    }
}
