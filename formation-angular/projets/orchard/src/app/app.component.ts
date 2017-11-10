import { Component } from '@angular/core';

interface GameState {
  crowPosition: number;
  fruits: number[];
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nbStepsCrow = 5;

  state: GameState = {
    crowPosition: this.nbStepsCrow - 1,
    fruits: [4, 4, 4, 4]
  }

  chooseTree = false;
  winner = null;

  message = '';

  canRollDie() {
    return !this.chooseTree;
  }

  dieNbFaces() {
    return this.state.fruits.length + 2;
  }

  onDieRolled(dieValue: number) {
    console.log(`de: ${dieValue}`);

    // le dé a été lancé
    if (dieValue == 0) {
      this.message = 'LE CROW AVANCE';
      // le crow avance
      this.state.crowPosition--;
      // le corbeau a-t-il gagné ?
      if (this.state.crowPosition == 0)
        this.winner = 'LE CORBEAU';
    }
    else if (dieValue == 1) {
      this.message = 'CHOISISSEZ UN ARCRE';
      // l'utilisateur doit choisir un arbre
      this.chooseTree = true;
    }
    else {
      // retirer le fruit
      let treeIndex = dieValue - 2;

      if (this.state.fruits[treeIndex] > 0) {
        this.message = 'RETRAIT DU FRUIT DE LARBRE ' + (treeIndex + 1);
        this.state.fruits[treeIndex]--;
        this.testPlayerWins();
      }
      else {
        this.message = 'QUEL DOMMAGE CET ARBRE EST DEJA VIDE';
      }
    }
  }

  onChooseTree(treeIndex) {
    // arbre a été choisi
    this.state.fruits[treeIndex]--;
    this.testPlayerWins();
    this.chooseTree = false;
  }

  testPlayerWins() {
    if (this.state.fruits.every(tree => tree == 0))
      this.winner = 'VOUS';
  }

  restart() {
    this.winner = null;
    this.state = {
      crowPosition: this.nbStepsCrow - 1,
      fruits: [4, 4, 4, 4]
    };
    this.chooseTree = false;

    this.message = 'C est reparti';
  }
}
