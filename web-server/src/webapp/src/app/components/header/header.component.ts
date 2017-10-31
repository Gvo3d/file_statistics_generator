import {Component} from '@angular/core';
import {ApplicationService} from "../../services/application.service";

@Component({
  selector: 'header',
  templateUrl: './header.component.html'
})

export class HeaderComponent {
  constructor(private applicationService: ApplicationService) {
  }
}
