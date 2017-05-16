import chainPrototypes from './chainPrototypes';
import GraphicComponent from './graphic-component';

/** HeroFormComponent */

function HeroFormComponent() {
    GraphicComponent.call(this, `
        <form component-id='form'>
            <label>Name : <input component-id='name'/></label><br/>
            <label>Alias : <input component-id='alias'/></label><br/>
            <button component-id='validate'>Validate</button>
            <button type='button' component-id='cancel'>Cancel</button>
        </form>`);

    this.elements.form.addEventListener('submit', (event) => {
        event.preventDefault();
        event.stopPropagation();

        this.onValidate && this.onValidate({
            name: this.elements.name.value,
            alias: this.elements.alias.value
        });
    });

    this.elements.cancel.addEventListener('click', () => { this.onCancel && this.onCancel() });
}

chainPrototypes(HeroFormComponent, GraphicComponent);

HeroFormComponent.prototype.setHero = function (hero) {
    this.elements.name.value = hero ? hero.name : '';
    this.elements.alias.value = hero ? hero.alias : '';
}

HeroFormComponent.prototype.focus = function () {
    this.elements.name.focus();
}

export default HeroFormComponent;