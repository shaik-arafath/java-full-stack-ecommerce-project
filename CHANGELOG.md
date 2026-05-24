# Changelog

All notable changes to this project will be documented in this file.

The format is based on Keep a Changelog (https://keepachangelog.com/en/1.0.0/) and this project follows Semantic Versioning (https://semver.org/).

## [Unreleased]
- Prepare release notes and increment version as needed.

## [1.0.0] - 2026-05-24
### Added
- Initial professionalization: documentation, CI, tests, security hardening
- Razorpay payment signature verification
- JWT expiry checks in frontend
- Unit test for `JwtUtil`
- GitHub Actions CI workflow (`.github/workflows/ci.yml`)

### Changed
- Reorganized docs under `docs/` and archived legacy deployment notes
- Improved `README.md` to be portfolio-friendly

### Fixed
- Order ownership validation in `OrderController`
- Various validation and compilation issues


## How to release
1. Create/update release notes under the `[Unreleased]` section.
2. Bump the version in your release branch following SemVer (major.minor.patch).
3. Update the `CHANGELOG.md` by moving items from `[Unreleased]` into a new version heading (e.g., `## [1.0.1] - YYYY-MM-DD`).
4. Commit the `CHANGELOG.md` and tag the release:

```bash
git add CHANGELOG.md
git commit -m "chore(release): v1.0.1"
git tag -a v1.0.1 -m "Release v1.0.1"
git push origin main --tags
```

5. Create a GitHub Release using the tag and release notes.


## Contributing to the changelog
- Use clear phrasing: *Added*, *Changed*, *Deprecated*, *Removed*, *Fixed*, *Security*.
- Keep entries short and factual.
