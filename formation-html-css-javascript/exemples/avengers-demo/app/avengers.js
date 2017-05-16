import dataService from './data-service';
import HeroesListComponent from './heroes-list-component';

/** Application initialisation */

window.addEventListener('load', () => {
    let component = new HeroesListComponent(dataService);
    document.body.appendChild(component.rootElement());
    component.load();
});