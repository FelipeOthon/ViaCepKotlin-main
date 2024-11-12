package org.example.ui

import org.example.Moldes.Endereco
import org.example.Repositories.EnderecoRepository
import javax.swing.*
import java.awt.BorderLayout

class BuscarCepView : JFrame() {
    private val repository = EnderecoRepository()

    init {
        title = "Buscar Endereço por CEP"
        setSize(400, 300)
        defaultCloseOperation = EXIT_ON_CLOSE
        layout = BorderLayout()

        val cepField = JTextField(10)
        val buscarButton = JButton("Buscar")
        val resultArea = JTextArea(10, 30)
        resultArea.isEditable = false

        val panel = JPanel()
        panel.add(JLabel("Digite o CEP:"))
        panel.add(cepField)
        panel.add(buscarButton)

        add(panel, BorderLayout.NORTH)
        add(JScrollPane(resultArea), BorderLayout.CENTER)

        buscarButton.addActionListener {
            val cep = cepField.text
            if (cep.isNotBlank()) {
                obterEndereco(cep) { endereco ->
                    if (endereco != null) {
                        resultArea.text = """
                            CEP: ${endereco.cep}
                            Logradouro: ${endereco.logradouro}
                            Bairro: ${endereco.bairro}
                            Cidade: ${endereco.localidade}
                            UF: ${endereco.uf}
                        """.trimIndent()
                    } else {
                        resultArea.text = "Endereço não encontrado."
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, insira um CEP válido.")
            }
        }
    }

    private fun obterEndereco(cep: String, onResult: (Endereco?) -> Unit) {
        repository.buscarEndereco(cep).enqueue(object : retrofit2.Callback<Endereco> {
            override fun onResponse(call: retrofit2.Call<Endereco>, response: retrofit2.Response<Endereco>) {
                onResult(response.body())
            }

            override fun onFailure(call: retrofit2.Call<Endereco>, t: Throwable) {
                onResult(null)
            }
        })
    }
}

fun main() {
    SwingUtilities.invokeLater {
        BuscarCepView().isVisible = true
    }
}
