/*
    PostController perform action to the forum posts to be displayed


    (1) Display all posts to be retrieved from the back-end
    (2) Add posts to the post list (send the new project to the back-end)
    --- edit an existing post detail
    -- remove an existing post from the post list
*/


//(1) Hardcode 2 post items - replace it later to be retrieved from the back-end
//Product Details: name, description, imageURL, style, price
//image URL: http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif


//(1) Create the objects for the Posts - replace it later to be retrieved from the back-end.  Dummy posts.


const post1 = {
    userName: "MrPositive",
    userImageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
    postContent: "Today is a good day",
    postDate: "1/3/2023",
    postTime: "2050 hrs",
};

const post2 = {
    userName: "MrNegative",
    userImageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
    postContent: "Today is a bad day",
    postDate: "1/3/2023",
    postTime: "2100 hrs"
};

const post3 = {
    userName: "MrNuetral",
    userImageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
    postContent: "Today is an alright day",
    postDate: "1/3/2023",
    postTime: "0800 hrs"
};

// 2) Push the post objects into an array

const postList = [];
postList.push(post1, post2, post3);


// 3) Display all posts when user launch the forumHawker.html page
// const displayPost= () => {}

function displayPost() {
    let display = "";
    for (let i = 0; i < postList.length; i++) {
        display +=
            `
        <div class="posting padLeft30 padTop20 ">
        <div class="card-group row col-2 col-sm-2">
            <div class="card text-center " style="width: 18rem;">
                <img id="postImg"  src="${postList[i].userImageURL}" alt="">
                <div class="card-body">
                    <h5 id="postUsername" class="card-title">${postList[i].userName}</h5>
                    <p class="card-text">Member</p>
                </div>
                <div class="card-footer mobile-screen">
                    <small class="text-body-secondary">Last updated 3 mins ago</small>
                </div>
            </div>
        </div>

        <div class=" card-group row col-10 col-sm-10 align-right h-100 d-inline-block">
            <div class="postgroup">
                <ul class="list-group">
                    <li id="postdate" class="list-group-item">${postList[i].postDate}</li>
                    <!-- <li class="list-group-item"> -->
                
                  <p id="postContent" class="form-control" aria-label="With textarea">${postList[i].postContent}</p>
                
                    <li class="list-group-item">
                    <div class="p-1 d-grid gap-2 d-flex justify-content-end">
                        <button class="post-button btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#replymodal" data-bs-whatever="@reply" type="button"><svg
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-reply" viewBox="0 0 16 16">
                                <path
                                    d="M6.598 5.013a.144.144 0 0 1 .202.134V6.3a.5.5 0 0 0 .5.5c.667 0 2.013.005 3.3.822.984.624 1.99 1.76 2.595 3.876-1.02-.983-2.185-1.516-3.205-1.799a8.74 8.74 0 0 0-1.921-.306 7.404 7.404 0 0 0-.798.008h-.013l-.005.001h-.001L7.3 9.9l-.05-.498a.5.5 0 0 0-.45.498v1.153c0 .108-.11.176-.202.134L2.614 8.254a.503.503 0 0 0-.042-.028.147.147 0 0 1 0-.252.499.499 0 0 0 .042-.028l3.984-2.933zM7.8 10.386c.068 0 .143.003.223.006.434.02 1.034.086 1.7.271 1.326.368 2.896 1.202 3.94 3.08a.5.5 0 0 0 .933-.305c-.464-3.71-1.886-5.662-3.46-6.66-1.245-.79-2.527-.942-3.336-.971v-.66a1.144 1.144 0 0 0-1.767-.96l-3.994 2.94a1.147 1.147 0 0 0 0 1.946l3.994 2.94a1.144 1.144 0 0 0 1.767-.96v-.667z" />
                            </svg> Reply</button>

                        <button class="post-button btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#linkmodal" data-bs-whatever="" type="button"> <svg
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-share" viewBox="0 0 16 16">
                                <path
                                    d="M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5zm-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3z" />
                            </svg> Share</button>

                        <button class="post-button btn btn-primary btn-sm" data-bs-toggle="" data-bs-target="#"
                            data-bs-whatever="@post" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                                height="16" fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                                <path
                                    d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z" />
                            </svg> Like</button>
                         
                    </div>
                    </div>
                    </li>
                    </ul>
                </div>
            </div>
                    `

    }

    document.querySelector("#forumPost").innerHTML = display;
}


// 4) Add new post to the forumHawker.html when user click on the submit button on forumHawker.html

function addPost() {
    console.log("hello world")
    let postUser = document.querySelector(`#postUser`).value;
    let postMessage = document.querySelector(`#postMessage`).value;
    let postImage = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif"
    let postDate = new Date();
    // let postTime = " 2000 hrs";
    // let postAttachment = document.querySelector(`#attachment`).files;

    // Input validation
    if (postUser == "" || postMessage == "") {
        alert("Please fill in all required fields.");
        return;
    }

        console.log(postUsername)
    const postItem = {
        userName: postUser,
        userImageURL: postImage,
        postContent: postMessage,
        postDate: postDate,
        // postTime: postTime,
        // postAttachment: postAttachment,
    }
    
    postList.unshift(postItem)
    console.log(postList);
    displayPost();
}


