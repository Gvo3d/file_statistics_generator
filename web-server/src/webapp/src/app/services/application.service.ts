import {Inject, Injectable, OnInit} from "@angular/core";
import {RestTemplate} from "./rest.service";
import {DataService} from "./data.service";
import {BsModalService} from "ngx-bootstrap";
import {Router} from "@angular/router";
import {Ng4FilesStatus, Ng4FilesSelected, Ng4FilesService, Ng4FilesConfig,} from 'angular4-files-upload';
import {Constants} from "../constants";

@Injectable()
export class ApplicationService implements OnInit{
    constructor(private _rest: RestTemplate, private _data:DataService, private _modal: BsModalService, private _router: Router, private ng4FilesService: Ng4FilesService) {
    }

    ngOnInit() {
        this.ng4FilesService.addConfig(Constants.filesUploadConfig);
    }

    get getRestTemplate(): RestTemplate {
        return this._rest;
    }

    get getModalService(): BsModalService {
        return this._modal;
    }

    get getRouter(): Router {
        return this._router;
    }

    get getDataService(): DataService {
        return this._data;
    }
}
