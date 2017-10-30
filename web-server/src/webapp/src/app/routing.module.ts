import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "../../../temp/components/login/login.component";
import {RoomComponent} from "../../../temp/components/room/room.component";
import {RoomlistComponent} from "../../../temp/components/roomlist/roomlist.component";
import {PageNotFoundComponent} from "../../../temp/components/pagenotfound/notfound.component";
import {NgModule} from "@angular/core";

const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    data: {title: 'Login'}
  },
  {
    path: 'room/:id',
    component: RoomComponent,
    data: {title: 'Room'}
  },
  {
    path: 'filelist/?page=:page&quantity=:quantity&sort=:sort&ascend=:ascend',
    component: RoomlistComponent,
    data: {title: 'RoomList'}
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: true, // <-- debugging purposes only
      }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
