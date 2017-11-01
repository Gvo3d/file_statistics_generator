import {Component} from '@angular/core';
import {ApplicationService} from "../../services/application.service";
import {Router} from "@angular/router";

@Component({
    selector: 'header',
    templateUrl: './header.component.html'
})

export class HeaderComponent {
    constructor(private applicationService: ApplicationService, private router: Router) {
        this.loadData();
    }

    onDropDownClick(quantity: number) {
        console.log("onDropDownClick");
        this.applicationService.getDataService.fileList_quantity = quantity;
        this.loadData();
    }

    private loadData(){
        this.applicationService.getRestTemplate.doGet(this.applicationService.getDataService.concatenateFileListUrl()).subscribe(x => {
            console.log(x.json());
            this.applicationService.getDataService.files = x.json();
        });
    }
}