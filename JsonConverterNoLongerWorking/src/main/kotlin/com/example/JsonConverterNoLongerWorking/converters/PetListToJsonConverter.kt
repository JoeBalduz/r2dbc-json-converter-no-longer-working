package com.example.JsonConverterNoLongerWorking.converters

import com.example.JsonConverterNoLongerWorking.database.Pet
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.r2dbc.postgresql.codec.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter

/**
 * Converter to write a [List] of [Pet] to [Json] so that it can be stored in the database
 */
@WritingConverter
class PetListToJsonConverter : Converter<List<Pet>, Json> {

    override fun convert(source: List<Pet>): Json? {
        val objectMapper = jacksonObjectMapper()
        try {
            return Json.of(objectMapper.writeValueAsString(source))
        } catch (error: JsonProcessingException) {
            println(error)
        }

        return Json.of("")
    }
}