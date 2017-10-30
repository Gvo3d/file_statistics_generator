import {Component} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {Constants} from "../../../webapp/src/app/constants";

@Component({
  templateUrl: './room.component.html'
})

export class RoomComponent{

  constructor(private applicationService: ApplicationService) {
  }

  public exitRoom(){
    let result:boolean;
    if (this.applicationService.getDataHolder.room.authorId===this.applicationService.getDataHolder.user.getId){
      this.applicationService.getRestTemplate.doDelete(Constants.ROOM_DISBAND_URL).subscribe(x=>result = x.json());
    } else {
      this.applicationService.getRestTemplate.doGet(Constants.USER_ROOM_EXIT_URL).subscribe(x=>result = x.json());
    }
  }
}
