function log(message) {
    $("#log").append(`<p>${message}</p>`);
}

function displayObject(o) {
    let msg = 'Informations on object ' + o + '<br/>';

    let prototype = Object.getPrototypeOf(o);

    msg += `Type: ${typeof o}<br/>`;

    msg += `Constructor: ${o.constructor}<br/>`;

    msg += `JSONified: ${JSON.stringify(o)}<br/>`;

    msg += 'Prototype chain:<br/>';
    while (prototype) {
        let constr = prototype.constructor;
        prototype = Object.getPrototypeOf(prototype);

        msg += constr + '<br/>';
    }

    log(msg);
}

$(function () {
    function ConstructeurA() {
        this.weight = 110;
    }

    ConstructeurA.prototype.test = function () {
        console.log("Hello!");
    };

    let o = new ConstructeurA();
    o.test();

    displayObject(o);
    displayObject("coucou");
	displayObject(true);
	displayObject({id:3});
});