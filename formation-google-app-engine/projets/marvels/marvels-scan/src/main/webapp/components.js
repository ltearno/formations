/**
 * Dependency Injector
 *
 * let injector = createInjector();
 * injector.register('token', value or factory function) => registers a value provider
 * injector('token') => returns injected object
 * injector.createChild() => returns a new child injector
 */
let createInjector = (function () {
    function createInjector(parent) {
        let injector = (token) => injector.inject(token);
        parent && (injector.parent = parent);
        Object.setPrototypeOf(injector, injectorPrototype);
        return injector;
    }

    let injectorPrototype = {
        inject: function (token) {
            let factory = this.factories && this.factories.get(token);
            return (factory && factory(this)) || (this.parent && this.parent(token));
        },
        register: function (token, valueOrFactory, forceValue = false) {
            if (!this.factories)
                this.factories = new Map();
            this.factories.set(token, (forceValue || (typeof valueOrFactory === 'function')) ? valueOrFactory : () => valueOrFactory);
            if (!(token in this))
                this[token] = () => this.inject(token);
        },
        create: function () {
            return createInjector(this);
        }
    };

    return createInjector;
})();

/**
 * Ajax request
 */
let request = function (url, method = 'GET', data = null) {
    return new Promise((resolve, reject) => {
        let r = new XMLHttpRequest();
        r.onreadystatechange = () => {
            if (r.readyState == 4) {
                if (r.status == 200) {
                    let result = JSON.parse(r.responseText);
                    resolve(result);
                }
                else {
                    reject(`error ${r.status} ${r.responseText}`);
                }
            }
        }
        r.open(method, url, true);
        if (data)
            r.setRequestHeader('Content-Type', 'application/json');
        r.send(data ? JSON.stringify(data) : null);
    });
};

/**
 * Manage a list and bound items
 */
class ListBinder {
    constructor(list, onEnter, onMoved, onLeave) {
        this.list = list || [];
        this.old = [];
        this.bound = new Map();
        this.onEnter = onEnter || null;
        this.onMoved = onMoved || null;
        this.onLeave = onLeave || null;
    }

    update(newData) {
        if (newData != undefined)
            this.list = newData || [];

        for (let i = 0; i < this.old.length; i++) {
            let oldElement = this.old[i];
            let indexInNew = this.list.indexOf(oldElement);
            if (indexInNew < 0) {
                let boundElement = this.bound.get(oldElement);
                this.bound.delete(oldElement);
                this.old.splice(i, 1);
                i--;

                this.onLeave && this.onLeave(i, oldElement, boundElement);
            }
        }

        for (let i in this.list) {
            let curElement = this.list[i];
            let positionInOld = this.old.indexOf(curElement);

            if (positionInOld < 0) {
                let boundElement = this.onEnter && this.onEnter(i, curElement);
                this.bound.set(curElement, boundElement);
            }
            else if (positionInOld !== i) {
                let boundElement = this.bound.get(curElement);
                this.onMoved && this.onMoved(positionInOld, i, curElement, boundElement);
            }
        }

        this.old = this.list.slice();
    }
}

/**
 * Base graphic component
 */
class Component {
    constructor(template) {
        let wrapper = document.createElement('div');
        wrapper.innerHTML = template.trim();
        if (wrapper.childElementCount != 1)
            console.error(`error in template : ${template}`)
        this.el = wrapper.firstChild;

        this.e = this.elements = {};
        this.el.querySelectorAll('[x-id]').forEach((element) => {
            this.elements[element.getAttribute('x-id')] = element;
        });
    }

    rootElement() {
        return this.el;
    }

    setData(data) {
        this.data = data;

        if ('update' in this)
            this.update();
    }
}

class CommentComponent extends Component {
    constructor(injector) {
        super(`
            <div class="character-comment">
                <span x-id="author"></span> on <span x-id="date"></span><br/>
                <cite x-id="content"></cite>
                <button x-id="removeButton">Remove</button>
            </div>`);

        this.e.removeButton.addEventListener('click', () => {
            this.onRemove && this.onRemove();
        });
    }

