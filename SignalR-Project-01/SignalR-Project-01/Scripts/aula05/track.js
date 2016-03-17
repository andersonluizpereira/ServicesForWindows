$(function () {
    var connection = $.connection("/myconn");
    connection.start(function () {
        alert("Connected");

        startTrack();
    });

    connection.received(function (data) {
        data = JSON.parse(data);
        var domElementId = "Id" + data.id;
        var elem = createElementIfNotExists(domElementId);
        $(elem).css({ left: data.x,top: data.y }).text(data.id);


    });

    function startTrack() {
        $("body").mousemove(function (e) {
            var data = {x: e.pageX, y: e.pageY, id: connection.id};

            connection.send(data);
        });
    }

    function createElementIfNotExists(id) {
        var element = $("#" + id);

        if (element.length == 0) {
            element = $("<span class='client' id='" + id + "'></span>");
            element.css({
                backgroundColor: RandomColor(),
                color: 000000
            });

            $("body").append(element).show();
        }
        return element;
    }

    function RandomColor() {
      //  return "rgb(" + Math.round((Math.random() * 255) + 50) + "," + Math.round((Math.random() * 255) + 50) + ")";
        return "rgb(" + Math.round((Math.random() * 255) + 50) + "," + Math.round((Math.random() * 255) + 50) + "," + Math.round((Math.random() * 255) + 50) + ")";
    }
    

});