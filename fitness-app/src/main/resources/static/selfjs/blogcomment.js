// 初始化
var pageIndex = 1;
var pageSize = 3;
var commentUrl = "/comment/blogcommentlist";
var like_count = 0;
var blog_id = 0;
// 对该博客点赞
var like_times = 1;
// 通用blogId
var blogid;
// 通用userId
var userId = 0;

// 限制字数
function keyUP(t) {
    var len = $(t).val().length;
    if (len > 139) {
        $(t).val($(t).val().substring(0, 140));
    }
}

// 评论按钮
$('.commentAll').on('click', '.plBtn', function () {
    //获取输入内容
    var oSize = $(this).siblings('.flex-text-wrap').find('.comment-input').val();
    var blogId = query("blogId");
    $.ajax({
        url: "/comment/addblogcomment",
        async: false,
        cache: false,
        type: "post",
        dataType: 'json',
        data: {
            content: oSize,
            refId: blogId
        },
        success: function (data) {
            if (data.code == 0) {
                oHtml = '  <div class="comment-show-con clearfix">\n' +
                    '                                        <div class="comment-show-con-img pull-left"><img src="' + data.data.user.imgurl + '" alt=""></div>\n' +
                    '                                        <div class="comment-show-con-list pull-left clearfix">\n' +
                    '                                            <div class="pl-text clearfix">\n' +
                    '                                                <a href="#" class="comment-size-name" data-parent-id="' + data.data.id + '">' + data.data.user.username + ' : </a>\n' +
                    '                                                <span class="my-pl-con">&nbsp;' + data.data.content + '</span>\n' +
                    '                                            </div>\n' +
                    '                                            <div class="date-dz">\n' +
                    '                                                <span class="date-dz-left pull-left comment-time">' + new Date(data.data.time).Format("yyyy-MM-dd") + '</span>\n' +
                    '                                                <div class="date-dz-right pull-right comment-pl-block">\n' +
                    '                                                    <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>\n' +
                    '                                                    <span class="pull-left date-dz-line">|</span>\n' +
                    '                                                    <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">' + data.data.likeCount + '</i>)</a>\n' +
                    '                                                </div>\n' +
                    '                                            </div>\n' +
                    '                                            <div class="hf-list-con"></div>\n' +
                    '                                        </div>\n' +
                    '                                    </div>';
                if (oSize.replace(/(^\s*)|(\s*$)/g, "") != '') {
                    $('.commentAll .plBtn').parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
                    $('.commentAll .plBtn').siblings('.flex-text-wrap').find('.comment-input').prop('value', '').siblings('pre').find('span').text('');
                }
            } else {
                $.toast('评论失败！');
            }
        }
    });
});

// 动态创建回复块
$('.comment-show').on('click', '.pl-hf', function () {
    //获取回复人的名字
    var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
    //回复@
    var fhN = '回复@' + fhName;
    //var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
    var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
    //显示回复
    if ($(this).is('.hf-con-block')) {
        $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
        $(this).removeClass('hf-con-block');
        $('.content').flexText();
        $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding', '6px 15px');
        //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
        //input框自动聚焦
        $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
    } else {
        $(this).addClass('hf-con-block');
        $(this).parents('.date-dz-right').siblings('.hf-con').remove();
    }
});

