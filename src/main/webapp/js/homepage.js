loadCars();
loadCust();
loadL();
function loadCars() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let carsList = JSON.parse(this.responseText);

            var car = 0;

            for (let index = 0; index < carsList.length; index++) {
                car++;
            }
            console.log(car)
            document.getElementById("cars").innerHTML = "Total Cars: "+ car;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/car/getCars", true);
    xmlhttp.send();
}

function loadCust() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let klantenList = JSON.parse(this.responseText);
            let customer = 0;


            for (let index = 0; index < klantenList.length; index++) {
                customer++;
            }
            document.getElementById("client").innerHTML = "Total Customers: "+customer;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/klanten/getKlanten", true);
    xmlhttp.send();
}

function loadL() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let registerList = JSON.parse(this.responseText);
            // console.log(registerList);
            let grandtotal = 0;
            let record=0;


            for (let index = 0; index < registerList.length; index++) {
                grandtotal += registerList[index].total;
                record++;
            }
            document.getElementById("total").innerHTML = 'Grandtotal sales SRD '+grandtotal;
            document.getElementById("records").innerHTML = "Total Rental Out: "+record;
        }
    };
    xmlhttp.open("GET", "http://localhost:8080/ride/api/register/getAllRegister", true);
    xmlhttp.send();
}