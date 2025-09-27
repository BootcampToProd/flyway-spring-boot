# 🚀 Flyway Migration Using Spring Boot: Complete Multi-Environment Database Management

Master **seamless database migrations** with **Flyway** and **Spring Boot** native integration. This repository demonstrates how to build a complete multi-environment migration system that manages database schema changes across development, staging, and production environments using Spring Boot's built-in Flyway auto-configuration.

📖 **Complete Guide**: For detailed explanations, Spring Boot configuration mastery, and production-ready migration strategies, read our comprehensive tutorial.<br>
👉 [**Flyway Migration Using Spring Boot: Complete Tutorial Guide**](https://bootcamptoprod.com/flyway-with-spring-boot/)

---

## ✨ What This Project Demonstrates

This application showcases a **complete Spring Boot Flyway integration system** with:

- **Spring Boot native Flyway integration** with automatic migration execution on startup
- **Multi-environment profiles** with separate dev, staging, and production configurations
- **Environment-specific migrations** using Spring profiles and classpath locations
- **Spring Boot REST API** demonstrating the migrated database with real data
- **Actuator endpoints** for migration monitoring and health checks
- **Production-ready configurations** with security and monitoring best practices

---

## 🚦 Environment Variables

Configure your database connections using these environment variables:

- `DB_HOST`: Database server hostname (default: localhost)
- `DB_PORT`: Database server port (default: 5432)
- `DB_NAME`: Database name (default: flyway_demo_dev)
- `DB_USER`: Database username (default: postgres)
- `DB_PASSWORD`: Database password (required for staging/production)

---

## 🛠️ Running with Different Environments

### Development Environment
```bash
# Run with development profile (default)
./mvnw spring-boot:run

# Or explicitly specify dev profile
./mvnw spring-boot:run -Dspring.profiles.active=dev

# Check migration status via Actuator
curl http://localhost:8080/actuator/flyway
```

### Staging Environment
```bash
# Run with staging profile
./mvnw spring-boot:run -Dspring.profiles.active=stage

# Verify staging-specific data
curl http://localhost:8080/api/users
```

### Production Environment
```bash
# Run with production profile
./mvnw spring-boot:run -Dspring.profiles.active=prod

# Check health including Flyway status
curl http://localhost:8080/actuator/health
```

---

## 🗄️ Database Setup

Create the required PostgreSQL databases: flyway_demo_dev, flyway_demo_stage and flyway_demo_prod.

---

## 🏃‍♂️ Testing the Application

### Start Application
```bash
./mvnw spring-boot:run -Dspring.profiles.active=dev
```

### Test REST API Endpoints
```bash
# Get all users (shows environment-specific data)
curl http://localhost:8080/api/users

# Get user by ID
curl http://localhost:8080/api/users/1

# Health check
curl http://localhost:8080/api/users/health
```

### Monitor Flyway Status
```bash
# Check Flyway migration details
curl http://localhost:8080/actuator/flyway | jq '.'

# Check overall application health
curl http://localhost:8080/actuator/health | jq '.components.flyway'
```

---

## 🚀 Getting Started

1. **Clone the repository**
2. **Setup PostgreSQL databases** (dev, stage, prod)
3. **Configure environment variables** for database connections
4. **Run the application** with desired profile
5. **Test the REST API** to verify migration success
6. **Monitor via Actuator endpoints** for ongoing health checks

---

## 📚 Learn More

For comprehensive tutorials on database migration strategies:
- [Flyway with Spring Boot Maven: Multi-Environment Database Migration Management](https://bootcamptoprod.com/flyway-spring-boot-maven-guide)

---

**Built with ❤️ by [BootcampToProd](https://bootcamptoprod.com/blog)**