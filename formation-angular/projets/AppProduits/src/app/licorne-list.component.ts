import {Component, Input, Output, EventEmitter} from "@angular/core"
import {Licorne} from "./app.model"

@Component({
  selector: 'licorne-list',
  template: `
<div>
  <licorne-display *ngFor="let licorne of licornes" (click)="onClick(licorne)" [licorne]="licorne" [class.selected]="selectedLicorne==licorne"></licorne-display>
</div>`,
  styles: [`
.selected {
  color: coral;
}`]
})
export class LicorneListComponent {
  @Input() licornes: Licorne[]

  @Output() selection: EventEmitter<Licorne> = new EventEmitter()

  selectedLicorne: Licorne

  onClick(licorne) {
    this.selectedLicorne = licorne
    this.selection.emit(licorne)
  }
}
