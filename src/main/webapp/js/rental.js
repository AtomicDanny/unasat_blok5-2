
loadCars();
loadCustomer();
loadOptional();
function loadCars() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let carsList = JSON.parse(this.responseText);
            // console.log(carsList);
            // let car = ' <select id="selectCar" class="w3-select" style="width:90%"> ';
            let car ='';
            carsList.reverse();

            for (let index = 0; index < carsList.length; index++) {
                car +=
                    '<option data-price='+carsList[index].price+' value='+carsList[index].id+'>'+ carsList[index].brand.name +' '+ carsList[index].model +' ('+ carsList[index].bouwjaar+') SRD '+ carsList[index].price+' </option>';
            }
            // car += "</select>";
            document.getElementById("selectCar").innerHTML = car;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/car/getCars", true);
    xmlhttp.send();
}


function loadCustomer() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let klantenList = JSON.parse(this.responseText);
            // console.log(carsList);
            let customer = '';

            klantenList.reverse();

            for (let index = 0; index < klantenList.length; index++) {
                customer +=
                    '<option value='+klantenList[index].id+'>'+ klantenList[index].naam +' </option>';
            }
            // customer += "</select>";
            document.getElementById("selectCustomer").innerHTML = customer;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/klanten/getKlanten", true);
    xmlhttp.send();
}

function loadOptional() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let klantenList = JSON.parse(this.responseText);
            console.log(klantenList);
            let decor = '';

            // klantenList.reverse();

            for (let index = 0; index < klantenList.length; index++) {
                decor +=
                    '<option data-price='+klantenList[index].price+' value='+klantenList[index].id+'>'+ klantenList[index].name +' SRD '+ klantenList[0].price +' </option>';
            }
            // customer += "</select>";
            document.getElementById("optional").innerHTML = decor;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/decorator/getDecorators", true);
    xmlhttp.send();
}

function loadList() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let registerList = JSON.parse(this.responseText);
            console.log(registerList);
            let car = ' <ul class="w3-ul w3-card-4"> ';


            registerList.reverse();

            for (let index = 0; index < registerList.length; index++) {
                car +=
                    ' <li class="w3-bar"> ' +

                    // ' <button id= ' + registerList[index].id + ' onclick="edit(this.id)" ' +
                    // ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +
                    //
                    ' <button id=' + registerList[index].id + ' onclick="remove(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Delete</button> ' +

                    ' <div class="w3-bar-item"> ' +
                    ' <span> Brand: ' +  registerList[index].car.brand.name  + ' </span><br> ' +
                    ' <span> Classification: ' +  registerList[index].car.classification.classification  + ' </span> <br>' +
                    ' <span> Model: ' +  registerList[index].car.model  + ' </span><br>' +
                    ' <span> Renter: ' +  registerList[index].klant.naam  + ' </span><br> ' +
                    ' <span> Tel No.: ' +  registerList[index].klant.telNummer  + ' </span><br> ' +
                    ' <span> From: ' +  new Date(registerList[index].start_date).toISOString().substring(0, 10)+ ' </span><br> ' +
                    ' <span> To: ' +  new Date(registerList[index].end_date).toISOString().substring(0, 10)  + ' </span><br> ' +
                    ' <span> Optionals: ' +  registerList[index].decoratorList[0].name  + ' </span><br> ' +
                    ' <span> Paid: SRD ' +  registerList[index].total + ' </span> ' +
                    ' </div> ';
                // console.log(registerList[index].decoratorList[0].name)
            }
            car += "</ul>";
            document.getElementById("klanten").innerHTML = car;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/register/getAllRegister", true);
    xmlhttp.send();
}



function add() {

    let car = document.getElementById("selectCar").value;
    let customer = document.getElementById("selectCustomer").value;
    let start = document.getElementById("start_date").value;
    let end = document.getElementById("end_date").value;
    let dec = document.getElementById("optional").value;
    let total = document.getElementById("total").value;

    var reg = { "car" : {"id":car,"brand":null,"classification":null,"model":null,"bouwjaar":null,"price":null}, "klant" : {"id":customer,"naam":null,"geslacht":null,"telNummer":null,"email":null}, "start_date" : start, "end_date": end, "total":total};
    // var reg = { "car" : {"id":car,"brand":null,"classification":null,"model":null,"bouwjaar":null,"price":null}, "klant" : {"id":customer,"naam":null,"geslacht":null,"telNummer":null,"email":null}, "start_date" : start, "end_date": end, "decoratorList":{"id":dec,"name":null,"price":null}, "total":total};

    console.log(reg)

    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            Swal.fire({
                title: "Success!",
                text: "New Registration",
                icon: "success",
            });
            clearFields();
            loadList();
        }
    };

    xmlhttp.open("POST", "http://localhost:8080/ride/api/register/add", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(reg));
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
            let data = { "id" : id }
            let xmlhttp;
            xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    Swal.fire(
                        "Success!",
                        "Record removed!",
                        "success",
                    )
                    loadList();
                }
            };

            xmlhttp.open("DELETE", "http://localhost:8080/ride/api/register/delete", true);
            xmlhttp.setRequestHeader("Content-Type", "application/json");
            xmlhttp.send(JSON.stringify(data));
        }
    })

}

function updateOrCreate(){
    let car = document.getElementById("selectCar").value;
    let customer = document.getElementById("selectCustomer").value;
    let start = document.getElementById("start_date").value;
    let end = document.getElementById("end_date").value;
    let total = document.getElementById("total").value;

    if(car && customer && start && end && total) {
        (document.getElementById("submitButton").innerHTML == 'Register') ? add() : '';
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
    document.getElementById("selectCustomer").value = "";
   document.getElementById("start_date").value= "";
   document.getElementById("end_date").value= "";
    document.getElementById("total").value= "";
    document.getElementById("submitButton").innerHTML = "Register";
}

