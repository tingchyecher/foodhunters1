//Global variable - to store the image object
//let attachFile = ""


//When user clicks on 'Save Item':
//1) store all the inputs into variables
//2) do validation
//3) calls a function from the productController.js to access the API to add items to the database


//Add an 'onsubmit' event listener for productform to add a product
let newPostForm = document.getElementById('newPostForm');
newPostForm.addEventListener('submit', (event) => {


  // Prevent default action of the Form submission
  event.preventDefault();


  //1) Select the inputs
   console.log("hello world")
    let postUser = ""/*document.querySelector(`#postUser`).innerHTML = "Jean" document.querySelector(`#postUser`).value;*/
     // Hard-Code first!
    let content = document.querySelector(`#postMessage`).value;
    let postImage = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif"
    let postDate = new Date();
    let idTopic = 1;
    let idUsers = Math.floor(Math.random() * (1004 - 1001 + 1) ) + 1001;


  //Browser security will not be able to track/store the actual path of where you choose your image
  // C:/Users/Desktop/t-shirt_new.jpg
  //C:\fakepath\t-shirt_new.jpg
  //console.log(document.querySelector('#attachmentFile').value + '\n' + "Hello world");


//  const imageUrl = document.querySelector('#attachmentFile').value.replace("C:\\fakepath\\", "");




//      Do the Validation code here
//   if (postUser == "" || content == "") {
//         alert("Please fill in all required fields.");
//         return;
//     }


  // 3)  calls a function from the productController.js to access the API to add items to the database
  addPost(content, postDate,  idTopic, idUsers);  //arguments


//// select file input
//const input = document.querySelector('#attachmentFile');
//// add event listener
//input.addEventListener('change', () => {
//  storeImage = input.files[0]; //array of files for us to access
});
