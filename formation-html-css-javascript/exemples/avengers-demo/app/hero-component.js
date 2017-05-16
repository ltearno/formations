import chainPrototypes from './chainPrototypes';
import GraphicComponent from './graphic-component';
import HeroFormComponent from './hero-form-component';

/** HeroComponent */

function HeroComponent() {
    GraphicComponent.call(this, `
        <div class='hero-component'>
            <div component-id='display'>
                <span class='hero-name' component-id='name'></span> aka <span component-id='alias'></span><br/>
                <span component-id='nbLikes'></span> likes, <span component-id='nbDislikes'></span> dislikes<br/>
                <button component-id='delete'>Delete</button>
                <button component-id='select'>Edit</button>
            </div>
            <div component-id='form'>
            </div>
        </div>`);

    this.hero = null;

    this.form = new HeroFormComponent();
    this.elements.form.appendChild(this.form.rootElement());

    this.elements.delete.addEventListener('click', () => this.onDelete && this.onDelete());
    this.elements.select.addEventListener('click', () => {
        this.form.setHero(this.hero);
        this.elements.display.style.display = 'none';
        this.elements.form.style.display = null;

        this.form.focus();
    });

    this.form.onCancel = () => {
        this.elements.display.style.display = null;
        this.elements.form.style.display = 'none';
    };

    this.form.onValidate = (data) => {
        this.onSave && this.onSave(data);

        this.elements.display.style.display = null;
        this.elements.form.style.display = 'none';
    };

    this.elements.display.style.display = null;
    this.elements.form.style.display = 'none';
}

chainPrototypes(HeroComponent, GraphicComponent);

HeroComponent.prototype.setHero = function (hero) {
    this.hero = hero;
}

HeroComponent.prototype.updateDisplay = function () {
    for (let propertyName of ['name', 'alias', 'nbLikes', 'nbDislikes'])
        this.elements[propertyName].innerText = this.hero[propertyName];
}

export default HeroComponent;