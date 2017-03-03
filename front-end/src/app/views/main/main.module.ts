/**
 * Created by ichigo on 02/03/17.
 */
import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {MainComponent} from './main.component'
import {RouterModule} from "@angular/router";
import {NavigationModule} from "../navigation/navigation.module";

// App modules/components

@NgModule({
    declarations: [MainComponent],
    imports: [BrowserModule, RouterModule, NavigationModule],
})

export class MainModule {
}