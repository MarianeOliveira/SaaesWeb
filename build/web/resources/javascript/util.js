//
function validateInput(regexString) {
    var theEvent = window.event || event;
    var key = theEvent.keyCode || theEvent.which;
    if (key >= 46) {
        key = String.fromCharCode(key);
        var regex = new RegExp("^" + regexString + "$");
        if (!regex.test(key)) {
            theEvent.returnValue = false;
            if (theEvent.preventDefault) {
                theEvent.preventDefault();
            }
        }
    }
}

function scrollToAnchor(aid){
    var aTag = $("[id='"+ aid +"']");
    $('html,body').animate({scrollTop: aTag.offset().top},300);
}

function inicioAjaxLoad(id){ $("[id='"+ id +"']").css("visibility","visible"); };
function fimAjaxLoad(id){ $("[id='"+ id +"']").css("visibility","invisible"); ; };

function start() {  PF('statusDialog').show(); }
 
function stop() { PF('statusDialog').hide(); }

//$(document).ready(function() {
//    $("input, textarea").bind('paste', function(evt) {
//            $(evt.currentTarget).keyup();
//     });//end bind.
//});//end document.