function displayReply() {
    let display = "";
    for (let i = 0; i < postList.length; i++) {
        display +=
            `
        <div class="posting padLeft30 padTop20 ">
        <div class="card-group row col-2 col-sm-2">
            <div class="card text-center " style="width: 18rem;">
                <img id="postImg"  src="${postList[i].userImageURL}" alt="">
                <div class="card-body">
                    <h5 id="postUsername" class="card-title">${postList[i].userName}</h5>
                    <p class="card-text">Member</p>
                </div>
                <div class="card-footer mobile-screen">
                    <small class="text-body-secondary">Last updated 3 mins ago</small>
                </div>
            </div>
        </div>

        <div class=" card-group row col-10 col-sm-10 align-right h-100 d-inline-block">
            <div class="postgroup">
                <ul class="list-group">
                    <li id="postdate" class="list-group-item">${postList[i].postDate}</li>
                    <!-- <li class="list-group-item"> -->
                
                  <p id="postContent" class="form-control" aria-label="With textarea">${postList[i].postContent}</p>
                
                    <li class="list-group-item">
                    <div class="p-1 d-grid gap-2 d-flex justify-content-end">
                        <button class="post-button btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#replymodal" data-bs-whatever="@reply" type="button"><svg
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-reply" viewBox="0 0 16 16">
                                <path
                                    d="M6.598 5.013a.144.144 0 0 1 .202.134V6.3a.5.5 0 0 0 .5.5c.667 0 2.013.005 3.3.822.984.624 1.99 1.76 2.595 3.876-1.02-.983-2.185-1.516-3.205-1.799a8.74 8.74 0 0 0-1.921-.306 7.404 7.404 0 0 0-.798.008h-.013l-.005.001h-.001L7.3 9.9l-.05-.498a.5.5 0 0 0-.45.498v1.153c0 .108-.11.176-.202.134L2.614 8.254a.503.503 0 0 0-.042-.028.147.147 0 0 1 0-.252.499.499 0 0 0 .042-.028l3.984-2.933zM7.8 10.386c.068 0 .143.003.223.006.434.02 1.034.086 1.7.271 1.326.368 2.896 1.202 3.94 3.08a.5.5 0 0 0 .933-.305c-.464-3.71-1.886-5.662-3.46-6.66-1.245-.79-2.527-.942-3.336-.971v-.66a1.144 1.144 0 0 0-1.767-.96l-3.994 2.94a1.147 1.147 0 0 0 0 1.946l3.994 2.94a1.144 1.144 0 0 0 1.767-.96v-.667z" />
                            </svg> Reply</button>

                        <button class="post-button btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#linkmodal" data-bs-whatever="" type="button"> <svg
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-share" viewBox="0 0 16 16">
                                <path
                                    d="M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zM11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5zm-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3zm11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3z" />
                            </svg> Share</button>

                        <button class="post-button btn btn-primary btn-sm" data-bs-toggle="" data-bs-target="#"
                            data-bs-whatever="@post" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                                height="16" fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                                <path
                                    d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z" />
                            </svg> Like</button>
                         
                    </div>
                    </div>
                    </li>
                    </ul>
                </div>
            </div>
                    `

    }

    document.querySelector("#forumPost").innerHTML = display;
}


function replyPost() {
    console.log("hello world")
    let replyUser = document.querySelector(`#replyUser`).value;
    let replyMessage = document.querySelector(`#replyMessage`).value;
    let postImage = "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif"
    let replyDate = new Date();
    // let postTime = " 2000 hrs";
    // let postAttachment = document.querySelector(`#attachment`).files;

    // Input validation
    if (replyUser == "" || replyMessage == "") {
        alert("Please fill in all required fields.");
        return;
    }

        console.log(postUsername)
        const postItem = {
        userName: replyUser,
        userImageURL: postImage,
        postContent: replyMessage,
        postDate: replyDate,
        // postTime: postTime,
        // postAttachment: postAttachment,
    }
    
    postList.unshift(postItem)
    console.log(postList);
    displayReply();
}


displayPost();

// *** For like button ***
// const likeBtn = document.querySelector(".like__btn");
// let likeIcon = document.querySelector("#icon"),
//   count = document.querySelector("#count");

// let clicked = false;


// likeBtn.addEventListener("click", () => {
//   if (!clicked) {
//     clicked = true;
//     likeIcon.innerHTML = `<i class="fas fa-thumbs-up"></i>`;
//     count.textContent++;
//   } else {
//     clicked = false;
//     likeIcon.innerHTML = `<i class="far fa-thumbs-up"></i>`;
//     count.textContent--;
//   }
// });

// addPost(`${postUsername}`, "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",`${postMessage}`, "10/4/2023", " 2000 hrs")


// addPost("Mr. X", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "This is another post", "10/4/2023", "1049 hrs")

// addPost(`${userName}`, "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",`${postContent}`, "10/4/2023", " 2000 hrs")

// addPost("Blue T-Shirt", "This is a blue shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower Print", "Price", "35")

// addPost("Blue T-Shirt", "This is a blue shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower Print", "Price", "35")


