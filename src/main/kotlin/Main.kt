package org.example

import org.example.ui.BuscarCepView
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        BuscarCepView().isVisible = true
    }
}
