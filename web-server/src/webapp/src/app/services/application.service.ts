import {Inject, Injectable} from "@angular/core";
import {RestTemplate} from "./rest.service";
import {DataService} from "./data.service";

@Injectable()
export class ApplicationService {
    constructor(private _rest: RestTemplate, private _data: DataService) {
    }

    get getRestTemplate(): RestTemplate {
        return this._rest;
    }

    get getDataService(): DataService {
        return this._data;
    }
}
