export class Page {
    private _pageNo:number;
    private _name:string;
    private _current:boolean;

    constructor(pageNo: number, name: string, current: boolean) {
        this._pageNo = pageNo;
        this._name = name;
        this._current = current;
    }

    get pageNo(): number {
        return this._pageNo;
    }

    get name(): string {
        return this._name;
    }

    get current(): boolean {
        return this._current;
    }

}