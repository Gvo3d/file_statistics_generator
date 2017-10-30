import {Injectable} from "@angular/core";

@Injectable
export class DataService{
    private _fileListPage: boolean;

    get fileListPage(): boolean {
        return this._fileListPage;
    }

    set fileListPage(value: boolean) {
        this._fileListPage = value;
    }
}