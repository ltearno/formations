import {Component, ViewEncapsulation} from '@angular/core';
import {Licorne, Power} from "./app.model";
import {DataService} from "./data.service";
import {LogService} from "./log.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  powers: Power[]

  licornes: Licorne[]

  selectedLicorne: Licorne

  constructor(private dataService: DataService,
              private logService: LogService) {
    dataService.powers().then(powers => {
      this.powers = powers as Power[]
    })
    this.licornes = dataService.licornes()
  }

  onSelectedLicorne(licorne) {
    this.logService.log(licorne)

    this.selectedLicorne = licorne
  }

  addLicorne() {
    this.logService.log('AJOUT DE LICORNE')

    let licorne = new Licorne(-1, 'Name', null)

    this.licornes.push(licorne)
    this.selectedLicorne = licorne
  }
}
