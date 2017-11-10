import {Component, Input} from "@angular/core";
import {Licorne, Power} from "./app.model";
import {DataService} from "./data.service";

@Component({
  selector: 'licorne-editor',
  template: `
<form>
  <span>{{licorne.id}}</span>
  <label>Name: <input type="text" required name="name" [(ngModel)]="licorne.name" #name></label><br/>
  
  <label>Power:
    <select required name="power" [(ngModel)]="licorne.power" #power>
      <option *ngFor="let power of powers" [ngValue]="power">{{power.name}}</option>
    </select>
  </label>
  
  <div>
    Name input CSS classes : {{name.classList}}<br/>
    Power input CSS classes : {{power.classList}}<br/>
  </div>
</form>`,
  styleUrls: ['./licorne-editor.component.css']
})
export class LicorneEditorComponent {
  @Input() licorne: Licorne

  powers: Power[]

  constructor(private dataService: DataService) {
    dataService.powers().then(powers => this.powers = powers as Power[])
  }
}
