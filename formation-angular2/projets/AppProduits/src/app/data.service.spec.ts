import {TestBed} from "@angular/core/testing";
import {DataService} from "./data.service";
import {LogService} from "./log.service";
describe("Une test suite de base", () => {
  it('test 1', () => {
    TestBed.configureTestingModule({
      providers: [DataService, LogService]
    })

    let dataService = TestBed.get(DataService)

    let powers = dataService.powers()

    expect(powers.length).toBeGreaterThan(0)
  })
})
