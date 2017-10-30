import {Component} from '@angular/core';
import {ApplicationService} from "../../services/application.service";

@Component({
  selector: 'main',
  templateUrl: './main.component.html'
})

export class MainComponent {
  constructor(private applicationService: ApplicationService) {
  }
}
