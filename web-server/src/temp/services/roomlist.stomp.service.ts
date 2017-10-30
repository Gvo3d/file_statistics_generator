import {AbstractStompService} from "./abstract.stomp.service";
import {Constants} from "../../webapp/src/app/constants";
import {Message} from '@stomp/stompjs';

export class RoomlistStompService extends AbstractStompService{
    onMessageReceive(message: Message) {
    }

    constructor() {
        super(Constants.WS_ROOMLIST_URL);
    }

}