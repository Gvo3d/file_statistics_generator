import {Component, TemplateRef} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {FileStatistic} from "../../models/file-statistic.model";
import {Constants} from "../../constants";
import {BsModalRef} from "ngx-bootstrap";
import {AbstractDataComponent} from "../abstract-data.component";
import {Page} from "../../models/pagination.model";

@Component({
    templateUrl: './fileslist.component.html'
})

export class FileslistComponent extends AbstractDataComponent {
    private file: FileStatistic;
    public modalRef: BsModalRef;

    constructor(applicationService: ApplicationService) {
        super(applicationService);
    }

    showFilePage(id: Number, template: TemplateRef<any>) {
        this.applicationService.getRestTemplate.doGet(Constants.FILE_PAGE + id).subscribe(x => {
            console.log(x.json());
            this.file = x.json();
            this.modalRef = this.applicationService.getModalService.show(template);
        });
    }

    getPagination(): Page[] {
        let filePage = this.pageData;
        let result: Page[] = [];
        result.push(new Page(0, "<<", !(filePage.pageNo > 2)));
        let i;
        let j;
        if (filePage.pageNo > filePage.pagesCount - 3) {
            i = filePage.pagesCount - 5;
            j = i + (filePage.pagesCount - i);
        } else {
            i = (filePage.pageNo > 1 ? filePage.pageNo - 2 : 0);
            j = (filePage.pagesCount > 4 ? i + 5 : filePage.pagesCount);
        }
        for (i; i < j; i++) {
            result.push(new Page(i, (i + 1) + "", (i == filePage.pageNo)));
        }
        result.push(new Page(filePage.pagesCount - 1, ">>", !(filePage.pageNo < filePage.pagesCount - 3)));
        return result;
    }
}