/** Code de base pour les composants graphiques */

function GraphicComponent(template) {
    // création du noeud DOM en fonction de la template
    let wrapper = document.createElement('div');
    wrapper.innerHTML = template.trim();
    if (wrapper.childElementCount != 1)
        console.error(`error in template : ${template}`)
    this.el = wrapper.firstChild;

    // extraction automatique des noeuds identifiés dans la template
    this.elements = {};
    wrapper.querySelectorAll('[component-id]').forEach((element) => {
        this.elements[element.getAttribute('component-id')] = element;
    })
}

GraphicComponent.prototype.rootElement = function () {
    return this.el;
}

export default GraphicComponent;