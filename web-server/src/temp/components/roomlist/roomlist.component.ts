import {Component, OnInit} from "@angular/core";
import {ApplicationService} from "../../services/application.service";
import {Constants} from "../../../webapp/src/app/constants";
import {Room} from "../../models/room.model";
import {User} from "../../models/user.model";
import {RoomlistStompService} from "../../services/roomlist.stomp.service";

@Component({
  templateUrl: './roomlist.component.html'
})

export class RoomlistComponent implements OnInit {
  private rooms: Room[];

  constructor(private applicationService: ApplicationService) {
    // let roomlist:RoomlistService = new RoomlistService(this.applicationService.getStompService, Constants.WS_ROOMLIST_URL);
    // roomlist.subscribe();
      console.log('roomlist-component-beforeservicecreate');
      let test:RoomlistStompService = new RoomlistStompService;
  }

  ngOnInit(): void {
    let roomList: Room[];
    this.applicationService.getRestTemplate.doGet(Constants.ROOM_LIST_URL).subscribe(x => {
      console.log(x.json());
      roomList = x.json();
      roomList.forEach(x=>x.author=this.getAuthor(x));
      this.rooms = roomList;
    });
  }

  private getAuthor(room:Room):User {
    for (var i = 0, len = room.users.length; i < len; i++){
      if (room.users[i].getId===room.authorId){
        return room.users[i];
      }
    }
    return new User[0];
  }

  public onClick() {
    this.applicationService.getDataHolder.logout(this.applicationService.getRestTemplate.doPost(Constants.LOGOUT_URL, this.applicationService.getDataHolder.user));
  }

  public createRoom() {
    let room:Room = new Room;
    room.authorId = this.applicationService.getDataHolder.user.getId;
    this.applicationService.getDataHolder.signUpToARoom(this.applicationService.getRestTemplate.doPost(Constants.ROOM_CREATE_URL, room));
  }

}
