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
var RoomComponent = (function () {
    function RoomComponent(applicationService) {
        this.applicationService = applicationService;
    }
    RoomComponent.prototype.exitRoom = function () {
        var result;
        if (this.applicationService.getDataHolder.room.authorId === this.applicationService.getDataHolder.user.getId) {
            this.applicationService.getRestTemplate.doDelete(constants_1.Constants.ROOM_DISBAND_URL).subscribe(function (x) { return result = x.json(); });
        }
        else {
            this.applicationService.getRestTemplate.doGet(constants_1.Constants.USER_ROOM_EXIT_URL).subscribe(function (x) { return result = x.json(); });
        }
    };
    return RoomComponent;
}());
RoomComponent = __decorate([
    core_1.Component({
        templateUrl: './room.component.html'
    }),
    __metadata("design:paramtypes", [application_service_1.ApplicationService])
], RoomComponent);
exports.RoomComponent = RoomComponent;
//# sourceMappingURL=room.component.js.map