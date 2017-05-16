import {Power, Licorne} from "./app.model";
import {LogService} from "./log.service";
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';

const POWERS: Power[] = [
  new Power(1, "Flies"),
  new Power(2, "Simws"),
  new Power(3, "Walks")
]

const LICORNES: Licorne[] = [
  new Licorne(1, "Toto", POWERS[0]),
  new Licorne(2, "Titi", POWERS[0]),
  new Licorne(3, "Tutu", POWERS[0]),
]

@Injectable()
export class DataService {
  constructor(private logService: LogService, private http: Http) {
  }

  powers() {
    this.logService.log("GET POWERS")
    return this.http.get('assets/toto.json')
      .toPromise()
      .then(response => response.json().data as Power[])
      .catch(err => console.log(err))
  }

  licornes() {
    this.logService.log("GET LICORNES")
    return LICORNES
  }
}
