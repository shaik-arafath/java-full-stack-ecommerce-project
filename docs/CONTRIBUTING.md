# Contributing

Thank you for reviewing the UMAT e-commerce project.

## How to contribute

1. Fork the repository.
2. Create a feature branch:
   ```bash
git checkout -b feature/<describe-change>
```
3. Make your updates.
4. Commit with a descriptive message:
   ```bash
git commit -m "Add <feature> to <module>"
```
5. Push your branch and open a pull request.

## Code style

- Keep Java code simple and readable
- Use meaningful names for variables, methods, and classes
- Prefer small methods and single-responsibility controllers
- Do not commit generated build artifacts or environment files

## Documentation

- Document API changes in `docs/API_REFERENCE.md`
- Update `docs/Architecture.md` if architecture changes
- Keep the root `README.md` aligned with the current repository state

## Pull request checklist

- [ ] Code builds successfully
- [ ] No hardcoded secrets or placeholders are committed
- [ ] Documentation is updated for new features
- [ ] Deployment configuration remains valid
- [ ] Any new external dependency is justified

## Release Process

- Follow Semantic Versioning: `MAJOR.MINOR.PATCH`.
- Update `CHANGELOG.md` under the `[Unreleased]` section with notable changes.
- Commit with a release message: `chore(release): vX.Y.Z`.
- Tag the release and push tags to origin:

```bash
git tag -a vX.Y.Z -m "Release vX.Y.Z"
git push origin vX.Y.Z
```

## Commit Message Guidelines

- Use the Conventional Commits style for clear history and automated release tooling:
   - `feat(scope): description` — New feature
   - `fix(scope): description` — Bug fix
   - `chore(release): vX.Y.Z` — Release
   - `docs:`, `test:`, `refactor:`, `perf:` as appropriate

Example:

```
feat(payment): verify razorpay signatures on /api/payment/verify
```

## Creating a Release on GitHub

1. Push the tag to GitHub.
2. Open the repository on GitHub and go to _Releases > Draft a new release_.
3. Select the tag you pushed, add release notes (copy from `CHANGELOG.md`), and publish.

## Changelog Maintenance

- Keep `CHANGELOG.md` up to date for every release.
- Small tweaks and non-user-facing changes can be grouped under patch releases.
