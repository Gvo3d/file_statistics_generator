import {FileStatistic} from "./file-statistic.model";

export class FileStatisticPage {
    private _pageNo: number = 0;
    private _pageSize: number = 0;
    private _pagesCount: number = 0;
    private _fileStatistics: FileStatistic[] = [];

    // public static getEmptyPage():FileStatisticPage {
    //     let fsp:FileStatisticPage = new FileStatisticPage;
    //     return
    // }

    get pageNo(): number {
        return this._pageNo;
    }

    set pageNo(value: number) {
        this._pageNo = value;
    }

    get pageSize(): number {
        return this._pageSize;
    }

    set pageSize(value: number) {
        this._pageSize = value;
    }

    get pagesCount(): number {
        return this._pagesCount;
    }

    set pagesCount(value: number) {
        this._pagesCount = value;
    }

    get fileStatistics(): FileStatistic[] {
        return this._fileStatistics;
    }

    set fileStatistics(value: FileStatistic[]) {
        this._fileStatistics = value;
    }
}