var endpoint = "http://localhost:8080/logstore-0.0.1-SNAPSHOT/log"

$( document ).ready(function() {
  $.get( endpoint+"", function( data ) {
    data.forEach((log) => {
        var content;
        if (log.content.length > 150) {
          content = log.content.slice(0,150) + '...'
        } else {
          content = log.content;
        }
        var table = document.getElementById("logTable");
        var row = table.insertRow();
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.textContent = content;
        cell2.innerHTML = log.occurrences
        cell3.innerHTML = log.id

            $("#btnSearch").on("click", function(){
               document.getElementById("logTable").deleteRow(1);
                })
        })


  });
});




