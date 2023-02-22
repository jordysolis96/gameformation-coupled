console.log("General fetch page");

var tbody = document.getElementById('news');
const options = {
    method: 'GET',
    headers: {
        'X-RapidAPI-Key': XRapidAPIKey,
        'X-RapidAPI-Host': 'videogames-news2.p.rapidapi.com'
    }
};

let searchBtn = document.getElementById("search-btn");
let search = document.forms.search.input;
searchBtn.addEventListener("click", function (){
    console.log(search.value);
fetch('https://videogames-news2.p.rapidapi.com/videogames_news/search_news?query=' + search.value, options)
    .then(response => response.json())
    // .then(response => console.log(response))
    .then(response => {
        console.log(response);
        // <div className="card mb-3">
        //     <img src="..." className="card-img-top" alt="...">
        //         <div className="card-body">
        //             <h5 className="card-title">Card title</h5>
        //             <p className="card-text">This is a wider card with supporting text below as a natural lead-in to
        //                 additional content. This content is a little bit longer.</p>
        //             <p className="card-text"><small className="text-muted">Last updated 3 mins ago</small></p>
        //         </div>
        // </div>
        tbody.innerHTML = renderNewsCollection(response);

    })
    .catch(err => console.error(err));
});


function renderNews(news) {
    console.log("news rending")
    var html = '<div class="card mb-3">';
    html += '<img src="' + news.image + '" class="card-img-top" id="img" alt="...">';
    html += '<h4 class = "card-title">' + news.title + " " + news.date + '</h4>';
    html += '<p class = "card-title">' + news.description + '</p>';
    html += '</div>';
    console.log(news.image);
    return html;
}

function renderNewsCollection(newsCollection) {
    var html = '';
    for (var i = 0; i < newsCollection.length; i++) {
        html += renderNews(newsCollection[i]);
    }
    return html;
}





