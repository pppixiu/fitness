var listBlogUrl = '/user/bloglist';
var pageSize = 5;
var pageNum = 1;

//初始化blog数据
function getuserblog() {
    var url = listBlogUrl + '?pageIndex=' + pageNum + '&pageSize=' + pageSize;
    var html = '';
    var headerUrl ='/header/sessionInfo';
    $.getJSON(
        headerUrl,
        function (data) {
            var imghtml='';
            var info = data;
            if(info==''){
                alert('没有获取到登录信息');
            }else {
                $.getJSON(
                    url,
                    function (data) {
                        if (data.code == "0") {
                            var blogList = data.data;
                            blogList
                                .map(function (item, index) {
                                    html += '  <div class="col-md-12 shadow radis" style="background-color: white; margin-bottom: 20px;">\n' +
                                        '                    <div class="col-md-9"  style="padding-top: 5%;">\n' +
                                        '                    <p><a href="#">'+ item.blogContent +'</a></p>\n' +
                                        '                    <span style="margin-top: 4%;float: left;">点赞：'+ item.likeCount +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n' +
                                        '                    <span style="margin-top: 4%;float: left;">观看：'+ item.viewCount +'</span>\n' +
                                        '                    <h3 class="t-button" style="float: right;">\n' +
                                        '                    <a href="/blog/blogcomment?blogId='+item.blogId+'&userId='+info.userId+'"><span class="btn btn-success">查看博文</span></a>\n' +
                                        '                    </h3>\n' +
                                        '                    </div>\n' +
                                        '                    <div class="col-md-3" style="padding-top: 10px; padding-bottom: 10px; text-align: right">\n' +
                                        '                    <img src="'+ item.imageUrl +'" alt="" width="150px" height="150px">\n' +
                                        '                    </div>\n' +
                                        '                    </div>'
                                });
                            $('#blog-button').html('<button class="corner-button" onclick="nextPage()">\n' +
                                '                    <span>加载更多</span>\n' +
                                '                </button>');
                        } else {
                            html = '<div style="height: 550px; text-align: center; line-height: 550px; font-size: 20px;" >好像还没有发布过动态哦</div>';
                            $('#blog-button').html('');
                        }
                        $('#blog-list').html(html);
                        pageNum += 1;
                    });
            }
        });
}

function addItems(pageSize, pageIndex) {
    var headerUrl ='/header/sessionInfo';
    $.getJSON(
        headerUrl,
        function (data) {
            var imghtml='';
            var info = data;
            if(info==''){
                alert('没有获取到登录信息');
            }else {
                // 生成新条目的URL
                var url = listBlogUrl + '?pageIndex=' + pageNum + '&pageSize=' + pageSize;
                var html = '';
                loading = true;
                $.getJSON(
                    url,
                    function (data) {
                        if (data.code == "0") {
                            var blogList = data.data;
                            blogList
                                .map(function (item, index) {
                                    html += '  <div class="col-md-12 shadow radis" style="background-color: white; margin-bottom: 20px;">\n' +
                                        '                    <div class="col-md-9"  style="padding-top: 5%;">\n' +
                                        '                    <p><a href="#">'+ item.blogContent +'</a></p>\n' +
                                        '                    <span style="margin-top: 4%;float: left;">点赞：'+ item.likeCount +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n' +
                                        '                    <span style="margin-top: 4%;float: left;">观看：'+ item.viewCount +'</span>\n' +
                                        '                    <h3 class="t-button" style="float: right;">\n' +
                                        '                    <a href="/blog/blogcomment?blogId='+item.blogId+'&userId='+info.userId+'"><span class="btn btn-success">查看博文</span></a>\n' +
                                        '                    </h3>\n' +
                                        '                    </div>\n' +
                                        '                    <div class="col-md-3" style="padding-top: 10px; padding-bottom: 10px; text-align: right">\n' +
                                        '                    <img src="'+ item.imageUrl +'" alt="" width="150px" height="150px">\n' +
                                        '                    </div>\n' +
                                        '                    </div>'
                                });
                        } else {
                            $('#blog-button').html('<div class="col-md-12" style="font-size: 30px; text-align: center; background-color: white">\n' +
                                '                   no more\n' +
                                '                </div>');
                        }

                        $('#blog-list').append(html);
                        pageNum += 1;
                    });
            }
        });
}

function nextPage() {
    addItems(pageSize, pageNum);
}

$(function () {
    getuserblog();
});
