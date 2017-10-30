import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {FileslistComponent} from "./components/fileslist/fileslist.component";
import {FilePageComponent} from "./components/file/filepage.component";

const appRoutes: Routes = [
    {
        path: 'fileshow?id=id',
        component: FilePageComponent,
        data: {title: 'File statistic'}
    },
    {
        path: 'filelist?page=:page&quantity=:quantity&sort=:sort&ascend=:ascend',
        component: FileslistComponent,
        data: {title: 'File statistics list'}
    },
    {
        path: '',
        redirectTo: 'filelist?page=0&quantity=5&sort=id&ascend=false',
        pathMatch: 'full'
    }
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
export class RoutingModule {
}
