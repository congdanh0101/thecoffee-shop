const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
const button = document.getElementById('btn2');
let message = "";
// button.addEventListener('click',function (message){
// 	alert(message);
// })
function alermess(message)
{
	alert(message);
}
signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});