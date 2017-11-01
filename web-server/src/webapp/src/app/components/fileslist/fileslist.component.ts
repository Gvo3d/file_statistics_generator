import {Component, OnInit, TemplateRef} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";
import {Router} from "@angular/router";
import {Constants} from "../../constants";
import {BsModalRef} from "ngx-bootstrap";

@Component({
    templateUrl: './fileslist.component.html'
})

export class FileslistComponent {
    private file: FileStatistic;
    public modalRef: BsModalRef;

    constructor(private applicationService: ApplicationService) {
    }

    showFilePage(id: Number, template: TemplateRef<any>) {
        this.applicationService.getRestTemplate.doGet(Constants.FILE_PAGE + id).subscribe(x => {
            console.log(x.json());
            this.file = x.json();
            this.modalRef = this.applicationService.getModalService.show(template);
        });
    }

    getFileList():FileStatistic[]{
        return this.applicationService.getDataService.files;
    }
}