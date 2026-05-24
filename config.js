(function attachAppConfig(globalScope) {
    const isLocalFile = globalScope.location && globalScope.location.protocol === 'file:';
    const origin = globalScope.location && globalScope.location.origin ? globalScope.location.origin : '';
    const defaultApiBase = isLocalFile ? 'http://localhost:8080/api' : '/api';
    const runtimeOverrides = globalScope.__APP_CONFIG__ || {};

    globalScope.APP_CONFIG = Object.freeze({
        apiBaseUrl: runtimeOverrides.apiBaseUrl || defaultApiBase,
        healthUrl: runtimeOverrides.healthUrl || (isLocalFile ? 'http://localhost:8080/actuator/health' : '/actuator/health'),
        razorpayKey: runtimeOverrides.razorpayKey || ''
    });
})(window);
