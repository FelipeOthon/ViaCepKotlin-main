package org.example.ui

import org.example.Moldes.Endereco
import org.example.Repositories.EnderecoRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity {
    private val repository = EnderecoRepository()

    fun obterEndereco(cep: String, onResult: (Endereco?) -> Unit) {
        repository.buscarEndereco(cep).enqueue(object : Callback<Endereco> {
            override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                if (response.isSuccessful) {
                    val endereco = response.body()
                    onResult(endereco) // Chama a função de callback com o resultado
                } else {
                    onResult(null) // Chama com null se a resposta não for bem-sucedida
                }
            }

            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                println("Erro na requisição: ${t.message}")
                onResult(null) // Chama com null em caso de falha
            }
        })
    }
}