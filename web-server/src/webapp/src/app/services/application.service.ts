import {Inject, Injectable} from "@angular/core";
import {RestTemplate} from "./rest.service";
import {DataService} from "./data.service";
import {BsModalService} from "ngx-bootstrap";
import {Router} from "@angular/router";

@Injectable()
export class ApplicationService {
    constructor(private _rest: RestTemplate, private _data: DataService, private _modal: BsModalService, private _router: Router) {
    }

    get getRestTemplate(): RestTemplate {
        return this._rest;
    }

    get getDataService(): DataService {
        return this._data;
    }

    get getModalService(): BsModalService {
        return this._modal;
    }

    get getRouter(): Router {
        return this._router;
    }
}
