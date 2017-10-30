"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var router_1 = require("@angular/router");
var login_component_1 = require("../../../temp/components/login/login.component");
var room_component_1 = require("../../../temp/components/room/room.component");
var roomlist_component_1 = require("../../../temp/components/roomlist/roomlist.component");
var notfound_component_1 = require("../../../temp/components/pagenotfound/notfound.component");
var core_1 = require("@angular/core");
var appRoutes = [
    {
        path: 'login',
        component: login_component_1.LoginComponent,
        data: { title: 'Login' }
    },
    {
        path: 'room/:id',
        component: room_component_1.RoomComponent,
        data: { title: 'Room' }
    },
    {
        path: 'roomlist',
        component: roomlist_component_1.RoomlistComponent,
        data: { title: 'RoomList' }
    },
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    },
    { path: '**', component: notfound_component_1.PageNotFoundComponent }
];
var RoutingModule = (function () {
    function RoutingModule() {
    }
    return RoutingModule;
}());
RoutingModule = __decorate([
    core_1.NgModule({
        imports: [
            router_1.RouterModule.forRoot(appRoutes, {
                enableTracing: true,
            })
        ],
        exports: [
            router_1.RouterModule
        ]
    })
], RoutingModule);
exports.RoutingModule = RoutingModule;
//# sourceMappingURL=routing.module.js.map