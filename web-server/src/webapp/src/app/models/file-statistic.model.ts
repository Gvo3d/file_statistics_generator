import {LineStatistic} from "./line-statistic.model";
import {FileStatisticPage} from "./file-statistic-page.model";

export class FileStatistic {
    private _id:number;
    private _filename:String;
    private _uploadDate:Date;
    private _size:number;
    private _shortestWord:String;
    private _longestWord:String;
    private _averageWordLength:number;
    private _lineStatistics:LineStatistic[];

    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get filename(): String {
        return this._filename;
    }

    set filename(value: String) {
        this._filename = value;
    }

    get uploadDate(): Date {
        return this._uploadDate;
    }

    set uploadDate(value: Date) {
        this._uploadDate = value;
    }

    get size(): number {
        return this._size;
    }

    set size(value: number) {
        this._size = value;
    }

    get shortestWord(): String {
        return this._shortestWord;
    }

    set shortestWord(value: String) {
        this._shortestWord = value;
    }

    get longestWord(): String {
        return this._longestWord;
    }

    set longestWord(value: String) {
        this._longestWord = value;
    }

    get averageWordLength(): number {
        return this._averageWordLength;
    }

    set averageWordLength(value: number) {
        this._averageWordLength = value;
    }

    get lineStatistics(): LineStatistic[] {
        return this._lineStatistics;
    }

    set lineStatistics(value: LineStatistic[]) {
        this._lineStatistics = value;
    }
}
