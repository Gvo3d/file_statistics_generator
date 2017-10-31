import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {FileslistComponent} from "./components/fileslist/fileslist.component";
import {FilePageComponent} from "./components/file/filepage.component";
import {MainComponent} from "./components/main/main.component";
import {HeaderComponent} from "./components/header/header.component";

const appRoutes: Routes = [
    {path: '', redirectTo: 'filelist', pathMatch: 'full'},
    {
        path: 'header',
        component: HeaderComponent
    },
    {
        path: 'fileshow?id=id',
        component: FilePageComponent,
        data: {title: 'File statistic'}
    },
    {
        path: 'filelist',
        component: FileslistComponent,
        data: {title: 'File statistics list'}
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