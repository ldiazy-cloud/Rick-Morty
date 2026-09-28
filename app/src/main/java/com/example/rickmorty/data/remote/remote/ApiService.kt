package com.example.rickmorty.data.remote



import com.example.rickmorty.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1
    ): CharacterResponse
}