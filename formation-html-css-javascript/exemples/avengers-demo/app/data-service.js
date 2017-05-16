import rawData from './db-raw';

/*
public 2c4c69c4f2c2fd59cdbe9dc9429d254e
private 952fb13aeeb2ea14103811d46d3f48461c161918
*/

// https://gateway.marvel.com:443/v1/public/characters?limit=1000&apikey=2c4c69c4f2c2fd59cdbe9dc9429d254e&ts=1&hash=e90e51a3678e8564a6715b97ec7236b2

/** Service de données */
let dataService = {
    nextId: 333,

    database: rawData.data.results.map((entry) => ({
        id: entry.id,
        name: entry.name,
        alias: entry.description,
        nbLikes: 0,
        nbDislikes: 0
    })),

    databaseOld: [
        {
            id: 33,
            name: 'Zorro',
            alias: 'Z',
            nbLikes: 3,
            nbDislikes: 5
        },

        {
            id: 34,
            name: 'Youplouplou',
            alias: 'Youyou',
            nbLikes: 5,
            nbDislikes: 3
        },

        {
            id: 35,
            name: 'Batman',
            alias: 'Bibou',
            nbLikes: 5,
            nbDislikes: 3
        },

        {
            id: 36,
            name: 'Superman',
            alias: 'Shanti',
            nbLikes: 5,
            nbDislikes: 3
        },

        {
            id: 37,
            name: 'Thor',
            alias: 'Le roi du marteau',
            nbLikes: 5,
            nbDislikes: 3
        }
    ],

    fetchAll: function () {
        return new Promise((resolve, reject) => {
            resolve(this.database);
        });
    },

    postHero: function (data) {
        return new Promise((resolve, reject) => {
            data.id = this.nextId++;
            data.nbLikes = 0;
            data.nbDislikes = 0;
            data = Object.assign({}, data);
            this.database.push(data);
            resolve(data);
        });
    },

    putHero: function (hero) {
        return new Promise((resolve, reject) => {
            let existing = this.database.find(e => e.id === hero.id);
            Object.assign(existing, hero);
            resolve(existing);
        });
    },

    deleteHero: function (id) {
        return new Promise((resolve, reject) => {
            let existing = this.database.find(e => e.id === id);
            if (existing)
                this.database.splice(this.database.indexOf(existing), 1);

            resolve(true);
        });
    }
};

export default dataService;