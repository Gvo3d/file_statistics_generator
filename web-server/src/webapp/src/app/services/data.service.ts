import {Injectable, OnInit} from "@angular/core";
import {Constants} from "../constants";
import {FileStatisticPage} from "../models/file-statistic-page.model";
import {RestTemplate} from "./rest.service";

@Injectable()
export class DataService {
    private _loading:boolean=true;
    private _pageData: FileStatisticPage;
    private _pageNo:number;
    private _pageQuantity:number;
    private _pageSort:string;
    private _pageAscend:boolean;

    constructor(private rest: RestTemplate) {
        this._pageNo=0;
        this._pageQuantity=4;
        this._pageSort='uploadDate';
        this._pageAscend=false;
        this._pageData = new FileStatisticPage;
        this.populateData();
    }

    public populateData(){
        this._loading = true;
        this.rest.doGet(Constants.FILE_LIST + "?page=" + this._pageNo + "&quantity=" + this._pageQuantity + "&sort=" + this._pageSort + "&ascend=" + this._pageAscend).subscribe(x => {
            console.log(x.json());
            this._pageData = x.json();
            this._loading = false;
        });
    }

    get pageData(): FileStatisticPage {
        return this._pageData;
    }

    set pageNo(value: number) {
        this._pageNo = value;
        this.populateData();
    }

    set pageQuantity(value: number) {
        this._pageQuantity = value;
        this._pageNo=0;
        this.populateData();
    }

    set pageSort(value: string) {
        this._pageSort = value;
        this._pageAscend = true;
        this._pageNo=0;
        this.populateData();
    }

    changePageAscend() {
        this._pageAscend = !this._pageAscend;
        this._pageNo=0;
        this.populateData();
    }

    get pageSort(): string {
        return this._pageSort;
    }

    get pageAscend(): boolean {
        return this._pageAscend;
    }

    get loading(): boolean {
        return this._loading;
    }
}