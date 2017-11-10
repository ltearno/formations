import {Component, Input} from "@angular/core"
import {Licorne} from "./app.model"

@Component({
  selector: 'licorne-display',
  template: `
<div *ngIf="licorne">
  <span>{{licorne.id}}</span>
  <span>{{licorne.name}}</span>
  <span>{{licorne.power?.name}}</span>
</div>
<span *ngIf="!licorne">Aucune licorne à afficher</span>`
})
export class LicorneDisplayComponent {
  @Input() licorne: Licorne
}
