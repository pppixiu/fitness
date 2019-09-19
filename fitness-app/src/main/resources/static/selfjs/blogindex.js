$(function () {
    var blogListUrl = '/blog/getuserblogbyuseridorcontentlike?rowIndex=0&pageSize=8';

    function getBlogList() {
        var url = blogListUrl;
        $.getJSON(
            url,
             function(data){
                if (data.code == "0") {
                    var blogList = data.data;
                    var html = '';
                    blogList.map(function(item,index) {
                        html += '<div  style="width: 300px;height:auto;padding-right: 5em">'
                        + '<div class="card card-product" style="margin-bottom: 5px">'
                        + '<div class="card-image" style="margin-top: 0px">'
                        + '<a href="#"> <img class="img" src="'
                        + item.imageUrl
                        + '"> </a>'
                        + '</div>'
                        + '<div class="table">'
                        + '<h6 class="category text-rose"></h6>'
                        + '<h4 class="card-caption">'
                        + '</h4>'
                        + '<div class="card-description">'
                        + item.blogContent
                        + '</div>'
                        + '<div class="ftr">'
                        + '</div>'
                        + '</div>'
                        + '</div>'
                        + '</div>'
                        + '</div>'
                    })
                    $('#bloglist').html(html);
                }
        });
    }
    getBlogList();
});
