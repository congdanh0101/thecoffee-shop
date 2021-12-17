const endpoint = "https://api.mysupership.vn/v1/partner/areas/province";
const endpoint2 = "https://api.mysupership.vn/v1/partner/areas/district?province=79";
const endpoint3 = "https://api.mysupership.vn/v1/partner/areas/commune?district=";
let city;
let district;
let ward;
// const promise = fetch(endpoint);
// promise.then((response) => {
//         return response.json();
//     })
//     .then((data) => {
//         city = data.results;
//         console.log(city);
//         console.log(city[0].code)
//     })
var outputdistrict = `<option value="">Quận/Huyện</option>`;
var haha = "'";
var hehe = '"';


const promise2 = fetch(endpoint2);
promise2.then((response) => {
    return response.json();
}).then((data) => {
    district = data.results;
    const abcdistrict = document.querySelector("#district");
    // option value = '{"code":"123","name":"Quan 1"}' > haha < /option>
	var districtSelected = document.getElementById("district").options[document.getElementById("district").selectedIndex].value;
    for (var i = 0; i < Object.keys(district).length; i++) {
    	if (district[i].name == districtSelected) {
    		outputdistrict += `<option value='{"code":"` + district[i].code + `","name":"` + district[i].name + `"}' selected>` + district[i].name + `</option>`;
    	} else {
	        outputdistrict += `<option value='{"code":"` + district[i].code + `","name":"` + district[i].name + `"}'>` + district[i].name + `</option>`;
	        // outputdistrict += '<option value="' + district[i].code + '">' + district[i].name + '</option>';
        }
    }
    abcdistrict.innerHTML = outputdistrict;
})

// function select(){
//     const main = document.getElementById("select");
//     if(main){
//         const option = document.createElement('option');

//     }
// }

function myFunction() {
    var asd = document.getElementById("district").value;
    if (asd != "") {
        console.log(asd);
        var x = JSON.parse(asd);
        console.log(x);
        var endpoint4 = "https://api.mysupership.vn/v1/partner/areas/commune?district=" + x.code;
        console.log(endpoint4);
        const promise4 = fetch(endpoint4);
        var output = "";
        promise4.then((respone) => {
            return respone.json();
        }).then((data) => {
            ward = data.results;
            const abc = document.querySelector("#ward");
            for (var i = 0; i < Object.keys(ward).length; i++) {

                output += `<option value='{"code":"` + ward[i].code + `","name":"` + ward[i].name + `"}'>` + ward[i].name + `</option>`;
            }
            abc.innerHTML = output;
        })
    } else {
        const abc = document.querySelector("#ward");
        abc.innerHTML = `<option></option>`
    }


}


// const double = document.querySelector("#double").value;
// var xyz = JSON.parse(double)

// console.log(xyz.foo)