import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'
import { AngularAppComponent } from './app.component'
import { APP_CONFIG } from './app.config'

@NgModule({
    imports: [BrowserModule],
    declarations: [AngularAppComponent],
    providers: [
        { provide: 'CONSTANTE', useValue: 5 },
        { provide: APP_CONFIG, useValue: { production: false, title: 'Sandrero' } }
    ],
    bootstrap: [AngularAppComponent]
})
export class AppModule {
}