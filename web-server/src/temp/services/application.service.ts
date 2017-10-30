import {Inject, Injectable} from "@angular/core";
import {RestTemplate} from "./rest.service";
import {DataHolder} from "./data.service";
import {StompService} from '@stomp/ng2-stompjs';

@Injectable()
export class ApplicationService {
  constructor(private _rest: RestTemplate, private _user: DataHolder) {
  }

  get getRestTemplate(): RestTemplate {
    return this._rest;
  }

  get getDataHolder(): DataHolder {
    return this._user;
  }
  //
  // get getWebSocket(): WebsocketService {
  //   return this._socket;
  // }
  //
  // get roomlist(): AbstractStompService {
  //   return this._roomlist;
  // }

  //
  // get getStompService(): StompService {
  //   return this._stompService;
  // }


  // get getRoomlist(): RoomlistService {
  //   return this._roomlist;
  // }
}
