import {Component, TemplateRef} from '@angular/core';
import {ApplicationService} from "../../services/application.service";
import {AbstractDataComponent} from "../abstract-data.component";
import {BsModalRef} from "ngx-bootstrap";

@Component({
    selector: 'header',
    templateUrl: './header.component.html'
})

export class HeaderComponent extends AbstractDataComponent {
    public modalRef: BsModalRef;

    constructor(applicationService: ApplicationService) {
        super(applicationService);
    }

    onDropDownClick(quantity: number) {
        this.pageQuantity(quantity);
    }

    showUploadPage(template: TemplateRef<any>) {
        this.modalRef = this.applicationService.getModalService.show(template);
    }
}