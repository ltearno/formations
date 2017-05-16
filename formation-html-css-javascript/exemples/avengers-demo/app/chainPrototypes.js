/** Fonction d'aide pour chainer des prototypes */

function chainPrototypes(childConstructor, baseConstructor) {
    childConstructor.prototype = Object.create(baseConstructor.prototype);
    childConstructor.prototype.constructor = childConstructor;
}

export default chainPrototypes;