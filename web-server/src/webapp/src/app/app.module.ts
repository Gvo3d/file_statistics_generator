import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RoutingModule} from "./routing.module";
import {FileslistComponent} from "./components/fileslist/fileslist.component";
import {FilePageComponent} from "./components/file/filepage.component";
import {RestTemplate} from "./services/rest.service";
import {ApplicationService} from "./services/application.service";
import {DataService} from "./services/data.service";
import {MainComponent} from "./components/main/main.component";
import {HeaderComponent} from "./components/header/header.component";

@NgModule({
    imports: [RoutingModule, BrowserModule, FormsModule, HttpModule],
    declarations: [FileslistComponent, FilePageComponent, MainComponent, HeaderComponent],
    providers: [RestTemplate, DataService, ApplicationService],
    bootstrap: [HeaderComponent, MainComponent]
})

export class AppModule {
}
