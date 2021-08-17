    $("#btnAddLog").on("click", function(){
    dataLog = $("#addLog").val();
    jsonData = JSON.stringify ({content: ' '+ dataLog + ' '}),

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/logstore-0.0.1-SNAPSHOT/log',
        data: jsonData,
        success: function(data) { window.location.reload(); },
        contentType: "application/json",
        dataType: 'json'
    });

    })

