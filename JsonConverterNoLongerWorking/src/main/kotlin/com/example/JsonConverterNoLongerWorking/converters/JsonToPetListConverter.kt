package com.example.JsonConverterNoLongerWorking.converters

import com.example.JsonConverterNoLongerWorking.database.Pet
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.r2dbc.postgresql.codec.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import java.io.IOException

/**
 * Converter to convert [Json] from the database to a [List] of [Pet]
 */
@ReadingConverter
class JsonToPetListConverter : Converter<Json, List<Pet>> {

    override fun convert(source: Json): List<Pet>? {
        val objectMapper = jacksonObjectMapper()

        try {
            return objectMapper.readValue(source.asString(), DatabaseListOfPet::class.java).data
        } catch (error: IOException) {
            println(error)
        }

        return null
    }
}

data class DatabaseListOfPet(val data: List<Pet>?)