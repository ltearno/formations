import {
    Component,
    Input,
    Output,
    EventEmitter
} from '@angular/core';

@Component({
    selector: 'crow',
    template: `
        <div class='cases'>
            <div *ngFor='let i of cases;' class='case'>
                <img *ngIf='position==i' class='crow' src='assets/crow.png'/>
            </div>
        </div>`,
    styles: [
        '.crow { width:8em; height: 8em;}',
        '.cases { display: flex; flex-flow: row nowrap; height:10em; background-size:cover; background-position: 50% 60%; background-image:url(assets/landscape.jpg); }',
        '.case { border: 1px solid black; flex: 1 1; }'
    ]
})
export class CrowComponent {
    @Input() position: number;

    @Input() set nbCases(value: number) {
        this.cases = [];
        for (let i = 0; i < value; i++)
            this.cases.push(i);
    }

    couleurCase(i) {
        let nbCases = this.cases.length;

        let rouge = Math.floor(((nbCases - 1 - i) * 255) / (nbCases - 1));
        let vert = Math.floor((i * 255) / (nbCases - 1));

        return `rgb(${rouge}, ${vert}, 0)`;
    }

    cases = [];
}