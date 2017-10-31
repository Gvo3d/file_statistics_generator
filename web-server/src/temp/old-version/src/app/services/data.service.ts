import {Injectable, OnInit} from "@angular/core";
import {Constants} from "../constants";

@Injectable()
export class DataService {
    private fileList_page:number;
    private fileList_quantity:number;
    private fileList_sort:string;
    private fileList_ascend:boolean;

    constructor() {
        this.fileList_page=0;
        this.fileList_quantity=4;
        this.fileList_sort='id';
        this.fileList_ascend=false;
    }

    public concatenateFileListUrl(): string {
        return Constants.FILE_LIST + "?page=" + this.fileList_page + "&quantity=" + this.fileList_quantity + "&sort=" + this.fileList_sort + "&ascend=" + this.fileList_ascend;
    }
}