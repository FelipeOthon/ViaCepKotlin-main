package org.example.Repositories

import org.example.Api.ApiClient
import org.example.Moldes.Endereco
import retrofit2.Call

class EnderecoRepository {
    fun buscarEndereco(cep: String): Call<Endereco> {
        return ApiClient.service.buscarEndereco(cep)
    }
}