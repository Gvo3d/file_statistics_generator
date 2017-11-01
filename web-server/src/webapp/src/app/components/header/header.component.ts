import {Component} from '@angular/core';
import {ApplicationService} from "../../services/application.service";
import {Router} from "@angular/router";
import {AbstractDataComponent} from "../abstract-data.component";
import {DataService} from "../../services/data.service";

@Component({
    selector: 'header',
    templateUrl: './header.component.html'
})

export class HeaderComponent extends AbstractDataComponent {
    constructor(applicationService: ApplicationService) {
        super(applicationService);
    }

    onDropDownClick(quantity: number) {
        this.pageQuantity(quantity);
    }
}