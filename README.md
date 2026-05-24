# RAW FADE - E-Commerce Platform

![CI](https://img.shields.io/github/actions/workflow/status/OWNER/REPO/ci.yml?branch=main)
![Maven](https://img.shields.io/badge/build-maven-brightgreen)
![Java](https://img.shields.io/badge/java-17-red)

A Java full-stack portfolio project that combines a static frontend with a Spring Boot backend, Docker deployment, and automated CI/CD for a premium men's fashion e-commerce platform.

## Project Overview

RAW FADE is an e-commerce demonstration application with:
- Product browsing and detail pages
- User signup/login with JWT authentication
- Cart management and order creation
- Razorpay payment order integration patterns
- Docker-based deployment and GitHub Actions automation
- Modern responsive UI with dark theme

## 🖼️ Project Screenshots

### 1. Home Page - Hero Section
Landing page featuring the RAW FADE brand with prominent call-to-action buttons and professional imagery showcasing premium men's fashion.

![Home Page - Hero Section](D:\it company rawfade repo\ummatrawfade-main\ummatrawfade-main\img\Screenshot (2).png)

**Features:**
- Bold hero headline: "ELEVATE YOUR STYLE"
- Premium men's fashion tagline
- "SHOP NOW" and "EXPLORE COLLECTION" CTA buttons
- Professional background imagery
- Navigation menu with Home, Shop, Contact, Login, and Cart

---

### 2. Featured Collection
Product showcase displaying bestsellers and exclusive items with pricing, discounts, and add-to-cart functionality.

![Featured Collection](D:\it company rawfade repo\ummatrawfade-main\ummatrawfade-main\img\Screenshot (3).png)

**Features:**
- Grid layout with 4 product cards
- Product images with "BESTSELLER" badges
- Price display with discount formatting (Original → Discounted)
- Add to cart functionality
- Newsletter signup section
- Featured products: Bestseller items, Alazer, Cargo Shorts

---

### 3. Login Page
User authentication interface with Login/Register options and error handling for secure account access.

![Login Page](D:\it company rawfade repo\ummatrawfade-main\ummatrawfade-main\img\Screenshot (4).png)

**Features:**
- Welcome heading: "Welcome to RAW FADE"
- Login/Register tab switching
- Username/Email input field
- Password input field with masking
- "Sign In" button
- Error message display area
- Account creation option

---

## Technology Stack

- **Frontend**: Static HTML (78.9%), CSS (4%), JavaScript (3.2%)
- **Backend**: Spring Boot (Java 6.7%), Spring MVC, Spring Security, Spring Data JPA
- **Database**: H2 in-memory for local development, MySQL-compatible JDBC in production
- **Deployment**: Docker (0.1%), Docker Compose, GitHub Actions
- **DevOps**: Shell Scripts (1.9%), Batchfile (5.2%)
- **Payment**: Razorpay SDK integration

## Architecture

- `index.html`, `*.html`, `style.css`, `auth.js`, `config.js` — Static frontend served by backend
- `spring_backend/` — Spring Boot application code, REST controllers, JPA entities, security
- `Dockerfile` / `docker-compose.yml` — Deployment definitions for containerized execution
- `.github/workflows/deploy.yml` — GitHub Actions workflow for remote deployment
- `docs/` — Project documentation and architecture references
- `img/` — Project screenshots and assets

## Key Features

✅ **Responsive E-Commerce Design** - Mobile-friendly interface with dark theme  
✅ **Product Management** - Browse, filter, and search products  
✅ **User Authentication** - Secure login/register with JWT tokens  
✅ **Shopping Cart** - Add/remove items and manage orders  
✅ **Payment Integration** - Razorpay payment gateway integration  
✅ **Admin Dashboard** - Manage inventory and orders  
✅ **Docker Deployment** - Containerized application for easy deployment  
✅ **Newsletter Integration** - Email subscription for customers  

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

## Live Demo

Experience the RAW FADE platform live:

**🚀 Live Application**: [https://cute-granita-cd33ed.netlify.app](https://cute-granita-cd33ed.netlify.app)

### Deployment

The application is deployed using Docker on Netlify for easy access and continuous deployment.

### Docker Build
```bash
docker build -t raw-fade:latest .
docker run -p 8080:8080 raw-fade:latest
```

### Docker Compose
```bash
docker-compose up -d
```

## CI/CD

The repository includes a GitHub Actions workflow that deploys to a remote server via SSH when changes are pushed to `main`. Sensitive deployment secrets are expected to be stored in GitHub Actions secrets.

## Professional Summary

RAW FADE demonstrates a complete full-stack architecture with real-world deployment practices, strong documentation, a clean separation between frontend assets and backend services, and production-ready e-commerce functionality. The application showcases modern UI/UX design principles with a professional dark theme and comprehensive feature set for a premium fashion e-commerce platform.

## License

This project is part of a technical portfolio and is provided as-is for educational purposes.
