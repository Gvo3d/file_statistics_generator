import {StompConfig, StompService} from '@stomp/ng2-stompjs';
import {Constants} from "../../webapp/src/app/constants";
import {OnInit, OnDestroy} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Message} from '@stomp/stompjs';
import {Subscription} from 'rxjs/Subscription';

export abstract class AbstractStompService implements OnInit, OnDestroy {
    private stomp: StompService;
    private subscription: Subscription;
    public messages: Observable<Message>;
    public subscribed: boolean;
    public mq: Array<string> = [];
    public count = 0;
    private _counter = 1;

    constructor(private topicUrl: string) {
        this.stomp = new StompService(Constants.stompConfig);
        this.topicUrl = Constants.WS_ROOMLIST_URL;
    }

    ngOnInit() {
        console.log('roomlist-stomp-oninit');
        this.subscribe();
    }

    public subscribe() {
        console.log('roomlist-stomp-subscribe');
        this.subscribed = false;
        this.initialize();
    }

    private initialize() {
        if (this.subscribed) {
            return;
        }
        this.messages = this.stomp.subscribe(this.topicUrl);
        this.subscription = this.messages.subscribe(this.on_next);
        this.subscribed = true;
    }

    public unsubscribe() {
        if (!this.subscribed) {
            return;
        }
        this.subscription.unsubscribe();
        this.subscription = null;
        this.messages = null;
        this.subscribed = false;
    }

    ngOnDestroy() {
        console.log('roomlist-stomp-destroy');
        this.unsubscribe();
    }

    public onSendMessage(message: string) {
        console.log('roomlist-stomp-send');
        this.stomp.publish(this.topicUrl, message);
        this._counter++;
    }

    public abstract onMessageReceive(message: Message);

    /** Consume a message from the _stompService */
    public on_next = (message: Message) => {
        console.log('roomlist-stomp-receive');
        // Store message in "historic messages" queue
        this.mq.push(message.body + '\n');
        // Count it
        this.count++;
        // Log it to the console
        console.log(message);
    }
}