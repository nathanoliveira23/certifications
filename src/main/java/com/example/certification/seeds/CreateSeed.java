package com.example.certification.seeds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {
    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
        driverManagerDataSource.setUsername("admin");
        driverManagerDataSource.setPassword("admin");

        CreateSeed createSeed = new CreateSeed(driverManagerDataSource);
        createSeed.run(args);
    }

    public void run(String... args) {
        executeSQLFile("src/main/resources/create.sql");
    }

    public void executeSQLFile(String path) {
        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get(path)));

            jdbcTemplate.execute(sqlScript);

            System.out.println("Seed realizado com sucesso!");
        }
        catch(IOException err) {
            System.out.println("Erro ao executar o arquivo: " + err.getMessage());
        }
    }
}
