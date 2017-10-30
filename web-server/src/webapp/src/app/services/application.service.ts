import {Inject, Injectable} from "@angular/core";
import {RestTemplate} from "./rest.service";

@Injectable()
export class ApplicationService {
  constructor(private _rest: RestTemplate) {
  }

  get getRestTemplate(): RestTemplate {
    return this._rest;
  }
}
