import chainPrototypes from './chainPrototypes';
import GraphicComponent from './graphic-component';
import HeroFormComponent from './hero-form-component';
import HeroComponent from './hero-component';
import GameComponent from './game-component';

/** HeroesListComponent */

function HeroesListComponent(dataService) {
    GraphicComponent.call(this, `
        <div class='hero-list-component'>
            <h1>Liste des héros</h1>
            <div>Recherche: <input component-id='search'/></div>
            <div component-id='easter'></div>
            <div component-id='heroesList'></div>
            <button component-id='newHeroButton'>New hero</button>
            <div component-id='heroForm'></div>
        </div>`);

    this.dataService = dataService;

    this.game = null;

    this.heroForm = new HeroFormComponent();
    this.elements.heroForm.appendChild(this.heroForm.rootElement());

    this.displayedHeroes = {};

    this.elements.newHeroButton.addEventListener('click', () => this.creationMode());

    this.resetCreationForm();

    this.heroForm.onValidate = (data) => this.validateForm(data);
    this.heroForm.onCancel = () => this.resetCreationForm();

    this.elements.search.addEventListener('input', (event) => {
        let search = this.elements.search.value;

        if (search != '') {
            if (search == 'MAGIC') {
                if (!this.game) {
                    this.game = new GameComponent();
                    this.elements.easter.appendChild(this.game.rootElement());
                }
            }
            else {
                if (this.game) {
                    this.game.stop();
                    this.game.rootElement().remove();
                    this.game = null;
                }
            }

            search = search.toLowerCase();

            for (let id in this.displayedHeroes) {
                if (this.displayedHeroes[id].hero.name.toLowerCase().indexOf(search) >= 0)
                    this.displayedHeroes[id].rootElement().style.display = null;
                else
                    this.displayedHeroes[id].rootElement().style.display = "none";
            }
        }
        else {
            for (let id in this.displayedHeroes)
                this.displayedHeroes[id].rootElement().style.display = null;
        }
    });
}

chainPrototypes(HeroesListComponent, GraphicComponent);

HeroesListComponent.prototype.resetCreationForm = function () {
    this.elements.heroForm.style.display = 'none';
    this.elements.newHeroButton.style.display = null;
}

HeroesListComponent.prototype.creationMode = function () {
    this.elements.heroForm.style.display = null;
    this.elements.newHeroButton.style.display = 'none';

    this.heroForm.setHero(null);
    this.heroForm.focus();
}

HeroesListComponent.prototype.validateForm = function (data) {
    this.dataService.postHero(data).then((hero) => {
        this.addHeroToDisplay(hero);
        this.resetCreationForm();
    });
}

HeroesListComponent.prototype.load = function () {
    this.dataService.fetchAll().then(heroes => {
        this.elements.heroesList.innerHTML = '';
        this.displayedHeroes = {};

        for (let hero of heroes)
            this.addHeroToDisplay(hero);
    });
}

HeroesListComponent.prototype.addHeroToDisplay = function (hero) {
    let heroComponent = this.displayedHeroes[hero.id];

    if (!heroComponent) {
        heroComponent = new HeroComponent();
        heroComponent.onDelete = () => this.deleteHero(hero);
        heroComponent.onSave = (data) => this.updateHero(hero, data);

        this.displayedHeroes[hero.id] = heroComponent;
        this.elements.heroesList.appendChild(heroComponent.rootElement());
    }

    heroComponent.setHero(hero);
    heroComponent.updateDisplay();
}

HeroesListComponent.prototype.updateHero = function (hero, data) {
    let combined = Object.assign({}, hero);
    Object.assign(combined, data);

    this.dataService.putHero(combined)
        .then((hero) => {
            this.addHeroToDisplay(hero);
        });
}

HeroesListComponent.prototype.deleteHero = function (hero) {
    this.dataService.deleteHero(hero.id)
        .then((result) => {
            if (result) {
                this.displayedHeroes[hero.id].rootElement().remove();
                delete this.displayedHeroes[hero.id];
            }
        })
}

export default HeroesListComponent;