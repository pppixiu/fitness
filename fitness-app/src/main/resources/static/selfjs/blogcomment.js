// 初始化
var pageIndex=1;
var pageSize=3;

$(function () {
    /**
     * 获取传参
     * @param variable
     * @returns {*}
     */
    function query(variable){
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == variable){
                return pair[1];}
        }
        return(false);
    }

    var resultBlogContent = query("blogId");
    blogContent(resultBlogContent);
    // 博客详情
    function blogContent(blogId) {
        var blogContentUrl = '/blog/getuserblogbyblogid?blogId='+blogId;
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

    var resultUserBlog = query("userId");
    getUserBlog(resultUserBlog);
    // 用户其它博客
    function getUserBlog(userId) {
        var blogCommentUrl = '/blog/getuserblogbyuserid?'
            +'pageIndex='+pageIndex
            +'&pageSize='+pageSize
            +'&userId='+userId;
        var url = blogCommentUrl;
        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var userBlog = data.data;
                    var html=''
                    userBlog.map(function (item,index) {
                        var url = "blogcomment?blogId="
                            +  item.blogId
                            +  '&userId='
                            +  item.userProfile.userId;
                        html += '<div style="padding-top: 2em;" onclick="window.open('
                            + "'"
                            + url
                            + "'"
                            + ')"> '
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

    var resultViewCount = query("userId");
    getViewCount(resultViewCount);
    // 用户博客总浏览数
    function getViewCount(userId) {
            var viewCountUrl = '/blog/getviewcount?userId='+userId;
            var url = viewCountUrl;
            function viewCount() {
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
    };


    var resultLikeCount = query("userId");
    getLikeCount(resultLikeCount);
// 用户博客总点赞数
    function getLikeCount(userId) {
            var likeCountUrl = '/blog/getlikecount?userId='+userId;
            var url = likeCountUrl;
            function likeCount() {
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
    }
});