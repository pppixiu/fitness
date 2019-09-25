/**值的初始化*/
var pageIndex = 1;
var blogContent = '';
var pageSize = 8;
// var blogContent = 'empty'


$(function () {
    getBlogList();
    header();
});

/**
 * 获取页面值
 */
function pagefunction() {
    getBlogList();
}

/**
 * 获得模糊查询值
 */
function namefunction() {
    var blogOutCount = $(".bloglist").length;
    if(blogOutCount > 0){
        pageIndex = 0;
    }
    blogContent = document.getElementById('blog-like').value;
    if(blogContent == ""){
        blogContent = "";
    }
    getBlogList();
}

function getBlogList() {
    var blogListUrl = '/blog/getuserblogbyuseridorcontentlike?'
        +'pageIndex='+pageIndex
        +'&pageSize='+pageSize
        +'&blogContent='+blogContent;
    var url = blogListUrl;

    $.getJSON(
        url,
        function(data){
            if (data.code == "0") {
                var blogList = data.data;
                var html = '';
                blogList.map(function(item,index) {
                    var blogCommentUrl = "blogcomment?blogId="
                        +  item.blogId
                        +  '&userId='
                        +  item.userProfile.userId;
                    html += '<div style="width: 300px;height:auto;padding-right: 5em;" class="bloglist" onclick="window.open('
                        + "'"
                        + blogCommentUrl
                        + "'"
                        + ')"> '
                        + '<div class="card card-product" style="margin-bottom: 5px" >'
                        + '<div class="card-image" style="margin-top: 0px;">'
                        + '<a href="'
                        +  blogCommentUrl
                        + '"> <img class="img" src="'
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
                if (blogList.length == 0) {
                    // alert("抱歉，没有该博客信息")
                    $('#not-find').text("\抱歉！没有找到相关博客信息")
                }
                    $('#bloglist').html(html);
            }
        });
}

/**
 * 滚动加载
 */
$(window).scroll(function () {
    var srollPos = $(window).scrollTop()+0.5;    //滚动条距顶部距离(页面超出窗口的高度)
    if (srollPos>=($(document).height()-$(window).height())) {
        pageIndex += 1;
        var blogListUrl = '/blog/getuserblogbyuseridorcontentlike?'
            +'pageIndex='+pageIndex
            +'&pageSize='+pageSize
            +'&blogContent='+blogContent;
        var url = blogListUrl;
        $.getJSON(
            url,
            function(data){
                if (data.code == "0") {
                    var blogList = data.data;
                    var html = '';
                    blogList.map(function(item,index) {
                        var blogCommentUrl = "blogcomment?blogId="
                            +  item.blogId
                            +  '&userId='
                            +  item.userProfile.userId;
                        html += '<div style="width: 300px;height:auto;padding-right: 5em;" class="bloglist" onclick="window.open('
                            + "'"
                            + blogCommentUrl
                            + "'"
                            + ')"> '
                            + '<div class="card card-product" style="margin-bottom: 5px" >'
                            + '<div class="card-image" style="margin-top: 0px;">'
                            + '<a href="'
                            +  blogCommentUrl
                            + '"> <img class="img" src="'
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
                    if (blogList.length == 0) {
                        alert("抱歉，已经到底了")
                    } else {
                        $('#bloglist').append(html);
                    }
                }
            });
    }
});

/**
 * 加载当前用户登录信息
 */
function header() {
    var headerUrl ='/header/sessionInfo';
    $.getJSON(
        headerUrl,
        function (data) {
            var imghtml='';
            var info = data;
            if(info==''){
                alert('没有获取到登录信息');
            }else {
                imghtml += '<img style="border-radius: 50px;width: 40px;height: 40px;position: absolute;top: -30px; margin-left: 10px;" src="'
                    + info.userImageUrl
                    + '" onclick="window.open('
                    + "'"
                    + '/user/selfcourse?userId='
                    + info.userId
                    + "'"
                    + ')">';
                $('#user-img').html(imghtml);
            }
        });
}
