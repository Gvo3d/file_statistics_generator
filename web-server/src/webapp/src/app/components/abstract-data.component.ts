import {ApplicationService} from "../services/application.service";
import {FileStatisticPage} from "../models/file-statistic-page.model";

export abstract class AbstractDataComponent {
    constructor(public applicationService: ApplicationService) {
    }

    get pageData(): FileStatisticPage {
        return this.applicationService.getDataService.pageData;
    }

    pageNo(value: number) {
        this.applicationService.getDataService.pageNo = value;
    }

    pageQuantity(value: number) {
        this.applicationService.getDataService.pageQuantity = value;
    }

    pageSort(value: string) {
        this.applicationService.getDataService.pageSort = value;
    }

    getPageSort(): string {
        return this.applicationService.getDataService.pageSort;
    }

    changePageAscend() {
        this.applicationService.getDataService.changePageAscend();
    }

    getPageAscend(): boolean {
        return this.applicationService.getDataService.pageAscend;
    }
}