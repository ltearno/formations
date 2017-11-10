import {
    Component,
    Input,
    Output,
    EventEmitter
} from '@angular/core';

@Component({
    selector: 'tree',
    template: `
        <div>{{nbFruits}} fruits</div>
        <button *ngIf='chooseTree && nbFruits>0' (click)='onChoose()'>Choisir</button>`
})
export class TreeComponent {
    @Input() nbFruits: number;

    @Input() chooseTree: boolean;

    @Output() chosen = new EventEmitter<null>();

    onChoose() {
        this.chosen.emit();
    }
}