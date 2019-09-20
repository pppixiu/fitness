$(function () {
    var blogCommentUrl = '/blog/getuserblogbyuseridorcontentlike?rowIndex=0&pageSize=3&userId=5';

    function getUserBlog() {
        var url = blogCommentUrl;
        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var userBlog = data.data;
                    var html='';
                    userBlog.map(function (item,index) {
                        html += '<div style="padding-top: 2em;">'
                            +'<a href="#">'
                            + '<img src="'
                            + item.imageUrl
                            + '" alt="" style="height: 50%; width: 80%; border-radius: 0.5em">'
                            + '</a>'
                            + '<div style="width: 80%; ">'
                            + '<p>'
                            + item.blogContent
                            + '</p>'
                            + '</div>'
                            + '</div>'
                    })
                    $('#userBlog').html(html);

                    // 用户头像和用户信息
                    $('#user-image').attr("src",userBlog[0].userProfile.userImageUrl)
                    $('#user-name').text(userBlog[0].userProfile.userName)
                }

            });
    }
    getUserBlog()
});

// 博客详情
$(function () {
    var blogContentUrl = '/blog/getuserblogbyblogid?blogId=13'

    function blogContent() {
        var url = blogContentUrl;

        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var blogContent = data.data;
                    var html=''
                    $('#blog-image').attr("src",blogContent.userBlogImage.imageUrl);
                    $('#view-count').text(blogContent.viewCount);
                    $('#like-count').text(blogContent.likeCount);
                    $('#blog-content').text(blogContent.blogContent);
                }

            });
    }
    blogContent();
});

// 用户博客总浏览数
$(function () {
    var viewCountUrl = '/blog/getviewcount?userId=5'

    function viewCount() {
        var url = viewCountUrl;

        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var viewCount = data.data;
                    $('#all-view-count').text(viewCount);
                }
            });
    }
    viewCount() ;
});

// 用户博客总点赞数
$(function () {
    var likeCountUrl = '/blog/getlikecount?userId=5'

    function likeCount() {
        var url = likeCountUrl;

        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var likeCount = data.data;
                    $('#all-like-count').text(likeCount);
                }
            });
    }
    likeCount() ;
});