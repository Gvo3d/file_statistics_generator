"use strict";
var Constants = (function () {
    function Constants() {
    }
    Object.defineProperty(Constants, "HOME_URL", {
        get: function () { return "http://localhost:8080"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "LOGIN_URL", {
        get: function () { return "/doLogin"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "LOGOUT_URL", {
        get: function () { return "/doLogout"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "ROOM_LIST_URL", {
        get: function () { return "/roomList"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "ROOM_CREATE_URL", {
        get: function () { return "/createRoom"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "ROOM_DISBAND_URL", {
        get: function () { return "/disband/"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "USER_ROOM_EXIT_URL", {
        get: function () { return "/exit/"; },
        enumerable: true,
        configurable: true
    });
    ;
    Object.defineProperty(Constants, "WS_ROOMLIST_URL", {
        get: function () { return "/app/ws-roomlist"; },
        enumerable: true,
        configurable: true
    });
    ;
    return Constants;
}());
Constants.stompConfig = {
    // Which server?
    url: 'ws://127.0.0.1:15674/ws',
    // Headers
    // Typical keys: login, passcode, host
    headers: {
        login: 'guest',
        passcode: 'guest'
    },
    // How often to heartbeat?
    // Interval in milliseconds, set to 0 to disable
    heartbeat_in: 0,
    heartbeat_out: 20000,
    // Wait in milliseconds before attempting auto reconnect
    // Set to 0 to disable
    // Typical value 5000 (5 seconds)
    reconnect_delay: 5000,
    // Will log diagnostics on console
    debug: true
};
exports.Constants = Constants;
//# sourceMappingURL=constants.js.map