import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RestTemplate} from "../../../temp/services/rest.service";
import {LoginComponent} from "../../../temp/components/login/login.component";
import {FormsModule} from "@angular/forms";
import {ApplicationService} from "../../../temp/services/application.service";
import {HttpModule} from "@angular/http";
import {RoomComponent} from "../../../temp/components/room/room.component";
import {RoomlistComponent} from "../../../temp/components/roomlist/roomlist.component";
import {PageNotFoundComponent} from "../../../temp/components/pagenotfound/notfound.component";
import {MainComponent} from "../../../temp/components/main/main.component";
import {RoutingModule} from "./routing.module";
import {DataHolder} from "../../../temp/services/data.service";
import {StompConfig, StompService} from '@stomp/ng2-stompjs';
import {Constants} from "./constants";

@NgModule({
  imports: [RoutingModule, BrowserModule, FormsModule, HttpModule],
  declarations: [MainComponent, LoginComponent, RoomComponent, RoomlistComponent, PageNotFoundComponent],
  providers: [RestTemplate, DataHolder, ApplicationService],
  bootstrap: [MainComponent]
})

export class AppModule {
}
