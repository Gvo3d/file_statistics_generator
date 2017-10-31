import {Inject, Injectable} from "@angular/core";
import {RestTemplate} from "./rest.service";
import {DataService} from "./data.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Injectable()
export class ApplicationService {
  constructor(private _rest: RestTemplate, private _data: DataService, private _modal: NgbModal) {
  }

  get getRestTemplate(): RestTemplate {
    return this._rest;
  }

  get getDataService(): DataService {
    return this._data;
  }

  get getModalService(): NgbModal {
    return this._modal;
  }
}
