# Deployment Guide

This project is designed to run as a Docker container and deploy through GitHub Actions to a remote host.

## Environment variables

The application reads configuration from environment variables. Use `.env` locally or set variables in your production environment.

Required variables:

- `SPRING_DATASOURCE_URL` — JDBC URL for the database
- `SPRING_DATASOURCE_USERNAME` — Database username
- `SPRING_DATASOURCE_PASSWORD` — Database password
- `APP_JWT_SECRET` — Secret used for JWT signing
- `APP_CORS_ALLOWED_ORIGINS` — Comma-separated list of allowed origins
- `RAZORPAY_KEY` — Razorpay API key
- `RAZORPAY_SECRET` — Razorpay API secret
- `SERVER_PORT` — Application port (default `8080`)

Optional deployment variables:

- `ACME_EMAIL` — Email used for Let's Encrypt certificate generation
- `VPS_HOST` — Remote host for SSH-based deployment
- `VPS_USER` — Remote user for deployment
- `VPS_PATH` — Remote path where code is published

## Local development

1. In the project root, configure `spring_backend/src/main/resources/application.properties` or use a `.env` file.
2. Build and run the backend:

```bash
cd spring_backend
mvn clean package
java -jar target/*.jar
```

3. Open `index.html` and other frontend pages directly in the browser, or serve them from the Spring Boot static resource path.

## Docker deployment

1. Build the Docker image:

```bash
docker build -t umat-app .
```

2. Run the container:

```bash
docker run -p 8080:8080 --env-file .env umat-app
```

3. Alternatively use Docker Compose:

```bash
docker compose up -d --build
```

## GitHub Actions deployment

The deployment workflow is defined in `.github/workflows/deploy.yml`.

It uses these repository secrets:

- `DEPLOY_SSH_PRIVATE_KEY`
- `VPS_HOST`
- `VPS_USER`
- `VPS_PATH`

The workflow checks out the repository, adds the remote host to `known_hosts`, syncs code to the remote host, and runs `docker compose up -d --build`.

## Notes

- The repo currently serves static frontend assets from Spring Boot.
- The Dockerfile creates a self-contained JAR and bundles HTML/CSS/JS assets into `spring_backend/src/main/resources/static`.
- The project supports H2 for local development and MySQL for production.
