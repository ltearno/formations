import { Component, Inject } from '@angular/core'

@Component({
    selector: 'angular-app',
    template: `
    <h1>Hello</h1>
    <div>{{user.nom}}</div>
    <h3>{{user.id}}</h3>`
})
export class AngularAppComponent {
    user = { id: 3, nom: "toto" }
}