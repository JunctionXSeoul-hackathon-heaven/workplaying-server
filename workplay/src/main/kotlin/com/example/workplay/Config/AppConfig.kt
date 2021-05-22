package com.example.workplay.Config

import com.example.workplay.database.WorkplayDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(initMethod="init")
    fun workplayDatabase(): WorkplayDatabase {
        return WorkplayDatabase()
    }
}