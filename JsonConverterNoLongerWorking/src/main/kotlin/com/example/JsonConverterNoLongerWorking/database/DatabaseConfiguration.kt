package com.example.JsonConverterNoLongerWorking.database

import com.example.JsonConverterNoLongerWorking.converters.JsonToPetListConverter
import com.example.JsonConverterNoLongerWorking.converters.PetListToJsonConverter
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatabaseConfiguration(
    @Value("\${spring.data.postgres.host}") private val host: String,
    @Value("\${spring.data.postgres.port}") private val port: Int,
    @Value("\${spring.data.postgres.database}") private val database: String,
    @Value("\${spring.data.postgres.username}") private val username: String
    ) : AbstractR2dbcConfiguration() {

    override fun getCustomConverters(): MutableList<Any> {
        return mutableListOf(
            JsonToPetListConverter(),
            PetListToJsonConverter()
        )
    }

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(
            ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "postgresql")
                .option(ConnectionFactoryOptions.PROTOCOL, "postgresql")
                .option(ConnectionFactoryOptions.HOST, host)
                .option(ConnectionFactoryOptions.PORT, port)
                .option(ConnectionFactoryOptions.DATABASE, database)
                .option(ConnectionFactoryOptions.USER, username)
                .build()
        )
    }
}