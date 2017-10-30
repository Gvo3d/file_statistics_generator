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
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
var http_1 = require("@angular/http");
var core_1 = require("@angular/core");
var core_2 = require("@angular/core");
var constants_1 = require("../../webapp/src/app/constants");
var RestTemplate = (function () {
    function RestTemplate(http) {
        this.http = http;
        this.headers = new http_1.Headers();
        this.baseUrl = constants_1.Constants.HOME_URL;
    }
    RestTemplate.prototype.ngOnInit = function () {
        this.headers.append('Content-Type', 'application/json');
        this.headers.append("Accept", 'application/json');
    };
    RestTemplate.prototype.doGet = function (url) {
        return this.http.get(this.getUrl(url), { headers: this.headers });
    };
    RestTemplate.prototype.doPost = function (url, dataToSend) {
        return this.http.post(this.getUrl(url), dataToSend, { headers: this.headers });
    };
    RestTemplate.prototype.doDelete = function (url) {
        return this.http.delete(this.getUrl(url), { headers: this.headers });
    };
    RestTemplate.prototype.getUrl = function (url) {
        return this.baseUrl + url;
    };
    return RestTemplate;
}());
RestTemplate = __decorate([
    core_2.Injectable(),
    __param(0, core_1.Inject(http_1.Http)),
    __metadata("design:paramtypes", [http_1.Http])
], RestTemplate);
exports.RestTemplate = RestTemplate;
// private send(dataToSend: string) {
//   var data = {event: dataToSend};
//   const body = JSON.stringify(data);
//
//   this.http.post(this.baseUrl, body, {headers: this.headers});
// }
//# sourceMappingURL=rest.service.js.map