"use strict";

function displayDetails() {
    var o = document.getElementById("origin").value;
    document.getElementById("o").innerHTML = o;

    var d = document.getElementById("destination").value;
    document.getElementById("d").innerHTML = d;

    var df = document.getElementById("dateFrom").value;
    document.getElementById("df").innerHTML = df;

    var dt = document.getElementById("dateTo").value
    document.getElementById("dt").innerHTML = dt;

    addDetail();
    getCountdown();
}

function thingsToDo() {
    window.open("https://www.tripadvisor.co.uk/?fid=88fcde45-5a56-4c19-be9c-1718ed412c74", "_blank");
}

function getAllD() {
    getOrigin();
    getDestination();
    getDateFrom()
    getDateTo()
}

function getDateTo() {
  axios
      .get('http://localhost:8080/details/getAll')
      .then((res) => {
        showDateTo(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
}

const dateToDetails = document.getElementById("dt");
function showDateTo(dateT) {
  dateToDetails.innerHTML = "";
  for (let x of dateT) {
    const newDT = document.createElement("span");
    newDT.innerHTML = x.dateTo;
    dateToDetails.appendChild(newDT);
  }
}

function getDateFrom() {
  axios
      .get('http://localhost:8080/details/getAll')
      .then((res) => {
        showDateFrom(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
}

const dateFromDetails = document.getElementById("df");
function showDateFrom(dateF) {
  dateFromDetails.innerHTML = "";
  for (let x of dateF) {
    const newDF = document.createElement("span");
    newDF.innerHTML = x.dateFrom;
    dateFromDetails.appendChild(newDF);
  }
}

function getDestination() {
    axios
        .get('http://localhost:8080/details/getAll')
        .then((res) => {
            showDestination(res.data);
            console.log(res.data);
        })
        .catch((error) => {
            console.log(error);
        })
}

const destinationDetails = document.getElementById("o");
function showDestination(trip) {
    destinationDetails.innerHTML = "";
    for (let x of trip) {
        const newD = document.createElement("span");
        newD.innerHTML = x.destination;
        destinationDetails.appendChild(newD);
    }
}

function getOrigin() {
    axios
        .get('http://localhost:8080/details/getAll')
        .then((res) => {
            showOrigin(res.data);
            console.log(res.data);
        })
        .catch((error) => {
            console.log(error);
        })
}

const tripDetails = document.getElementById("d");
function showOrigin(trip) {
    tripDetails.innerHTML = "";
    for (let x of trip) {
        const newO = document.createElement("span");
        newO.innerHTML = x.origin;
        tripDetails.appendChild(newO);
    }
}


function addDetail() {
    axios
        .post('http://localhost:8080/details/add', {
            origin: document.getElementById("origin").value,
            destination: document.getElementById("destination").value,
            dateFrom: document.getElementById("dateFrom").value,
            dateTo: document.getElementById("dateTo").value,
        })
        .then(res => showOutput(res))
        .catch(error => console.log(error));
}

function updateDetail() {
    axios
        .patch('http://localhost:8080/details/update/1', {
            origin: document.getElementById("origin").value,
            destination: document.getElementById("destination").value,
            dateFrom: document.getElementById("dateFrom").value,
            dateTo: document.getElementById("dateTo").value,
        })
        .then(res => showOutput(res))
        .catch(error => console.log(error));
}

function deleteDetail() {
    axios
        .delete('http://localhost:8080/details/delete/1')
        .then(alert("The details have been deleted"))
        .catch(error => console.log(error));
}


//   countdown ----->
var target_date = new Date().getTime() + (dateSeconds()); // set the countdown date
var days, hours, minutes, seconds; // variables for time units

var countdown = document.getElementById("tiles");


setInterval(function () {
    getCountdown();
}, 1000);

function getCountdown() {

    // find the amount of "seconds" between now and target
    var current_date = new Date().getTime();
    var seconds_left = (target_date - current_date) / 1000;

    days = pad(parseInt(seconds_left / 86400));
    seconds_left = seconds_left % 86400;

    hours = pad(parseInt(seconds_left / 3600));
    seconds_left = seconds_left % 3600;

    minutes = pad(parseInt(seconds_left / 60));
    seconds = pad(parseInt(seconds_left % 60));

    // format countdown string + set tag value
    countdown.innerHTML = "<span>" + days + "</span><span>" + hours + "</span><span>" + minutes + "</span><span>" + seconds + "</span>";
}

function pad(n) {
    return (n < 10 ? '' : '') + n;
}

function dateSeconds() {
    var _initial = document.getElementById("dateFrom").value;
    var fromTime = new Date(_initial);
    var toTime = new Date();

    var differenceTravel = fromTime.getTime() - toTime.getTime();
    var seconds = Math.floor(differenceTravel);
    return seconds;
}


