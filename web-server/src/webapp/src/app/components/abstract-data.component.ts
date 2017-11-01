import {ApplicationService} from "../services/application.service";
import {DataService} from "../services/data.service";
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

    pageAscend(value: boolean) {
        this.applicationService.getDataService.pageAscend = value;
    }
}