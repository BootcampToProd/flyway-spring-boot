package com.bootcamptoprod.strategy;

import org.flywaydb.core.api.MigrationInfo;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;

// Uncomment below line if you want to use flyway custom migrate strategy on application startup
//@Configuration
public class FlywayCustomMigrateStrategy {
    @Bean
    public FlywayMigrationStrategy customMigrationStrategy() {
        return flyway -> {
            // Step 1: Clean the database
            flyway.clean();

            // Step 2: Log the pre-migration state
            System.out.println("--- FLYWAY PRE-MIGRATION INFO ---");
            printMigrationTable(flyway.info().all());

            // Step 3: Run the migrations
            flyway.migrate();

            // Step 4: Log the post-migration state
            System.out.println("\n--- FLYWAY POST-MIGRATION INFO ---");
            printMigrationTable(flyway.info().all());
        };
    }

    /**
     * Pretty-prints Flyway migrations in a table format similar to Flyway CLI.
     */
    private void printMigrationTable(MigrationInfo[] migrations) {
        // Column widths
        int wCategory = 11;
        int wVersion = 9;
        int wDescription = 24;
        int wType = 8;
        int wInstalledOn = 20;
        int wState = 10;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Border line
        String border = "+"
                + "-".repeat(wCategory + 2) + "+"
                + "-".repeat(wVersion + 2) + "+"
                + "-".repeat(wDescription + 2) + "+"
                + "-".repeat(wType + 2) + "+"
                + "-".repeat(wInstalledOn + 2) + "+"
                + "-".repeat(wState + 2) + "+";

        // Print header
        System.out.println(border);
        System.out.printf("| %-" + wCategory + "s | %-" + wVersion + "s | %-" + wDescription + "s | %-" + wType + "s | %-" + wInstalledOn + "s | %-" + wState + "s |%n",
                "Category", "Version", "Description", "Type", "Installed On", "State");
        System.out.println(border);

        // Print rows
        Arrays.stream(migrations).forEach(migrationInfo -> {
            String installedOn = migrationInfo.getInstalledOn() != null
                    ? df.format(migrationInfo.getInstalledOn())
                    : "";

            System.out.printf("| %-" + wCategory + "s | %-" + wVersion + "s | %-" + wDescription + "s | %-" + wType + "s | %-" + wInstalledOn + "s | %-" + wState + "s |%n",
                    migrationInfo.isVersioned() ? "Versioned" : "Repeatable",
                    migrationInfo.getVersion() != null ? migrationInfo.getVersion().toString() : "",
                    truncate(migrationInfo.getDescription(), wDescription),
                    migrationInfo.getType(),
                    installedOn,
                    migrationInfo.getState());
        });

        System.out.println(border);
    }

    private static String truncate(String str, int maxLen) {
        if (str == null) return "";
        return str.length() <= maxLen ? str : str.substring(0, maxLen - 3) + "...";
    }
}
