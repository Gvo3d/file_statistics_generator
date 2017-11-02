import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RoutingModule} from "./routing.module";
import {FileslistComponent} from "./components/fileslist/fileslist.component";
import {RestTemplate} from "./services/rest.service";
import {ApplicationService} from "./services/application.service";
import {DataService} from "./services/data.service";
import {MainComponent} from "./components/main.component";
import {HeaderComponent} from "./components/header/header.component";
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {TooltipModule} from 'ngx-bootstrap/tooltip';
import {ModalModule} from 'ngx-bootstrap/modal';
import {Ng4FilesModule} from 'angular4-files-upload';

@NgModule({
    imports: [
        RoutingModule,
        BrowserModule,
        FormsModule,
        HttpModule,
        Ng4FilesModule,
        BsDropdownModule.forRoot(),
        TooltipModule.forRoot(),
        ModalModule.forRoot()],
    exports: [
        BsDropdownModule,
        TooltipModule,
        ModalModule],
    declarations: [
        FileslistComponent,
        MainComponent,
        HeaderComponent],
    providers: [
        RestTemplate,
        DataService,
        ApplicationService],
    bootstrap: [
        HeaderComponent,
        MainComponent]
})

export class AppModule {
}
