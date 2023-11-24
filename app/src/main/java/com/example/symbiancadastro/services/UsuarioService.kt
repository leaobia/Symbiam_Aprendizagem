package com.example.symbiancadastro.services

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UsuarioService {

    @POST("/usuario/cadastrarUsuario")
    suspend fun postarUsuario(@Body body: JsonObject): Response <JsonObject>

}