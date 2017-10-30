"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var DataHolder = (function () {
    function DataHolder(router) {
        this.router = router;
        this.afterLogin = false;
    }
    Object.defineProperty(DataHolder.prototype, "user", {
        get: function () {
            return this._user;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(DataHolder.prototype, "room", {
        get: function () {
            return this._room;
        },
        enumerable: true,
        configurable: true
    });
    DataHolder.prototype.logout = function (fromServer) {
        var _this = this;
        var result;
        fromServer.subscribe(function (next) {
            result = next.json();
            if (result) {
                _this.afterLogin = false;
                _this._user = null;
            }
        });
        this.afterLogin = false;
    };
    DataHolder.prototype.fetchDataFromServer = function (fromServer) {
        var _this = this;
        var result;
        fromServer.subscribe(function (next) {
            result = next.json();
            _this._user = result;
            _this.checkUserChangesAndCloseLoginForm();
        });
    };
    DataHolder.prototype.checkUserChangesAndCloseLoginForm = function () {
        if (this.afterLogin == false) {
            if (this._user) {
                console.log("user.id=" + this._user.id + ", user.name=" + this._user.name);
                this.afterLogin = true;
                this.router.navigate(['/roomlist']);
            }
        }
    };
    DataHolder.prototype.signUpToARoom = function (fromServer) {
        var _this = this;
        fromServer.subscribe(function (next) {
            _this._room = next.json();
            _this.router.navigate(['/room/' + _this._room.id]);
        });
    };
    DataHolder.prototype.exitRoomAndDisbandIfAuthor = function () {
        this.router.navigate(['/roomlist']);
    };
    return DataHolder;
}());
DataHolder = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [router_1.Router])
], DataHolder);
exports.DataHolder = DataHolder;
//# sourceMappingURL=data.service.js.map