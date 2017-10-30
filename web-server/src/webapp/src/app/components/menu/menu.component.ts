import {Component, OnInit} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";
import {Constants} from "../../constants";

@Component({
    templateUrl: './menu.component.html'
})

export class MenuComponent {
    private show: boolean = true;

    constructor(doShow?:boolean) {
        if (doShow!=null) {
            this.show = doShow;
        }
    }
}