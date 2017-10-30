import {User} from "../models/user.model";
import {DoCheck, Injectable, OnChanges, SimpleChanges} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Response} from '@angular/http';
import {Router} from "@angular/router";
import {Room} from "../models/room.model";

@Injectable()
export class DataHolder {

  private afterLogin: boolean = false;
  private _user: User;
  private _room: Room;

  constructor(private router: Router) {
  }

  public get user(): User {
    return this._user;
  }

  get room(): Room {
    return this._room;
  }

  public logout(fromServer: Observable<Response>) {
    let result: User;
    fromServer.subscribe(next=> {
      result = <User>next.json();
      if (result) {
        this.afterLogin = false;
        this._user = null;
      }
    });
    this.afterLogin = false;
  }

  public fetchDataFromServer(fromServer: Observable<Response>) {
    let result: User;
    fromServer.subscribe(next => {
      result = <User>next.json();
      this._user = result;
      this.checkUserChangesAndCloseLoginForm();
    });
  }

  private checkUserChangesAndCloseLoginForm(): void {
    if (this.afterLogin == false) {
      if (this._user) {
        console.log("user.id=" + this._user.id + ", user.name=" + this._user.name)
        this.afterLogin = true;
        this.router.navigate(['/roomlist']);
      }
    }
  }

  public signUpToARoom(fromServer: Observable<Response>){
    fromServer.subscribe(next => {
      this._room = <Room>next.json();
      this.router.navigate(['/room/'+this._room.id]);
    });
  }

  public exitRoomAndDisbandIfAuthor(){
    this.router.navigate(['/roomlist']);
  }
}
