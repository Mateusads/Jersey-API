
    $("#btnSearch").on("click", function(){
        var numID = $("#searchID").val();
        var url = "http://localhost:8080/logstore-0.0.1-SNAPSHOT/log/" + numID;

    $.ajax({
      url: url,
      type: "GET",
      dataType: "json"

    }).success(function(log) {

              var table = document.getElementById("logTable");
              var row = table.insertRow();
              var cell1 = row.insertCell(0);
              var cell2 = row.insertCell(1);
              var cell3 = row.insertCell(2);
              cell1.textContent = log.content;
              cell2.innerHTML = log.occurrences
              cell3.innerHTML = log.id
    });

    })

