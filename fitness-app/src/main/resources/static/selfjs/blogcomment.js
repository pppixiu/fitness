$(function () {
    var blogCommentUrl = '/blog/getuserblogbyuseridorcontentlike?rowIndex=0&pageSize=3&userId=2';

    function getUserBlog() {
        var url = blogCommentUrl;
        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var userBlog = data.data;
                    var html='';
                    userBlog.map(function (item,index) {
                        html += '<a href="#">'
                            + '<img src="'
                            + item.imageUrl
                            + '" alt="" style="height: 50%; width: 80%; border-radius: 0.5em">'
                            + '</a>'
                            + '<div style="width: 80%; ">'
                            + '<p>'
                            + item.blogContent
                            + '</p>'
                            + '</div>'
                    })
                    $('#userBlog').html(html);
                }

            });
    }
    getUserBlog()
});