    update() {
        this.e.content.innerText = this.data.content;
        this.e.author.innerText = this.data.userAlias;
        this.e.date.innerText = this.data.date;
        this.e.removeButton.hidden = !this.data.isMine;
    }
}

class MarvelComponent extends Component {
    constructor(injector) {
        super(`
            <div class="marvel-character">
                <img x-id='picture'></img>
                <h2 x-id='name'></h2>
                <div x-id='description'></div>
                <div x-id="commentZone">
                    <div x-id='comments'></div>
                    <form x-id="form">
                        <label><input type="text" x-id="content"/></label>
                        <button>Add</button>
                    </form>
                </div>
                <div x-id='links'></div>
            </div>`);

        this.injector = injector;

        this.comments = [];

        this.commentComps = new ListBinder(this.comments);
        this.commentComps.onEnter = (position, comment) => {
            let comp = new CommentComponent(this.injector);
            this.e.comments.appendChild(comp.rootElement());
            comp.setData(comment);

            comp.onRemove = () => {
                let idx = this.comments.indexOf(comment);
                if (idx >= 0) {
                    this.injector.dataService().removeComment(this.comments[idx].commentKey);

                    this.comments.splice(idx, 1);
                    this.commentComps.update();
                }
            };

            return comp;
        };
        this.commentComps.onLeave = (position, comment, comp) => {
            comp.onRemove = null;
            comp.rootElement().remove();
        };

        this.e.form.addEventListener('submit', (event) => {
            event.preventDefault();
            event.stopPropagation();

            this.injector.dataService().addComment(this.data.id, this.e.content.value);

            this.comments.push({
                content: this.e.content.value,
                isMine: true,
                userAlias: 'You',
                date: new Date()
            });

            this.commentComps.update();
        });
    }

    update() {
        this.e.name.innerText = this.data && this.data.name;
        this.e.description.innerText = this.data && this.data.description;
        if (this.data && this.data.thumbnail && this.data.thumbnail.extension && this.data.thumbnail.path) {
            this.e.picture.src = `${this.data.thumbnail.path}.${this.data.thumbnail.extension}`;
            console.log(`set picture ${this.e.picture.src}`);
        }
        if (this.data && this.data.urls)
            this.e.links.innerHTML = this.data.urls.map(url => `<a href='${url.url}' target="_blank">${url.type.toUpperCase()}</a>`).join(' - ');

        this.injector.dataService().getCharacterComments(this.data.id)
            .then((data) => {
                this.comments = data;
                this.commentComps.update(this.comments);
            });
    }
}

class ApplicationComponent extends Component {
    constructor(injector) {
        super(`
            <div class="application">
                <div x-id="buttonBar">
                    <button x-id="prevButton">Previous</button>
                    <button x-id="nextButton">Next</button>
                    Search : <input x-id="search" type="text"/>
                </div>
                <div x-id='characters'></div>
            </div>`);

        this.offset = 0;

        this.injector = injector;

        this.marvelsComps = new ListBinder();
        this.marvelsComps.onEnter = (i, character) => {
            let marvelComp = new MarvelComponent(this.injector);
            marvelComp.setData(character);
            this.elements.characters.appendChild(marvelComp.rootElement());
            return marvelComp;
        };
        this.marvelsComps.onLeave = (i, character, marvelComp) => {
            marvelComp.rootElement().remove();
        };

        this.e.prevButton.addEventListener('click', () => {
            this.offset -= this.data.length;
            if (this.offset < 0)
                this.offset = 0;

            this.start();
        });

        this.e.nextButton.addEventListener('click', () => {
            this.offset += this.data.length;

            this.start();
        });

        let timerId = null;
        this.e.search.addEventListener('input', () => {
            if (timerId)
                clearTimeout(timerId);

            timerId = setTimeout(() => {
                this.search(this.e.search.value);
            }, 300);
        });
    }

    update() {
        this.marvelsComps.update(this.data);
    }

    start() {
        this.injector.dataService().getCharacters(this.offset).then((data) => {
            this.setData(data.data);
        });
    }

    search(name) {
        this.injector.dataService().searchCharacters(name).then((data) => {
            this.setData(data.data);
        });
    }
}