

function loadKlanten() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let klantenList = JSON.parse(this.responseText);
            let klant = ' <ul class="w3-ul w3-card-4"> ';

            klantenList.reverse();

            for (let index = 0; index < klantenList.length; index++) {
                klant +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + klantenList[index].id + ' onclick="edit(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + klantenList[index].id + ' onclick="remove(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Delete</button> ' +

                    ' <div class="w3-bar-item"> ' +
                    ' <span> Naam: ' +  klantenList[index].naam  + ' </span><br> ' +
                    ' <span> Geslacht: ' +  klantenList[index].geslacht  + ' </span> <br>' +
                    ' <span> Tel No.: ' +  klantenList[index].telNummer  + ' </span><br>' +
                    ' <span> E-mail: ' +  klantenList[index].email  + ' </span> ' +
                    ' </div> ';
            }
            klant += "</ul>";
            document.getElementById("klanten").innerHTML = klant;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/klanten/getKlanten", true);
    xmlhttp.send();
}

function edit(id){
    var klant = {"id":id};

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            let response = JSON.parse(this.responseText);

            document.getElementById("id").value = response.id;
            document.getElementById("naam").value = response.naam;
            document.getElementById("geslacht").value = response.geslacht;
            document.getElementById("tel").value = response.telNummer;
            document.getElementById("email").value = response.email;

            document.getElementById("submitButton").innerHTML = "Update Klant";
        }
    };

    xmlhttp.open("POST", "http://localhost:8080/ride/api/klanten/getKlant", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(klant));
}

function add() {

    let naam = document.getElementById("naam").value;
    let geslacht = document.getElementById("geslacht").value;
    let telNummer = document.getElementById("tel").value;
    let email = document.getElementById("email").value;

    var klant = { "naam" : naam, "geslacht" : geslacht, "telNummer" : telNummer, "email": email};

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            Swal.fire({
                title: "Success!",
                text: "New User Created",
                icon: "success",
            });
            clearFields();
            loadKlanten();
        }
    };

    xmlhttp.open("POST", "http://localhost:8080/ride/api/klanten/add", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(klant));
}


function update(){

    let id = document.getElementById("id").value;
    let naam = document.getElementById("naam").value;
    let geslacht = document.getElementById("geslacht").value;
    let telNummer = document.getElementById("tel").value;
    let email = document.getElementById("email").value;

    let klant = {"id" : id, "naam" : naam, "geslacht" : geslacht, "telNummer" : telNummer, "email":email};

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
                Swal.fire({
                    title: "Success!",
                    text: "Klant Updated",
                    icon: "success",
                });
                loadKlanten();
                clearFields();
                document.getElementById("submitButton").innerHTML = "Create Client";
        }
    };

    xmlhttp.open("PUT", "http://localhost:8080/ride/api/klanten/update", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(klant));
}

function remove(id){
    console.log(id);
    Swal.fire({
            title: "Are you sure?",
            text: "You will not be able to recover this!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: '#DD6B55',
            confirmButtonText: 'Yes, I am sure!',
            cancelButtonText: "No, cancel it!",
        }).then((result)=>{
            if(result.isConfirmed){
                let klant = { "id" : id }
                let xmlhttp;
                xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        Swal.fire(
                            "Success!",
                            "Klant removed!",
                            "success",
                        )
                        loadKlanten();
                    }
                };

                xmlhttp.open("DELETE", "http://localhost:8080/ride/api/klanten/delete", true);
                xmlhttp.setRequestHeader("Content-Type", "application/json");
                xmlhttp.send(JSON.stringify(klant));
            }
    })

}

function updateOrCreate(){
    let naam = document.getElementById("naam").value;
    let geslacht = document.getElementById("geslacht").value;
    let telNummer = document.getElementById("tel").value;
    let email = document.getElementById("email").value;

    if(naam && geslacht && telNummer && email) {
        (document.getElementById("submitButton").innerHTML == 'Create Client') ? add() : update();
    }else{
        Swal.fire({
            title: "Error!",
            text: "Please fill in the given fields",
            icon: "error",
        })
        }
    }

    function clearFields(){
        document.getElementById("id").value = "";
        document.getElementById("naam").value = "";
        document.getElementById("geslacht").value = "";
        document.getElementById("tel").value = "";
        document.getElementById("email").value = "";
        document.getElementById("submitButton").innerHTML = "Create Client";
    }

