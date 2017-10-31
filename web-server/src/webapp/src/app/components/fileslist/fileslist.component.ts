import {Component, OnInit} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";
import {Router} from "@angular/router";

@Component({
    templateUrl: './fileslist.component.html'
})

export class FileslistComponent implements OnInit {
    private files: FileStatistic[];

    constructor(private applicationService: ApplicationService, private router: Router) {
    }

    ngOnInit(): void {
        this.applicationService.getRestTemplate.doGet(this.applicationService.getDataService.concatenateFileListUrl()).subscribe(x => {
            console.log(x.json());
            this.files = x.json();
        });
    }

    showFilePage(id: Number) {
        this.router.navigate(['/fileshow&id='+id]);
    }

}