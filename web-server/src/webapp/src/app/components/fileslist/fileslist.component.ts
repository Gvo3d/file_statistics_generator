import {Component, OnInit} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";

@Component({
    templateUrl: './roomlist.component.html'
})

export class FileslistComponent implements OnInit {
    private files: FileStatistic[];

    constructor(private applicationService: ApplicationService, private page: number, private quantity: number, private sort: String, private ascend: boolean) {
    }

    ngOnInit(): void {
        this.applicationService.getRestTemplate.doGet(this.applicationService.getRestTemplate.concatenateFileListUrl(this.page, this.quantity, this.sort, this.ascend)).subscribe(x => {
            console.log(x.json());
            this.files = x.json();
        });
    }
}