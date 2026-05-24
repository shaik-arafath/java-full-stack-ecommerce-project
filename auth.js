// Centralized Authentication Module
class AuthManager {
    constructor() {
        this.currentUser = null;
        this.API_BASE_URL = window.APP_CONFIG?.apiBaseUrl || '/api';
    }

    // Check if user is authenticated
    isAuthenticated() {
        const token = localStorage.getItem('token');
        const username = localStorage.getItem('username');
        if (!token || !username) return false;
        // check token expiry if possible (JWT exp in seconds)
        try {
            const parts = token.split('.');
            if (parts.length < 2) return false;
            const payload = JSON.parse(atob(parts[1]));
            if (payload && payload.exp) {
                const now = Math.floor(Date.now() / 1000);
                if (payload.exp < now) {
                    this.logout();
                    return false;
                }
            }
        } catch (e) {
            console.warn('Invalid token format, logging out');
            this.logout();
            return false;
        }
        return true;
    }

    // Get current user info
    getCurrentUser() {
        if (this.isAuthenticated()) {
            return {
                username: localStorage.getItem('username'),
                token: localStorage.getItem('token')
            };
        }
        return null;
    }

    // Update authentication UI elements
    updateAuthUI() {
        const authLinks = document.querySelectorAll('#authLink, #loginLink, #mobileAuthLink');

        if (this.isAuthenticated()) {
            const username = localStorage.getItem('username');
            authLinks.forEach(link => {
                if (link) {
                    link.textContent = `Welcome, ${username}`;
                    link.href = '#';
                    link.onclick = (e) => {
                        e.preventDefault();
                        this.logout();
                    };
                }
            });
        } else {
            authLinks.forEach(link => {
                if (link) {
                    link.textContent = 'Login';
                    link.href = 'login.html';
                    link.onclick = null;
                }
            });
        }
    }

    // Logout user
    logout() {
        localStorage.removeItem('token');
        localStorage.removeItem('username');
        this.currentUser = null;
        this.updateAuthUI();
        window.location.href = 'index.html';
    }

    // Initialize authentication on page load
    init() {
        this.currentUser = this.getCurrentUser();
        this.updateAuthUI();
    }

    // Check backend availability
    async isBackendAvailable() {
        try {
            const response = await fetch(window.APP_CONFIG?.healthUrl || '/actuator/health', {
                method: 'GET'
            });
            return response.ok;
        } catch (error) {
            console.warn('Backend server not available:', error);
            return false;
        }
    }
}

// Global auth instance
const authManager = new AuthManager();

// Initialize on page load
document.addEventListener('DOMContentLoaded', () => {
    authManager.init();
});
