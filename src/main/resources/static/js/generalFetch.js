console.log("General fetch page");

const options = {
    method: 'GET',
    headers: {
        'X-RapidAPI-Key': '51a7ae301cmshd85759a11e2df76p1b973cjsn10d5cc0b2dc9',
        'X-RapidAPI-Host': 'videogames-news2.p.rapidapi.com'
    }
};

fetch('https://videogames-news2.p.rapidapi.com/videogames_news/search_news?query=GTA', options)
    .then(response => response.json())
    .then(response => console.log(response))
    .catch(err => console.error(err));