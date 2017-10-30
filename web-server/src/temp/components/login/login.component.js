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
var constants_1 = require("../../../webapp/src/app/constants");
var user_model_1 = require("../../models/user.model");
var application_service_1 = require("../../services/application.service");
var LoginComponent = (function () {
    function LoginComponent(applicationService) {
        this.applicationService = applicationService;
        console.log('LOGIN COMPONENT LOADED, appservice:' + this.applicationService);
    }
    LoginComponent.prototype.onSubmit = function (event) {
        var user = new user_model_1.User;
        user.name = this.username;
        this.applicationService.getDataHolder.fetchDataFromServer(this.applicationService.getRestTemplate.doPost(constants_1.Constants.LOGIN_URL, user));
    };
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        templateUrl: './login.component.html'
    }),
    __metadata("design:paramtypes", [application_service_1.ApplicationService])
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.component.js.map