//回复的评论创建
$('.comment-show').on('click', '.hf-pl', function () {
    var oThis = $(this);
    //获取输入内容
    var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();
    var parentId = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').data("parentId");
    //生成 回复@名字 字段
    var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
    var oAllVal = '回复@' + oHfName;
    var blogId = query("blogId");
    if (oHfVal.replace(/^ +| +$/g, '') == '' || oHfVal == oAllVal) {

    } else {
        $.ajax({
            url: "/comment/addblogcomment",
            async: false,
            cache: false,
            type: "post",
            dataType: 'json',
            data: {
                content: oHfVal,
                parentId: parentId,
                refId: blogId
            },
            success: function (data) {
                if (data.code == 0) {
                    oHtml = '  <div class="comment-show-con clearfix">\n' +
                        '                                        <div class="comment-show-con-img pull-left"><img src="' + data.data.user.imgurl + '" alt=""></div>\n' +
                        '                                        <div class="comment-show-con-list pull-left clearfix">\n' +
                        '                                            <div class="pl-text clearfix">\n' +
                        '                                                <a href="#" class="comment-size-name" data-parent-id="' + data.data.id + '">' + data.data.user.username + ' : </a>\n' +
                        '                                                <span class="my-pl-con">&nbsp;' + data.data.content + '</span>\n' +
                        '                                            </div>\n' +
                        '                                            <div class="date-dz">\n' +
                        '                                                <span class="date-dz-left pull-left comment-time">' + new Date(data.data.time).Format("yyyy-MM-dd") + '</span>\n' +
                        '                                                <div class="date-dz-right pull-right comment-pl-block">\n' +
                        '                                                    <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>\n' +
                        '                                                    <span class="pull-left date-dz-line">|</span>\n' +
                        '                                                    <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">' + data.data.likeCount + '</i>)</a>\n' +
                        '                                                </div>\n' +
                        '                                            </div>\n' +
                        '                                            <div class="hf-list-con"></div>\n' +
                        '                                        </div>\n' +
                        '                                    </div>';
                    oThis.parents('.hf-con').parents('.comment-show-con-list:first').find('.hf-list-con:first').css('display', 'block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
                    // oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display', 'block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
                } else {
                    $.toast('评论失败！');
                }
            }
        });

    }
});

// 点赞 暂时阉割
<!--$('.comment-show').on('click','.date-dz-z',function(){-->
<!--var zNum = $(this).find('.z-num').html();-->
<!--if($(this).is('.date-dz-z-click')){-->
<!--zNum&#45;&#45;;-->
<!--$(this).removeClass('date-dz-z-click red');-->
<!--$(this).find('.z-num').html(zNum);-->
<!--$(this).find('.date-dz-z-click-red').removeClass('red');-->
<!--}else {-->
<!--zNum++;-->
<!--$(this).addClass('date-dz-z-click');-->
<!--$(this).find('.z-num').html(zNum);-->
<!--$(this).find('.date-dz-z-click-red').addClass('red');-->
<!--}-->
<!--})-->

// 删除评论 已阉割
<!--$('.commentAll').on('click','.removeBlock',function(){-->
<!--var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');-->
<!--if(oT.siblings('.all-pl-con').length >= 1){-->
<!--oT.remove();-->
<!--}else {-->
<!--$(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display','none')-->
<!--oT.remove();-->
<!--}-->
<!--$(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();-->

<!--})-->

//从url中获取参数
function query(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}

$(function () {
    /**
     * 获取传参
     * @param variable
     * @returns {*}
     */
    var resultBlogContent = query("blogId");
    blogContent(resultBlogContent);

    function sleep(numberMillis) {
        var now = new Date();
        var exitTime = now.getTime() + numberMillis;
        while (true) {
            now = new Date();
            if (now.getTime() > exitTime)
                return;
        }
    }


    function blogContent(blogId) {
        var blogContentUrl = '/blog/getuserblogbyblogid?blogId=' + blogId;
        var url = blogContentUrl;
        // 判断博客点赞状态
      //  var blogLikeActiveUrl = '/blog/getlikeactive?blogId=' + blogId;

        // $.getJSON(
        //     blogLikeActiveUrl,
        //     function (data) {
        //         var htmlOne='';
        //         alert(data.data);
        //         if (data.data == 1) {
        //             htmlOne += '<a id="like-count"'
        //                 + 'style="color: #FF2D2D"'
        //                 + 'onclick="blogLike()"'
        //                 + 'href="#"'
        //                 + 'type="button" class="glyphicon glyphicon-thumbs-up"'
        //                 + '></a>'
        //         }else {
        //             htmlOne = '';
        //             htmlOne += '<a id="like-count" '
        //                 + 'onclick="blogLike()"'
        //                 + 'href="#"'
        //                 + 'type="button" class="glyphicon glyphicon-thumbs-up"'
        //                 + '></a>'
        //         }
        //         $('#like-count-div').html(htmlOne);
        //         like_times = data.data
        //     });
        sleep(50);

        // 博客详情
        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var blogContent = data.data;
                    var html = ''
                    $('#blog-image').attr("src", blogContent.userBlogImage.imageUrl);
                    $('#view-count').text(blogContent.viewCount);
                    $('#like-count').text(blogContent.likeCount);
                    $('#blog-content').html(blogContent.blogContent)
                }
                viewCount(blogId,blogContent.viewCount )
                like_count = blogContent.likeCount;
                blog_id = blogId;
            });
    }


    // 更新博客浏览量
    function viewCount(blogId, viewCount) {
        var params = {}
        params.viewCount = viewCount;
        params.blogId = blogId;
        if (params.blogId != ""){
            $.ajax({
                url:'/blog/modifyviewcount',
                type: "get",
                contentType:'application/json',
                dataType: 'json',
                data : params,
                success : function (data) {
                    if (data.success){
                        alert("成功")
                    }
                }
            })
        }
    }


    var resultUserBlog = query("userId");
    getUserBlog(resultUserBlog);
    // 用户其它博客
    function getUserBlog(userId) {
        var blogCommentUrl = '/blog/getuserblogbyuserid?'
            + 'pageIndex=' + pageIndex
            + '&pageSize=' + pageSize
            + '&userId=' + userId;
        var url = blogCommentUrl;
        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var userBlog = data.data;
                    var html = ''
                    userBlog.map(function (item, index) {
                        var url = "blogcomment?blogId="
                            + item.blogId
                            + '&userId='
                            + item.userProfile.userId;
                        html += '<div style="padding-top: 2em;" onclick="window.open('
                            + "'"
                            + url
                            + "'"
                            + ')"> '
                            + '<a href="#">'
                            + '<img src="'
                            + item.imageUrl
                            + '" alt="" style="height: 200px; width: 80%; border-radius: 0.5em">'
                            + '</a>'
                            + '<div style="width: 80%;  padding-top: 1em">'
                            + '<p>'
                            + item.blogContent
                            + '</p>'
                            + '</div>'
                            + '</div>'
                    })
                    $('#userBlog').html(html);

                    // 用户头像和用户信息
                    $('#user-image').attr("src", userBlog[0].userProfile.userImageUrl)
                    $('#user-name').text(userBlog[0].userProfile.userName)
                }
            });
    }



    var resultViewCount = query("userId");
    getViewCount(resultViewCount);

    // 用户博客总浏览数
    function getViewCount(userId) {
        var viewCountUrl = '/blog/getviewcount?userId=' + userId;
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

        viewCount();
    };

    var resultLikeCount = query("userId");
    getLikeCount(resultLikeCount);

