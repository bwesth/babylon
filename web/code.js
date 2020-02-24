/* jshint esversion: 6 */
// var input = document.getElementById('searchbox');
// input.addEventListener("keyup", function (event) {
//     if (event.keyCode === 13) {
//         event.preventDefault();
//         document.getElementById('searchbutton').click();
//     };
// });
// document.getElementById('searchbutton').onclick = () => {
//     fetch("/search?q=" + document.getElementById('searchbox').value)
//         .then((response) => response.json())
//         .then((data) => {
//             if (data.length > 0) {
//                 document.getElementById("responsesize").innerHTML =
//                     "<p>" + data.length + " websites retrieved</p>";
//                 let results = data.map((page) =>
//                     `<li><a class='searchItem' href='${page.url}' target='viewFrame'>
//                     <span class='title'>${page.title}</span>
//                     <span class='url'>${page.url}</span>
//                     </a></li>`)
//                     .join("\n");
//                 document.getElementById("urllist").innerHTML = `<ul>${results}</ul>`;
//             } else {
//                 document.getElementById("responsesize").innerHTML = "<p>No website contains the query word.</p>";
//                 document.getElementById("urllist").innerHTML = "<p>Perchance your query is mis-'spell'ed?<br/>Try asking a higher level wizard for help <br/>(Try this one)=>></p>";
//                 document.getElementById("viewFrame").setAttribute("src", "https://pure.itu.dk/portal/da/persons/troels-bjerre-lund(cb040481-6f22-4137-9788-d26db2dd1e21).html");
//             }
//         });
// };

document.getElementById('loginbutton').onclick = () => {
    fetch("/login?u="+ document.getElementById('username').value+"p="+document.getElementById('password'))
    .then((response) => response.json())
    .then((data) => {
        if (data===1) {
            window.location.replace("index.html")
        }
        });
};