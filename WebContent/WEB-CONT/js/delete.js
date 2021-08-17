    $("#btndeleteLog").on("click", function(){
    logid = $("#deleteLog").val();
    url = 'http://localhost:8080/logstore-0.0.1-SNAPSHOT/log/' + logid;

    $.ajax({
        type: 'DELETE',
        url: url,
        success: function(data) { window.location.reload(); },

    });

    })

