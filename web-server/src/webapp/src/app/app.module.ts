import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RoutingModule} from "./routing.module";
import {MenuComponent} from "./components/menu/menu.component";
import {FileslistComponent} from "./components/fileslist/fileslist.component";
import {FilePageComponent} from "./components/file/filepage.component";
import {RestTemplate} from "./services/rest.service";
import {ApplicationService} from "./services/application.service";
import {DataService} from "./services/data.service";
import {MainComponent} from "./components/main/main.component";

@NgModule({
  imports: [RoutingModule, BrowserModule, FormsModule, HttpModule],
  declarations: [MenuComponent, FileslistComponent, FilePageComponent, MainComponent],
  providers: [RestTemplate, DataService, ApplicationService],
  bootstrap: [MainComponent]
})

export class AppModule {
}
