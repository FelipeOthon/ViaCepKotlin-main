package org.example.Api
import org.example.Moldes.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("ws/{cep}/json/")
    fun buscarEndereco(@Path("cep") cep: String): Call<Endereco>
}