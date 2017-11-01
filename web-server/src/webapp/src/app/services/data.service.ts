import {Injectable, OnInit} from "@angular/core";
import {Constants} from "../constants";
import {FileStatistic} from "../models/file-statistic.model";

@Injectable()
export class DataService {
    private _files: FileStatistic[];
    private _fileList_page:number;
    private _fileList_quantity:number;
    private _fileList_sort:string;
    private _fileList_ascend:boolean;

    constructor() {
        console.log('CONSTRUCTOR!!!');
        this._fileList_page=0;
        this._fileList_quantity=4;
        this._fileList_sort='id';
        this._fileList_ascend=false;
    }

    public concatenateFileListUrl(): string {
        return Constants.FILE_LIST + "?page=" + this._fileList_page + "&quantity=" + this._fileList_quantity + "&sort=" + this._fileList_sort + "&ascend=" + this._fileList_ascend;
    }

    get files(): FileStatistic[] {
        return this._files;
    }

    set files(value: FileStatistic[]) {
        this._files = value;
    }

    set fileList_page(value: number) {
        this._fileList_page = value;
    }

    set fileList_quantity(value: number) {
        this._fileList_quantity = value;
    }

    set fileList_sort(value: string) {
        this._fileList_sort = value;
    }

    set fileList_ascend(value: boolean) {
        this._fileList_ascend = value;
    }
}