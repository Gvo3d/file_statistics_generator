import {Inject, Injectable} from "@angular/core";
import {RestTemplate} from "./rest.service";
import {DataService} from "./data.service";
import {ModalService} from "./modal.service";

@Injectable()
export class ApplicationService {
    constructor(private _rest: RestTemplate, private _data: DataService, private _modal:ModalService) {
    }

    get getRestTemplate(): RestTemplate {
        return this._rest;
    }

    get getDataService(): DataService {
        return this._data;
    }

    get getModalService(): ModalService {
        return this._modal;
    }
}
