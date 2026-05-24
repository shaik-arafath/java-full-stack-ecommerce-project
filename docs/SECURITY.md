# Security

This section documents security best practices for the UMAT full-stack application.

## Secrets and environment configuration

All sensitive values must be stored outside source control.

Examples:

- JWT secret: `APP_JWT_SECRET`
- Database credentials: `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`
- Razorpay keys: `RAZORPAY_KEY`, `RAZORPAY_SECRET`
- VPS deployment fields: `VPS_HOST`, `VPS_USER`, `VPS_PATH`

## Secure storage

- Use `.env` for local development and add it to `.gitignore`
- Use encrypted secrets in GitHub Actions and cloud deployment platforms
- Never commit private keys, passwords, or actual infrastructure hostnames to the repository

## Authentication and authorization

- Passwords are hashed using BCrypt before persistence
- JWT tokens are issued using `JwtUtil`
- Protected endpoints require the `Authorization: Bearer <token>` header
- `JwtFilter` validates tokens and attaches the authenticated user's email to requests

## Known limitations

- `POST /api/payment/verify` is intentionally a placeholder and does not currently verify Razorpay signatures
- The application currently uses an in-memory H2 database by default for local development
- Payment keys are required for full Razorpay integration

## Recommended improvements

- Add refresh token support for longer-lived sessions
- Enable HTTPS in production and enforce secure cookies if session cookies are used
- Harden CORS rules to exact production domains instead of wildcard patterns
- Implement order ownership validation for all order retrieval endpoints
- Use a managed secrets store or environment configuration manager in production
