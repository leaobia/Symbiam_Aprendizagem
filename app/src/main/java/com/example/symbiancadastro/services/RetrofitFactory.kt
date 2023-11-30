package com.example.symbiancadastro.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class RetrofitFactory {
    private val BASE_URL = "http://10.107.144.10:3000/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory
                .create()
        )
        .build()

    fun postUsuarioService(): UsuarioService {
        return retrofitFactory.create(UsuarioService::class.java)
    }

}