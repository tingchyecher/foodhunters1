//Global variable - to store the image object
//let attachFile = ""


//When user clicks on 'Save Item':
//1) store all the inputs into variables
//2) do validation
//3) calls a function from the productController.js to access the API to add items to the database


//Add an 'onsubmit' event listener for productform to add a product
let newReplyForm = document.getElementById('newReplyForm');
newReplyForm.addEventListener('submit', (event) => {


  // Prevent default action of the Form submission
  event.preventDefault();


  //1) Select the inputs
   console.log("hello world")
    let replyUser = ""/*document.querySelector(`#postUser`).innerHTML = "Jean" document.querySelector(`#replyUser`)
//    .value;*/

    let content = document.querySelector(`#replyMessage`).value;
    let postImage = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif"
    let postDate = new Date();
    let idTopic = 1;
    let idUsers = Math.floor(Math.random() * (1005 - 1001 + 1) ) + 1001;
    console.log(idUsers);


  //Browser security will not be able to track/store the actual path of where you choose your image
  // C:/Users/Desktop/t-shirt_new.jpg
  //C:\fakepath\t-shirt_new.jpg
  //console.log(document.querySelector('#attachmentFile').value + '\n' + "Hello world");


//  const imageUrl = document.querySelector('#attachmentFile').value.replace("C:\\fakepath\\", "");


//      Do the Validation code here
//   if (replyUser == "" || content == "") {
//         alert("Please fill in all required fields.");
//         return;
//     }


  // 3)  calls a function from the productController.js to access the API to add items to the database
  replyPost(content, postDate,  idTopic, idUsers/*, imageUrl, storeImage*/);  //arguments


// select file input
//const input = document.querySelector('#attachmentFile');
//// add event listener
//input.addEventListener('change', () => {
//  storeImage = input.files[0]; //array of files for us to access
});
