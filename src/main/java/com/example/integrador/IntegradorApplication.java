package com.example.integrador;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorApplication.class, args);
	}
	@Bean
    public CommandLineRunner pruebaConexion(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                System.out.println("✅ Conexión exitosa a la base de datos: " + conn.getCatalog());
            } catch (SQLException e) {
                System.out.println("❌ Error de conexión: " + e.getMessage());
            }
        };
    }
}
