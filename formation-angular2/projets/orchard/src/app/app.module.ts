import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { DieComponent } from './die.component';
import { CrowComponent } from './crow.component';
import { TreeComponent } from './tree.component';
import { TreesComponent } from './trees.component';

@NgModule({
  declarations: [
    AppComponent,
    DieComponent,
    CrowComponent,
    TreeComponent,
    TreesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
