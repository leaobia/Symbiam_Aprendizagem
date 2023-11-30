package com.example.symbiancadastro.services

import com.google.gson.JsonObject
import retrofit2.Response

class LoginRepository {

    private val apiService = RetrofitFactory().postUsuarioService()

    suspend fun loginUsuario(email: String?, senha: String?, foto_perfil: String?): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("login", email)
            addProperty("senha", senha)
            addProperty("imagem", foto_perfil)
        }

        return apiService.postarUsuario(requestBody)
    }
}