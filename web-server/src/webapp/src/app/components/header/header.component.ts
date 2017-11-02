import {Component, TemplateRef} from '@angular/core';
import {ApplicationService} from "../../services/application.service";
import {AbstractDataComponent} from "../abstract-data.component";
import {BsModalRef} from "ngx-bootstrap";
import {Ng4FilesStatus, Ng4FilesSelected} from 'angular4-files-upload';
import {Constants} from "../../constants";
import {Http, Response, Headers, RequestOptions} from '@angular/http';

@Component({
    selector: 'header',
    templateUrl: './header.component.html'
})

export class HeaderComponent extends AbstractDataComponent {
    public modalRef: BsModalRef;
    public filesToUpload;
    private onError: boolean = false;
    private responsePanel: string = null;

    constructor(applicationService: ApplicationService) {
        super(applicationService);
    }

    onDropDownClick(quantity: number) {
        this.pageQuantity(quantity);
    }

    showUploadPage(template: TemplateRef<any>) {
        this.modalRef = this.applicationService.getModalService.show(template);
    }

    modalClose(){
        this.modalRef.hide();
        this.onError = false;
    }

    public filesSelect(selectedFiles: Ng4FilesSelected): void {
        this.onError = false;
        if (selectedFiles.status !== Ng4FilesStatus.STATUS_SUCCESS) {
            this.filesToUpload = selectedFiles.status;
            this.onError = true;
        }
        this.filesToUpload = Array.from(selectedFiles.files).map(file => file.name);
        console.log(selectedFiles);
        let formData = new FormData();
        for (let file of selectedFiles.files) {
            formData.append('files', file, file.name);
        }
        let headers: Headers = new Headers();
        headers.append("Accept", 'application/json');
        this.applicationService.getRestTemplate.doPost(Constants.UPLOAD, formData, headers).subscribe(x => {
                this.responsePanel = x.text();
            },
            err => {
                console.log(err);
                this.onError = true;
                this.filesToUpload = null;
            },
            () => {
                console.log('Request Complete');
                this.reloadData();
                this.modalClose();
                this.filesToUpload = null;
            });
    }
}