// 用户博客总点赞数
    function getLikeCount(userId) {
        var likeCountUrl = '/blog/getlikecount?userId=' + userId;
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

        likeCount();
    }

    function getComment() {
        blogId = query("blogId");
        var blogCommentUrl = commentUrl + "?" + "refId=" + blogId;
        var html = ''
        $.getJSON(
            blogCommentUrl,
            function (data) {
                if (data.code == "0") {
                    var commentList = data.data;
                    commentList.map(function (item, index) {
                        var child = commentChild(item.child);
                        html += '\t<div class="comment-show-con clearfix">\n' +
                            '\t\t\t\t\t\t\t<div class="comment-show-con-img pull-left"><img src="' + item.user.imgurl + '" alt=""></div>\n' +
                            '\t\t\t\t\t\t\t<div class="comment-show-con-list pull-left clearfix">\n' +
                            '\t\t\t\t\t\t\t\t<div class="pl-text clearfix">\n' +
                            '\t\t\t\t\t\t\t\t\t<a href="#" class="comment-size-name" data-parent-id="' + item.id + '">' + item.user.username + ' : </a>\n' +
                            '\t\t\t\t\t\t\t\t\t<span class="my-pl-con">&nbsp;' + item.content + '</span>\n' +
                            '\t\t\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t\t\t\t<div class="date-dz">\n' +
                            '\t\t\t\t\t\t\t\t\t<span class="date-dz-left pull-left comment-time">' + new Date(item.time).Format("yyyy-MM-dd") + '</span>\n' +
                            '\t\t\t\t\t\t\t\t\t<div class="date-dz-right pull-right comment-pl-block">\n' +
                            '\t\t\t\t\t\t\t\t\t\t<a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>\n' +
                            '\t\t\t\t\t\t\t\t\t\t<span class="pull-left date-dz-line">|</span>\n' +
                            '\t\t\t\t\t\t\t\t\t\t<a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">' + item.likeCount + '</i>)</a>\n' +
                            '\t\t\t\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t\t\t\t<div class="hf-list-con">' + child + '</div>\n' +
                            '\t\t\t\t\t\t\t</div>\n' +
                            '\t\t\t\t\t\t</div>'
                    })
                }
                $('.comment-show').html(html);
            });
    }

    getComment();

    function commentChild(data) {
        var html = '';
        data.map(function (item, index) {
            var child = commentChild(item.child);
            html += '  <div class="comment-show-con clearfix">\n' +
                '                                        <div class="comment-show-con-img pull-left"><img src="' + item.user.imgurl + '" alt=""></div>\n' +
                '                                        <div class="comment-show-con-list pull-left clearfix">\n' +
                '                                            <div class="pl-text clearfix">\n' +
                '                                                <a href="#" class="comment-size-name" data-parent-id="' + item.id + '">' + item.user.username + ' : </a>\n' +
                '                                                <span class="my-pl-con">&nbsp;' + item.content + '</span>\n' +
                '                                            </div>\n' +
                '                                            <div class="date-dz">\n' +
                '                                                <span class="date-dz-left pull-left comment-time">' + new Date(item.time).Format("yyyy-MM-dd") + '</span>\n' +
                '                                                <div class="date-dz-right pull-right comment-pl-block">\n' +
                '                                                    <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>\n' +
                '                                                    <span class="pull-left date-dz-line">|</span>\n' +
                '                                                    <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">' + item.likeCount + '</i>)</a>\n' +
                '                                                </div>\n' +
                '                                            </div>\n' +
                '                                            <div class="hf-list-con">' + child + '</div>\n' +
                '                                        </div>\n' +
                '                                    </div>'
        });
        return html;
    }

    // 初始化用户Id
    getUserId();

    // 初始化博客点赞
    blogLike();

});


/**
 * 获取登录用户的id
 */
function getUserId() {
    var headerUrl ='/header/sessionInfo';
    $.getJSON(
        headerUrl,
        function (data) {
            var imghtml='';
            var info = data;
            if(info==''){
                alert('没有获取到登录信息');
            }else {
                userId = info.userId;
            }
        });
}

// 对该博客点赞
function blogLike() {

    var liketimes;
    var blogLikeCountUrl = '/blog/modifylikecount?blogId=' + blogId;

    /*加载基本信息*/
    $.getJSON(
        blogLikeCountUrl,
        function (data) {
            if (data.code == "0") {
                var info = data.data;
                likecount = info.likecount;
                liketimes = info.judge;
                if(liketimes == 1){
                    $('#like-count').text($('#like-count').text()*1+1);
                    $('#like-count').css("color","Red")
                }else if(liketimes == 0){
                    $('#like-count').text($('#like-count').text()*1-1);
                    $('#like-count').css("color","black")
                }
            }
        });
}

/** 判断用户评论*/
function judgeUser() {
    if(userId == 0){
        if(confirm("评论需要登录用户，是否前往登录页面?")==true){
            window.location.href="/login/login";
        }
    }
}