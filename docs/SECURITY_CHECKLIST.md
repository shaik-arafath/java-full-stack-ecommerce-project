# Security Checklist

This checklist summarizes core security hardening steps for the UMAT repository.

## Repository hygiene

- [x] Remove secrets from source files
- [x] Replace hardcoded hostnames and IPs with placeholders
- [x] Track `.env.example` only, not `.env`
- [x] Verify `.gitignore` excludes environment files and private keys
- [x] Remove unused or orphaned configuration files

## Backend security

- [x] Use `APP_JWT_SECRET` from environment
- [ ] Rotate JWT secret periodically
- [x] Hash passwords with BCrypt
- [x] Validate request data before processing
- [x] Restrict order retrieval to owning users
- [ ] Implement payment signature verification before production use

## Deployment security

- [x] Use SSH key authentication for deployment
- [x] Store deployment variables in GitHub Secrets
- [x] Avoid embedded paths and local machine references in docs
- [ ] Review remote host security and firewall rules when deploying

## Documentation security

- [x] Document expected environment variables
- [x] Document where secrets are stored and how to update them
- [x] Keep old deployment notes archived, not part of main root documentation
