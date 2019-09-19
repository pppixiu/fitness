$(function () {
    var blogListUrl = '/blog/getuserblogbyuseridorcontentlike';

    function getBlogList() {
        var url = blogListUrl;
        $.getJSON(
            url,
             function(data){
                if (data.code == "0") {
                    var blogList = data.data;
                    var html = '';
                    blogList.map(function(item,index) {
                        html += '<div class="box" style="width: 100%;text-align: center; display: inline-block; position: absolute;top: 0px; padding: 150px 200px;">'
                        + '<div  style="width: 300px;height:auto;padding-right: 5em">'
                        + '<div class="card card-product" style="margin-bottom: 0px">'
                        + '<div class="card-image" style="margin-top: 0px">'
                        + '<a href="#"> <img class="img" src="'
                        + item.userBlogImage.getImageUrl
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
