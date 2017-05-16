function ClasseMere(texte) {
    this.attributA = texte;
}

ClasseMere.prototype.mere = function () {
    alert('ClasseMere ' + this.attributA);
}

var mere = new ClasseMere('memere');

// crée un nouvel objet, avec ClasseMere.prototype comme prototype
// exécution de ClasseMere, avec l'objet comme this
// retourne l'objet créé





function ClasseFille(texte) {
    ClasseMere.call(this, texte);
}

// crée un objet avec ClasseMere.prototype comme prototype
ClasseFille.prototype = Object.create(ClasseMere.prototype);
ClasseFille.prototype.constructor = ClasseFille;

ClasseFille.prototype.test = function () {
    alert('Je suis une instance de classe fille, je vais appeler "mere()"');

    this.mere();
}

var fille = new ClasseFille('testFille');






function ClassePetiteFille() {
    ClasseFille.call(this, 'petite');
}

ClassePetiteFille.prototype = Object.create(ClasseFille.prototype);
ClassePetiteFille.prototype.constructor = ClassePetiteFille;

var petiteFille = new ClassePetiteFille();