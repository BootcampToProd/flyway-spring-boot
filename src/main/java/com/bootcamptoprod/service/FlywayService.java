package com.bootcamptoprod.service;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Currently, this service is not used in the application.
// It provides methods to manage Flyway database migrations programmatically. It can be used inside any other service or controller.
@Service
public class FlywayService {

    @Autowired
    private Flyway flyway;

    public void runFlywayMigrations() {
        try {
            flyway.migrate();
            System.out.println("Migrations scripts executed successfully");
        } catch (FlywayException e) {
            System.err.println("Migration failed: " + e.getMessage());
        }
    }

    public void getFlywayInfo() {
        MigrationInfoService infoService = flyway.info();
        MigrationInfo[] migrations = infoService.all();

        for (MigrationInfo migration : migrations) {
            System.out.println("Version: " + migration.getVersion());
            System.out.println("Description: " + migration.getDescription());
            System.out.println("State: " + migration.getState());
            System.out.println("---");
        }
    }

    public void validateMigrations() {
        try {
            flyway.validate();
            System.out.println("All migrations validated successfully");
        } catch (FlywayException e) {
            System.err.println("Migration validation failed: " + e.getMessage());
        }
    }

    // Note: Use with extreme caution
    public void repairIfNeeded() {
        try {
            flyway.repair();
            System.out.println("Flyway repair completed");
        } catch (FlywayException e) {
            System.err.println("Flyway repair failed: " + e.getMessage());
        }
    }

    // Note: Use with extreme caution
    public void cleanDatabase() {
        try {
            flyway.clean();
            System.out.println("Database cleaned successfully");
        } catch (FlywayException e) {
            System.err.println("Database clean failed: " + e.getMessage());
        }
    }
}