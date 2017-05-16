import {
    Component,
    Input,
    Output,
    EventEmitter
} from '@angular/core';

@Component({
    selector: 'trees',
    template: `
        <tree *ngFor='let nbFruits of fruits; let i=index;' [nbFruits]='nbFruits' [chooseTree]='chooseTree' (chosen)='onChosen(i)'></tree>`
})
export class TreesComponent {
    @Input() fruits: number[];

    @Input() chooseTree: boolean;

    @Output() chosen = new EventEmitter<number>();

    onChosen(treeIndex) {
        this.chosen.emit(treeIndex);
    }
}