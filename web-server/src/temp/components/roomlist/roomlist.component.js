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
var application_service_1 = require("../../services/application.service");
var constants_1 = require("../../../webapp/src/app/constants");
var room_model_1 = require("../../models/room.model");
var user_model_1 = require("../../models/user.model");
var roomlist_service_1 = require("../../../../../../../temp/roomlist.service");
var RoomlistComponent = (function () {
    function RoomlistComponent(applicationService) {
        this.applicationService = applicationService;
        var roomlist = new roomlist_service_1.RoomlistService(this.applicationService.getStompService, constants_1.Constants.WS_ROOMLIST_URL);
        roomlist.subscribe();
    }
    RoomlistComponent.prototype.ngOnInit = function () {
        var _this = this;
        var roomList;
        this.applicationService.getRestTemplate.doGet(constants_1.Constants.ROOM_LIST_URL).subscribe(function (x) {
            console.log(x.json());
            roomList = x.json();
            roomList.forEach(function (x) { return x.author = _this.getAuthor(x); });
            _this.rooms = roomList;
        });
    };
    RoomlistComponent.prototype.getAuthor = function (room) {
        for (var i = 0, len = room.users.length; i < len; i++) {
            if (room.users[i].getId === room.authorId) {
                return room.users[i];
            }
        }
        return new user_model_1.User[0];
    };
    RoomlistComponent.prototype.onClick = function () {
        this.applicationService.getDataHolder.logout(this.applicationService.getRestTemplate.doPost(constants_1.Constants.LOGOUT_URL, this.applicationService.getDataHolder.user));
    };
    RoomlistComponent.prototype.createRoom = function () {
        var room = new room_model_1.Room;
        room.authorId = this.applicationService.getDataHolder.user.getId;
        this.applicationService.getDataHolder.signUpToARoom(this.applicationService.getRestTemplate.doPost(constants_1.Constants.ROOM_CREATE_URL, room));
    };
    return RoomlistComponent;
}());
RoomlistComponent = __decorate([
    core_1.Component({
        templateUrl: './roomlist.component.html'
    }),
    __metadata("design:paramtypes", [application_service_1.ApplicationService])
], RoomlistComponent);
exports.RoomlistComponent = RoomlistComponent;
//# sourceMappingURL=roomlist.component.js.map