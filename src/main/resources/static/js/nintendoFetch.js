console.log("here is the info for Nintedo News!");

const options = {
    method: 'GET',
    headers: {
        'X-RapidAPI-Key': XRapidAPIKey,
        'X-RapidAPI-Host': 'nintendo-news1.p.rapidapi.com'
    }
};

fetch('https://nintendo-news1.p.rapidapi.com/news/ign?p=1', options)
    .then(response => response.json())
    .then(response => console.log(response))
    .catch(err => console.error(err));
