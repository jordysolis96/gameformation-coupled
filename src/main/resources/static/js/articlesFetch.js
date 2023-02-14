console.log("article fetch api");

const options = {
    method: 'GET'
};


fetch('https://www.gamespot.com/api/releases/?api_key=' + GameSpotAPIKey, options)
    .then(response => response.json())
    .then(response => console.log(response))
    .catch(err => console.error(err));



