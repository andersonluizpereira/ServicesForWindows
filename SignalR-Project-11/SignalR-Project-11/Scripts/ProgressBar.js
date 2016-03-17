$(function () {
    var hub = $.connection.progressBarHub;

    hub.client.update = function (value) {
        $("#progressBar").css("width", value + "%")
        .text(value + " %");

    };

    $("#start").click(function(){
        $(this).attr("disabled", true);
        $("#result")
        .hide("slow")
        .load("HardProcess.aspx?connId=" + $.connection.hub.id,
        function () {
            $(this).slideDown("slow");
            $("#start").attr("disabled", false);
        });
    });

    $.connection.hub.start()
    .done(function () {
        $("#start").attr("disabled", false);
    });

});