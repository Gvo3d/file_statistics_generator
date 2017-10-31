import {Component, OnInit} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";
import {Constants} from "../../constants";

@Component({
    templateUrl: './filepage.component.html'
})

export class FilePageComponent implements OnInit {
    private file: FileStatistic;

    constructor(private applicationService: ApplicationService, private id:number) {
    }

    ngOnInit(): void {
        this.applicationService.getRestTemplate.doGet(Constants.FILE_PAGE+"?id="+this.id).subscribe(x => {
            console.log(x.json());
            this.file = x.json();
        });
    }
}