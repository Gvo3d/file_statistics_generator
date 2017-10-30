import {User} from "./user.model";

export class Room implements IRoom{
  private _id: number;
  private _name: string;
  private _created: Date;
  private _authorId: number;
  private _author:User;
  private _users: User[];
  private _opened:boolean;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get created(): Date {
    return this._created;
  }

  set created(value: Date) {
    this._created = value;
  }

  get authorId(): number {
    return this._authorId;
  }

  set authorId(value: number) {
    this._authorId = value;
  }

  get users(): User[] {
    return this._users;
  }

  set users(value: User[]) {
    this._users = value;
  }

  get opened():boolean {
    return this._opened;
  }

  set opened(value:boolean) {
    this._opened = value;
  }

  get author(): User {
    return this._author;
  }

  set author(value: User) {
    this._author = value;
  }
}

export interface IRoom {
  id:number;
  name:string;
  created:Date;
  authorId:number;
  author:User;
  users:User[];
  opened:boolean;

  toString():string;
}
