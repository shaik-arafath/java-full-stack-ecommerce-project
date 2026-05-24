# Project Overview

UMAT is a Java full-stack e-commerce portfolio application designed to demonstrate a production-ready architecture for an online retail storefront.

## Purpose

This project showcases:
- Full-stack integration between a static frontend and a Spring Boot backend
- Secure authentication with JWT
- Product catalog, shopping cart, and order management
- Payment gateway integration patterns with Razorpay
- Docker-based deployment and automated deployment pipelines
- Clear documentation and portfolio-ready project structure

## Key capabilities

- User signup and login with password hashing
- JWT-based authorization for protected endpoints
- Product browsing and detail retrieval
- Cart management and persisted cart state in backend
- Order creation and basic order retrieval
- Payment order creation via Razorpay SDK
- Health-check endpoint for service monitoring

## What this repo contains

- `index.html`, `*.html`, `style.css`, `config.js`, `auth.js` — Static frontend assets served by Spring Boot
- `img/` — Static product and marketing assets
- `spring_backend/` — Spring Boot backend source code, JPA entities, repositories, controllers, security, and build configuration
- `.github/workflows/deploy.yml` — Deployment workflow for GitHub Actions
- `Dockerfile` and `docker-compose.yml` — Container definitions for Docker deployment
- `docs/` — Project documentation and architecture references
- `spring_backend/src/main/resources/application.properties` — Environment-driven backend configuration
