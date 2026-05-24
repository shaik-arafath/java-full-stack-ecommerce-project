# UMAT Clothing Store

![CI](https://img.shields.io/github/actions/workflow/status/OWNER/REPO/ci.yml?branch=main)
![Maven](https://img.shields.io/badge/build-maven-brightgreen)
![Java](https://img.shields.io/badge/java-17-red)

A Java full-stack portfolio project that combines a static frontend with a Spring Boot backend, Docker deployment, and automated CI/CD.

## Project Overview

UMAT is an e-commerce demonstration application with:
- Product browsing and detail pages
- User signup/login with JWT authentication
- Cart management and order creation
- Razorpay payment order integration patterns
- Docker-based deployment and GitHub Actions automation

## Technology Stack

- **Frontend**: Static HTML, CSS, JavaScript
- **Backend**: Spring Boot (Java 17), Spring MVC, Spring Security, Spring Data JPA
- **Database**: H2 in-memory for local development, MySQL-compatible JDBC in production
- **Deployment**: Docker, Docker Compose, GitHub Actions
- **Payment**: Razorpay SDK integration

## Architecture

- `index.html`, `*.html`, `style.css`, `auth.js`, `config.js` — Static frontend served by backend
- `spring_backend/` — Spring Boot application code, REST controllers, JPA entities, security
- `Dockerfile` / `docker-compose.yml` — Deployment definitions for containerized execution
- `.github/workflows/deploy.yml` — GitHub Actions workflow for remote deployment
- `docs/` — Project documentation and architecture references

## Screenshots

### Homepage & Product Browse
![Homepage Screenshot](img/Screenshot%20%282%29.png)

### Product Details & Catalog
![Product Screenshot](img/Screenshot%20%283%29.png)

### Checkout & Payment Flow
![Checkout Screenshot](img/Screenshot%20%284%29.png)

## Getting Started

### Local development

1. Build the backend:
   ```bash
   cd spring_backend
   mvn clean package
   java -jar target/*.jar
   ```
2. Open the frontend pages in your browser at `http://localhost:8080/index.html` or any static HTML page in the root.

### Environment variables

Configuration is driven from environment variables. See `docs/DEPLOYMENT_GUIDE.md` and `.env.example` for details.

## Documentation

- [`docs/PROJECT_OVERVIEW.md`](docs/PROJECT_OVERVIEW.md)
- [`docs/Architecture.md`](docs/Architecture.md)
- [`docs/API_REFERENCE.md`](docs/API_REFERENCE.md)
- [`docs/DEPLOYMENT_GUIDE.md`](docs/DEPLOYMENT_GUIDE.md)
- [`docs/SECURITY.md`](docs/SECURITY.md)
- [`docs/CONTRIBUTING.md`](docs/CONTRIBUTING.md)

## CI/CD

The repository includes a GitHub Actions workflow that deploys to a remote server via SSH when changes are pushed to `main`. Sensitive deployment secrets are expected to be stored in GitHub Actions Secrets.

## Professional summary

UMAT is intended to demonstrate a full-stack architecture with real-world deployment practices, strong documentation, and a clean separation between frontend assets and backend services.
