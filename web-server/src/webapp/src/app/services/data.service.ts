import {Injectable, OnInit} from "@angular/core";

@Injectable()
export class DataService implements OnInit{
    ngOnInit(): void {
        this.fileListPage = true;
    }
    private _fileListPage: boolean;

    get fileListPage(): boolean {
        return this._fileListPage;
    }

    set fileListPage(value: boolean) {
        this._fileListPage = value;
    }
}