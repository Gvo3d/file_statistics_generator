export class LineStatistic {
    private _id:number;
    private _line:String;
    private _shortestWord:String;
    private _longestWord:String;
    private _averageWordLength:number;


    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get line(): String {
        return this._line;
    }

    set line(value: String) {
        this._line = value;
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
}