import {
    Component,
    Input,
    Output,
    EventEmitter
} from '@angular/core';

@Component({
    selector: 'die',
    template: `<button (click)='rollDie()'>Lancer le dé à {{nbFaces}} faces</button>`
})
export class DieComponent {
    @Input() nbFaces: number;

    @Output() diceRolled = new EventEmitter<number>();

    rollDie() {
        let value = Math.floor(Math.random() * this.nbFaces);

        this.diceRolled.emit(value);
    }
}