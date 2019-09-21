jQuery(document).ready(function($){
    "use strict";
    $("<div/>").load("/header.html").insertBefore($(".page-content"));
    $("<div/>").load("/footer.html").insertAfter($(".page-content"));
})