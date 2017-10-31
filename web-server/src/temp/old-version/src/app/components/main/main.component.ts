import {Component} from '@angular/core';
import {ApplicationService} from "../../services/application.service";

@Component({
  selector: 'main',
  template: '<router-outlet></router-outlet>'
})

export class MainComponent {

  constructor(private applicationService: ApplicationService) {
  }

}
