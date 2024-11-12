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
                    onResult(endereco)
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                println("Erro na requisição: ${t.message}")
                onResult(null)
            }
        })
    }
}