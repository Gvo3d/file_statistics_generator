"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var rest_service_1 = require("../../../temp/services/rest.service");
var login_component_1 = require("../../../temp/components/login/login.component");
var forms_1 = require("@angular/forms");
var application_service_1 = require("../../../temp/services/application.service");
var http_1 = require("@angular/http");
var room_component_1 = require("../../../temp/components/room/room.component");
var roomlist_component_1 = require("../../../temp/components/roomlist/roomlist.component");
var notfound_component_1 = require("../../../temp/components/pagenotfound/notfound.component");
var main_component_1 = require("../../../temp/components/main/main.component");
var routing_module_1 = require("./routing.module");
var data_service_1 = require("../../../temp/services/data.service");
var websocket_service_1 = require("../../../temp/services/websocket.service");
var roomlist_service_1 = require("../../../../../temp/roomlist.service");
var ng2_stompjs_1 = require("@stomp/ng2-stompjs");
var constants_1 = require("./constants");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [routing_module_1.RoutingModule, platform_browser_1.BrowserModule, forms_1.FormsModule, http_1.HttpModule],
        declarations: [main_component_1.MainComponent, login_component_1.LoginComponent, room_component_1.RoomComponent, roomlist_component_1.RoomlistComponent, notfound_component_1.PageNotFoundComponent, roomlist_service_1.RoomlistService],
        providers: [rest_service_1.RestTemplate, data_service_1.DataHolder, websocket_service_1.WebsocketService, application_service_1.ApplicationService, ng2_stompjs_1.StompService,
            {
                provide: ng2_stompjs_1.StompConfig,
                useValue: constants_1.Constants.stompConfig
            }],
        bootstrap: [main_component_1.MainComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map