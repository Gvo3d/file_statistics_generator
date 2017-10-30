import {Component, OnInit} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";
import {Router} from "@angular/router";

@Component({
    templateUrl: './fileslist.component.html'
})

export class FileslistComponent implements OnInit {
    private files: FileStatistic[];

    constructor(private applicationService: ApplicationService, private page: number, private quantity: number, private sort: string, private ascend: boolean, private router: Router) {
        this.applicationService.getDataService.fileListPage = true;
    }

    ngOnInit(): void {
        this.applicationService.getRestTemplate.doGet(this.applicationService.getRestTemplate.concatenateFileListUrl(this.page, this.quantity, this.sort, this.ascend)).subscribe(x => {
            console.log(x.json());
            this.files = x.json();
        });
    }

    showFilePage(id: Number) {
        this.applicationService.getDataService.fileListPage = false;
        this.router.navigate(['/fileshow&id='+id]);
    }
}