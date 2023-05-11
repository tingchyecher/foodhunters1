//Global variable - to store the image object
let storeImage = ""


//When user clicks on 'Save Item':
//1) store all the inputs into variables
//2) do validation
//3) calls a function from the productController.js to access the API to add items to the database


//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {


  // Prevent default action of the Form submission
  event.preventDefault();


  //1) Select the inputs
   console.log("hello world")
    let postUser = document.querySelector(`#postUser`).value;
    let postMessage = document.querySelector(`#postMessage`).value;
    let postImage = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif"
    let postDate = new Date();


  //Browser security will not be able to track/store the actual path of where you choose your image
  // C:/Users/Desktop/t-shirt_new.jpg
  //C:\fakepath\t-shirt_new.jpg
  //console.log(document.querySelector('#newItemImageFile').value + '\n' + "Hello world");


//  const imageUrl = document.querySelector('#newItemImageFile').value.replace("C:\\fakepath\\", "");




//      Do the Validation code here
   if (postUser == "" || postMessage == "") {
         alert("Please fill in all required fields.");
         return;
     }


  // 3)  calls a function from the productController.js to access the API to add items to the database
  addPost(postMessage, postDate);  //arguments


});




// select file input
const input = document.querySelector('#newItemImageFile');
// add event listener
input.addEventListener('change', () => {
  storeImage = input.files[0]; //array of files for us to access
});
