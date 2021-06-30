
//Function that redirects user to the signin page.
function signin(){
	window.location.assign("index.html");
	
	return false;
}

function signup(){

	let firstname = document.getElementById("firstname").value;
	let lastname = document.getElementById("lastname").value;
	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;

	if(firstname || lastname || email || password){
		let user = {"userFirstName": firstname, "userLastName": lastname, "userEmail": email, "userPassword": password};
		let xmlhttp;

		xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var response = this.responseText;

				if(response == "User insertion succeeded"){
					swal({
						title: "Success!",
						text: "New user created",
						icon: "success",
					})
					signin();
				}else if(response == "User insertion failed"){
					swal({
						title: "Error!",
						text: "Something went wrong",
						icon: "error",
					})
				}
			}
		};

		xmlhttp.open("POST", "http://localhost:8080/ride/api/signup/add", true);
		xmlhttp.setRequestHeader("Content-Type", "application/json");
		xmlhttp.send(JSON.stringify(user));
	}else{
		swal({
			title: "Error!",
			text: "Please fill in the open field(s)",
			icon: "error",
		})
		return;
	}

	return false;
}

