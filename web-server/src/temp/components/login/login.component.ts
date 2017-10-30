import {Component} from '@angular/core';
import {Constants} from "../../../webapp/src/app/constants";
import {User, IUser} from "../../models/user.model";
import {ApplicationService} from "../../services/application.service";
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";

@Component({
  templateUrl: './login.component.html'
})

export class LoginComponent {
  private username: String;

  constructor(private applicationService:ApplicationService) {
    console.log('LOGIN COMPONENT LOADED, appservice:'+this.applicationService);
  }

  onSubmit(event: Event) {
    let user:IUser = new User;
    user.name=this.username;
    this.applicationService.getDataHolder.fetchDataFromServer(this.applicationService.getRestTemplate.doPost(Constants.LOGIN_URL, user));
  }
}
