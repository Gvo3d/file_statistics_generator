import {Component} from '@angular/core';
import {ApplicationService} from "../../services/application.service";
import {Constants} from "../../constants";
import {Room} from "../../models/room.model";

@Component({
  selector: 'main',
  templateUrl: './main.component.html'
})
export class MainComponent {
  constructor(private applicationService: ApplicationService) {
  }
}
