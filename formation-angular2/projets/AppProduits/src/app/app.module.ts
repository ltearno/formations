import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {LicorneListComponent} from "./licorne-list.component";
import {LicorneDisplayComponent} from "./licorne-display.component";
import {LicorneEditorComponent} from "./licorne-editor.component";
import {DataService} from "./data.service";
import {LogService} from "./log.service";

@NgModule({
  declarations: [
    AppComponent,
    LicorneListComponent,
    LicorneDisplayComponent,
    LicorneEditorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    DataService,
    LogService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {
}
