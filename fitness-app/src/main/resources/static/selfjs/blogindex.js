/**值的初始化*/
var pageIndex = 0;
var blogContent = '';
var pageSize = 8;
var temp = 1;


$(function () {
    getBlogList();
});

/**
 * 获取页面值
 */
function pagefunction() {
    temp = temp + 1;
    pageSize = temp * 8;
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
                    var url = "blogcomment?blogId="
                        +  item.blogId
                        +  '&userId='
                        +  item.userProfile.userId;
                    html += '<div style="width: 300px;height:auto;padding-right: 5em;" onclick="window.open('
                        + "'"
                        + url
                        + "'"
                        + ')"> '
                        + '<div class="card card-product" style="margin-bottom: 5px" >'
                        + '<div class="card-image" style="margin-top: 0px">'
                        + '<a href="'
                        +  url
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
        pagefunction();
    }
});
