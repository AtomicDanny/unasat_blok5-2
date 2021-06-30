
//Function that redirects user to the signup page.
function signup(){
	window.location.assign("signup.html");
	
	return false;
}

function login(){

	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;

	if(email == "" || password == ""){
		swal({
			title: "Error!",
			text: "Please fill in the open field(s)",
			icon: "error",
		})
		return;
	}

	let credentials = {"userEmail": email, "userPassword": password};

	let xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST", "http://localhost:8080/ride/api/login/authentication" , true);
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let response = this.responseText;

			if(response == "true"){
				localStorage.clear();
				localStorage.setItem('email', email);
				window.location.assign("homepage.html");
			}else{
				swal({
					title: "Error!",
					text: "Incorrect email/password!",
					icon: "error",
				})
			}
		}
	};
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	xmlhttp.send(JSON.stringify(credentials));
}