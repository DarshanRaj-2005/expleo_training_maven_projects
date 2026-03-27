var title = document.getElementById("title")
var author = document.getElementById("author")
var genre = document.getElementById("genre")
var pages = document.getElementById("pages")
var bookCover = document.getElementById("book-cover")

var dateAdded = document.getElementById("date-added")
var ratingOutput = document.getElementById("rating-output")

var addButton = document.getElementById("add-btn")

var booksNav = document.getElementById("books-nav")

var booksPara = document.getElementsByClassName("book-para")

addButton.addEventListener('click', (e) => {
    e.preventDefault();

    booksNav.innerHTML += `
    <article>
        <h3>${title.value}</h3>

        <figure>
          <img src="${URL.createObjectURL(bookCover.files[0])}" width="250" height="350">
          <figcaption>20th Anniversary Edition</figcaption>
        </figure>

        <dl>
          <dt><b>Author</b></dt>
          <dd>${author.value}</dd>

          <dt><b>Genre</b></dt>
          <dd>${genre.value}</dd>

          <dt><b>Date Added</b></dt>
          <dd>${dateAdded.value}</dd>

          <dt><b>Rating</b></dt>
          <dd>★★★★☆(${ratingOutput.value}/5)</dd>

          <dt><b>Status</b></dt>
          <dd>Currently Reading</dd>
        </dl>

        <p class="book-para">${booksPara.value}</p>
    </article>
    `;
});







