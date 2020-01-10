var pois = [
    {
      id: 1,
      name: "Big Ben",
      link: "https://www.google.com"
    },
    {
      id: 2,
      name: "london bridge",
      link: "https://www.google.com"
    }
  ];
  
  $.each(pois, function(i, poi) {
    appendToUsrTable(poi);
  });
  
  $("form").submit(function(e) {
    e.preventDefault();
  });
  
  $("form#addPoi").submit(function() {
    var poi = {};
    
    var nameInput = $('input[name="name"]').val().trim();
    
    var linkInput = $('input[name="link"]').val().trim();
    if (nameInput && linkInput) {
      $(this).serializeArray().map(function(data) {
        poi[data.name] = data.value;
      });
      var lastPoi = pois[Object.keys(pois).sort().pop()];
      poi.id = lastPoi.id + 1;
  
      addPoi(poi);
    } else {
      alert("All fields must have a valid value.");
    }
  });
  
  function addPoi(poi) {
    pois.push(poi);
    appendToUsrTable(poi);
    addPois();
    clearPoiInputs();
  }
  
  function editPoi(id) {
    pois.forEach(function(poi, i) {
      if (poi.id == id) {
        $(".modal-body").empty().append(`
                  <form id="updatePoi" action="">
                      <label for="name">Name</label>
                      <input class="form-control" type="text" name="name" value="${poi.name}"/>
                      <label for="address">Address</label>
                      <input class="form-control" type="url" name="link" pattern="https://.*" value="${poi.link}"/>
                     
              `);
        $(".modal-footer").empty().append(`
                      <button type="button" type="submit" class="btn btn-primary" onClick="updatePoi(${id})">Save changes</button>
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  </form>
              `);
      }
    });
  }
  
  function deletePoi(id) {
    var action = confirm("Are you sure you want to delete this poi?");
    var msg = "Poi deleted successfully!";
    pois.forEach(function(poi, i) {
      if (poi.id == id && action != false) {
        pois.splice(i, 1);
        $("#poiTable #poi-" + poi.id).remove();
        console.log(id);
        console.log(poi.id);
        deletePoi(id);
        flashMessage(msg);
      }
    });
  }


  
  function updatePoi(id) {
    var msg = "Poi updated successfully!";
    var poi = {};
    poi.id = id;
    pois.forEach(function(poi, i) {
      if (poi.id == id) {
        $("#updatePoi").children("input").each(function() {
          var value = $(this).val();
          var attr = $(this).attr("name");
          if (attr == "name") {
            poi.name = value;
          } else if (attr == "link") {
            poi.address = value;
          } 
        });
        pois.splice(i, 1);
        pois.splice(poi.id - 1, 0, poi);
        $("#poiTable #poi-" + poi.id).children(".poiData").each(function() {
          var attr = $(this).attr("name");
          if (attr == "name") {
            $(this).text(poi.name);
          } else {
            $(this).text(poi.link);
          }
        });
        $(".modal").modal("toggle");
        flashMessage(msg);
      }
    });
  }
  
  function flashMessage(msg) {
    $(".flashMsg").remove();
    $(".row").prepend(`
          <div class="col-sm-12"><div class="flashMsg alert alert-success alert-dismissible fade in" role="alert"> 
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">×</span></button> <strong>${msg}</strong></div></div>
      `);
  }
  
  function appendToUsrTable(poi) {
    $("#poiTable > tbody:last-child").append(`
          <tr id="poi-${poi.id}">
              <td class="poiData" name="name">${poi.name}</td>
  
              '<td class="poiData" name="link">${poi.link}</td>
  
              '<td align="center">
                  <button class="btn btn-success form-control" onClick="editPoi(${poi.id})" 
                  data-toggle="modal" data-target="#myModal")">EDIT</button>
              </td>
              <td align="center">
                  <button class="btn btn-danger form-control" onClick="deletePoi(${poi.id})">DELETE</button>
              </td>
          </tr>
      `);
  }

  // Poi functionality
function addPois() {
  axios
    .post('http://localhost:8083/poi/add', {
      poiName: document.getElementById("poiName").value,
      link: document.getElementById("link").value,
    })
    .then(alert("Your place of interest has been added"))
    .catch(error => console.log(error));
}

function deletePoi(id){
  var id = document.getElementById("id").value;
  axios
    .delete('http://localhost:8083/poi/delete/'+ id)
    .then (alert("Deleted"))
    .catch (error => console.log(error));
}

function getAllPoi() {
  axios
    .get('http://localhost:8080/poi/all')
    .then(res => showPoi(res))
    .catch(error => console.log(error));
}

function showPoi(res) {
  document.getElementById('poiTable').innerHTML=`
  <div class="card card-body mb-4">
    <h5>Status: ${res.status}</h5>
  </div>
  <div class="card mt-3">
    <div class="card-header">
      Data
    </div>
    <div class="card-body">
      <pre>${JSON.stringify(res.data, null, 2)}</pre>
    </div>
  </div>
  
`;
    
}