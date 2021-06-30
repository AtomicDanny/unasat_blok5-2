

function loadCars() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let carsList = JSON.parse(this.responseText);
            // console.log(carsList);
            let car = ' <ul class="w3-ul w3-card-4"> ';

            carsList.reverse();

            for (let index = 0; index < carsList.length; index++) {
                car +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + carsList[index].id + ' onclick="edit(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + carsList[index].id + ' onclick="remove(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Delete</button> ' +

                    ' <div class="w3-bar-item"> ' +
                    ' <span> Brand: ' +  carsList[index].brand.name  + ' </span><br> ' +
                    ' <span> Classification: ' +  carsList[index].classification.classification  + ' </span> <br>' +
                    ' <span> Model: ' +  carsList[index].model  + ' </span><br>' +
                    ' <span> Bouwjaar: ' +  carsList[index].bouwjaar  + ' </span><br> ' +
                    ' <span> Prijs per Dag: SRD ' +  carsList[index].price  + ' </span> ' +
                    ' </div> ';
            }
            car += "</ul>";
            document.getElementById("klanten").innerHTML = car;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/car/getCars", true);
    xmlhttp.send();
}

function edit(id){
    var car = {"id":id};

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            let response = JSON.parse(this.responseText);
            console.log(response);

            document.getElementById("id").value = response.id;
            document.getElementById("brand").value = response.brand.id;
            document.getElementById("class").value = response.classification.id;
            document.getElementById("model").value = response.model;
            document.getElementById("bouwjaar").value = response.bouwjaar;
            document.getElementById("price").value = response.price;

            document.getElementById("submitButton").innerHTML = "Update Car";
        }
    };

    xmlhttp.open("POST", "http://localhost:8080/ride/api/car/getSingleCar", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(car));
}

function add() {

    let brand = document.getElementById("brand").value;
    let classi = document.getElementById("class").value;
    let model = document.getElementById("model").value;
    let bouwjaar = document.getElementById("bouwjaar").value;
    let price = document.getElementById("price").value;

    // var car = { "brand" : parseFloat(brand), "classification" : parseFloat(classi), "model" : model, "bouwjaar": bouwjaar, "price":price};
    var car ={"brand":{"id":brand,"name":null,"origin":null},"classification":{"id":classi,"classification":null},"model":model,"bouwjaar":bouwjaar,"price":price};
    // console.log(car)

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            Swal.fire({
                title: "Success!",
                text: "New Car Created",
                icon: "success",
            });
            clearFields();
            loadCars();
        }
    };

    xmlhttp.open("POST", "http://localhost:8080/ride/api/car/insertCar", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(car));
}


function update(){

    let id = document.getElementById("id").value;
    let brand = document.getElementById("brand").value;
    let classi = document.getElementById("class").value;
    let model = document.getElementById("model").value;
    let bouwjaar = document.getElementById("bouwjaar").value;
    let price = document.getElementById("price").value;

    // var car = { "id":parseFloat(id), "brand_id" : null, "classification_id" : null, "model" : model, "bouwjaar": parseFloat(bouwjaar),"price":price};
    var car ={"id":id,"brand":{"id":brand,"name":null,"origin":null},"classification":{"id":classi,"classification":null},"model":model,"bouwjaar":bouwjaar,"price":price};
    // console.log(car)

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let response = this.responseText;
            console.log(response)

            if (response=="Car updated") {
                Swal.fire({
                    title: "Success!",
                    text: "Car Updated",
                    icon: "success",
                });
                loadCars();
                clearFields();
                document.getElementById("submitButton").innerHTML = "Create Car";
            }else{
                Swal.fire({
                    title: "Error!",
                    text: response,
                    icon: "error",
                });
            }
        }
    };

    xmlhttp.open("PUT", "http://localhost:8080/ride/api/car/update", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(car));
}

function remove(id){
    // console.log(id);
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
            let car = { "id" : id }
            let xmlhttp;
            xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    Swal.fire(
                        "Success!",
                        "Car removed!",
                        "success",
                    )
                    loadCars();
                }
            };

            xmlhttp.open("DELETE", "http://localhost:8080/ride/api/car/delete", true);
            xmlhttp.setRequestHeader("Content-Type", "application/json");
            xmlhttp.send(JSON.stringify(car));
        }
    })

}

function updateOrCreate(){
    let brand = document.getElementById("brand").value;
    let classi = document.getElementById("class").value;
    let model = document.getElementById("model").value;
    let bouwjaar = document.getElementById("bouwjaar").value;
    let price = document.getElementById("price").value;

    if(brand && classi && model && bouwjaar && price) {
        (document.getElementById("submitButton").innerHTML == 'Create Car') ? add() : update();
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
    document.getElementById("brand").value = "";
    document.getElementById("class").value = "";
    document.getElementById("model").value = "";
    document.getElementById("bouwjaar").value = "";
    document.getElementById("price").value="";
    document.getElementById("submitButton").innerHTML = "Create Car";
}

