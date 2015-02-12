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