"use strict";
var Room = (function () {
    function Room() {
    }
    Object.defineProperty(Room.prototype, "id", {
        get: function () {
            return this._id;
        },
        set: function (value) {
            this._id = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Room.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            this._name = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Room.prototype, "created", {
        get: function () {
            return this._created;
        },
        set: function (value) {
            this._created = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Room.prototype, "authorId", {
        get: function () {
            return this._authorId;
        },
        set: function (value) {
            this._authorId = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Room.prototype, "users", {
        get: function () {
            return this._users;
        },
        set: function (value) {
            this._users = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Room.prototype, "opened", {
        get: function () {
            return this._opened;
        },
        set: function (value) {
            this._opened = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Room.prototype, "author", {
        get: function () {
            return this._author;
        },
        set: function (value) {
            this._author = value;
        },
        enumerable: true,
        configurable: true
    });
    return Room;
}());
exports.Room = Room;
//# sourceMappingURL=room.model.js.map