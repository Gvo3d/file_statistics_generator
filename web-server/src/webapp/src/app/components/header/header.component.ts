import {Component, TemplateRef} from '@angular/core';
import {ApplicationService} from "../../services/application.service";
import {AbstractDataComponent} from "../abstract-data.component";
import {BsModalRef} from "ngx-bootstrap";
import {Ng4FilesStatus, Ng4FilesSelected, Ng4FilesService,
    Ng4FilesConfig,} from 'angular4-files-upload';

@Component({
    selector: 'header',
    templateUrl: './header.component.html'
})

export class HeaderComponent extends AbstractDataComponent {
    public modalRef: BsModalRef;
    public filesToUpload;

    constructor(applicationService: ApplicationService) {
        super(applicationService);
    }

    onDropDownClick(quantity: number) {
        this.pageQuantity(quantity);
    }

    showUploadPage(template: TemplateRef<any>) {
        this.modalRef = this.applicationService.getModalService.show(template);
    }


    public filesSelect(selectedFiles: Ng4FilesSelected): void {
        if (selectedFiles.status !== Ng4FilesStatus.STATUS_SUCCESS) {
            this.filesToUpload = selectedFiles.status;
            return;

            // Hnadle error statuses here
        }
        this.filesToUpload = Array.from(selectedFiles.files).map(file => file.name);
        Array.from(this.filesToUpload).forEach(x=>console.log(x));
    }
}