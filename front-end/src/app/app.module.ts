/**
 * Created by ichigo on 02/03/17.
 */
import {NgModule} from '@angular/core';
import {BrowserModule}  from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {MainModule, NavigationModule} from "./views/view";
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routes";

@NgModule({
    imports: [
        BrowserModule,
        MainModule,
        NavigationModule,

        RouterModule.forRoot(ROUTES)
    ],
    declarations: [
        AppComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
