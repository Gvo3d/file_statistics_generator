"use strict";
var User = (function () {
    function User() {
    }
    Object.defineProperty(User.prototype, "getId", {
        get: function () {
            return this.id;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "setId", {
        set: function (value) {
            this.id = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "getName", {
        get: function () {
            return this.name;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "setName", {
        set: function (value) {
            this.name = value;
        },
        enumerable: true,
        configurable: true
    });
    User.prototype.toString = function () {
        return 'User: { id=' + this.id + ', name=' + this.name + ' };';
    };
    return User;
}());
exports.User = User;
//# sourceMappingURL=user.model.js.map