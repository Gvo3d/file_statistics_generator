import {StompConfig} from '@stomp/ng2-stompjs';
import * as SockJS from 'sockjs-client';
import {variable} from "@angular/compiler/src/output/output_ast";
import {debug} from "util";

export class Constants {
    public static get HOME_URL(): string {
        return "http://localhost:8080";
    };

    public static get FILE_LIST(): string {
        return "/files/list";
    };

    public static get LOGOUT_URL(): string {
        return "/doLogout";
    };

    public static get ROOM_LIST_URL(): string {
        return "/roomList";
    };

    public static get ROOM_CREATE_URL(): string {
        return "/createRoom";
    };

    public static get ROOM_DISBAND_URL(): string {
        return "/disband/";
    };

    public static get USER_ROOM_EXIT_URL(): string {
        return "/exit/";
    };

    public static get WS_ROOMLIST_URL(): string {
        return "/app/ws-roomlist";
    };
}