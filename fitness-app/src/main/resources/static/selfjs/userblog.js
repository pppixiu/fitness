$(function () {
    var listBlogUrl = '/user/bloglist';

    function getuserblog() {
        var url = listBlogUrl;
        $
            .getJSON(
                url,
                function (data) {
                    if (data.code == "0") {
                        var blogList = data.data;
                        var html = '';
                        blogList
                            .map(function (item, index) {
                                html += '<div class="col-md-12 shadow radis" style="background-color: white; margin-bottom: 20px;">'
                                    + '<div class="col-md-9"  style="padding-top: 5%;">'
                                    + '<p>'
                                    + item.blogContent
                                    + '</p>'
                                    + ' <span style="margin-top: 4%;float: left;">点赞：'
                                    + item.likeCount
                                    + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>'
                                    + '<span style="margin-top: 4%;float: left;">收藏：'
                                    + item.viewCount
                                    + '</span>'
                                    + '<h3 class="t-button" style="float: right;">'
                                    + '<a href="#">'
                                    + '<span class="label label-default">删除博文</span></a>'
                                    + ' </h3>\n' +
                                    '                        </div>\n' +
                                    '                        <div class="col-md-3" style="padding-top: 10px; padding-bottom: 10px; text-align: right">'
                                    + '<img src="images/a1.jpg" alt="" width="150px" height="150px">'
                                    + '<a href="#">'
                                    + '</div>'
                                    + '</div>'
                            })

                        $('#blog-list').html(html);

                    }
                });
    }

    getuserblog();
});
