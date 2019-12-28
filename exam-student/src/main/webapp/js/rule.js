var timer = null;
var count = 19;

var Rule = {
    init: function() {
        timer = setInterval(function() {
        	count--;
        	$("#timerCount").html(count);
        	if(count == 0) {
        		clearInterval(timer)
        		$("#enter-btn").show();
        	}
        },1000);
    },
    clickEnter: function() {
    	window.location.href = "/index";
    }
};

$(function() {
    (function(_r) {
        _r.init()
    })(Rule);
})