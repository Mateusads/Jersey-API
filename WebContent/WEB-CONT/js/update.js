    $("#btnupdateLog").on("click", function(){
    dataLog = $("#updateLog").val();
    logid = $("#updateid").val();
    jsonData = JSON.stringify ({content: ' '+ dataLog + ' '}),

    url = 'http://localhost:8080/logstore-0.0.1-SNAPSHOT/log/' + logid;

    $.ajax({
        type: 'PUT',
        url: url,
        data: jsonData,
        success: function(data) { window.location.reload(); },
        contentType: "application/json",
        dataType: 'json'
    });

    })

