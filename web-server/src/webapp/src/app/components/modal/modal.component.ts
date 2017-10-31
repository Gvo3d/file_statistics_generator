import {Component, Input} from '@angular/core';

import {NgbModal, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {FileStatistic} from "../../models/file-statistic.model";

@Component({
  selector: 'ngbd-modal-content',
  templateUrl: './filepage.component.html'
})
export class NgbdModalContent {
  @Input() file: FileStatistic;

  constructor(public activeModal: NgbActiveModal) {}
}
