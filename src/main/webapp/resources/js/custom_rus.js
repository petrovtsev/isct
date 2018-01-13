$(document).ready(function ($) {
    /*** Show menu on hamburger click ***/
    $("#mbl #toggle").click(function () {
        $(this).parent().parent().toggleClass("on");
    });
    /*** Close menu on link click ***/
    $("#mbl a").click(function () {
            $("#mbl .menu_wrapper").removeClass("on");
        }
    );
});

/*** Conference countdown ***/
$('#clock').countdown('2018/5/11', function (event) {
    var $this = $(this).html(event.strftime(''
        + '<ul><li><span>%D</span><br/><label>Д</label></li> '
        + '<li><span>%H</span><br/><label>Ч</label></li> '
        + '<li><span>%M</span><br/><label>М</label></li> '
        + '<li><span>%S</span><br/><label>С</label></li></ul>'));
});

/*** Modal with custom header and body ***/
$('#myModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var naslov = button.data('naslov');
    var telo = button.data('telo');
    var modal = $(this);
    modal.find('.modal-title').text(naslov);
    modal.find('.modal-body').html(telo);


    $('#thanks .fee').on('change', function () {
        var a = $(this).find('option:selected').attr('value');
        b = a.split('|');
        $('#thanks .value').text(b[0]);
    });

    $("#submit").click(function () {
        $.ajax({
            type: "POST",
            url: "/process.php", //
            data: $('form.registration-form').serialize(),
            success: function (msg) {
                $("#thanks").html(msg);
                /*$("#form-content").modal('hide'); */
            },
            error: function () {
                alert("failure");
            }
        });
    });
});

/*** One page menu ***/
$(function () {
    $('a[href*="#"]:not([href="#"]):not("#accordion a")').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html, body').animate({
                    scrollTop: target.offset().top
                }, 1000);
                return false;
            }
        }
    });
});

/*** SMALLER MENU ON SCROLL ***/
window.addEventListener('scroll', function (e) {
    var distanceY = window.pageYOffset || document.documentElement.scrollTop,
        shrinkOn = 0,
        /*shrinkOn = $('.mask').height(),*/
        header = document.querySelector("nav");
    if (distanceY > shrinkOn) {
        classie.add(header, "smaller");
    } else {
        if (classie.has(header, "smaller")) {
            classie.remove(header, "smaller");
        }
    }
});

/*** Rotating header. Much wow ***/
$(document).ready(function ($) {
    $("#js-rotating").Morphext({
        animation: "bounceInLeft",
        separator: ",",
        speed: 5000,
        complete: function () {
            // Called after the entrance animation is executed.
        }
    });
});

/*** Coming soon tooltip ***/
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

$(document).ready(function ($) {

});