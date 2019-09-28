/**
 * 通用字段
 * @type {*|string}
 */
var courseId = getQueryString('courseId');
var courseUrl = '/course/listcourses?tagId=&pageIndex=1&pageSize=2&courseTitle=&orderByCondition=&courseLevel=';
var cTitle;
var cNowPrice;
var judgeBuy = 0;

/**
 * 显示弹出框
 */
function buyCourse (){
    $('#courseId').val(courseId);
    $('#courseTitle').val(cTitle);
    $('#totalMoney').val(cNowPrice);
    $("#gui_kai").show();
}

/**8
 * 支付宝支付
 */
function alipayOnline(action) {
    document.getElementById("form").action = action;
    $('#courseId').val(courseId);
    $('#courseTitle').val(cTitle);
    $('#totalMoney').val(cNowPrice);
    document.getElementById("form").submit();
}
function generateTimeReqestNumber() {
    var date = new Date();
    return date.getFullYear().toString() + pad2(date.getMonth() + 1) + pad2(date.getDate()) + pad2(date.getHours()) + pad2(date.getMinutes());
}
function pad2(n) {
    return n < 10 ? '0' + n : n
}

$(function () {
    var courseLessonUrl = '/course/listcoursebyid?courseId=' + courseId;

    function getcourselesson() {
        var url = courseLessonUrl;

        $
            .getJSON(
                url,
                function (data) {
                    if(data.isNo == "0"){
                        $('#isNo').text("购买课程");
                    }else if(data.isNo == "1"){
                        $('#isNo').text("已购买");
                        $("#isNo").attr("onclick",null);
                        $('#isNo').css("background-color","#999999");
                        $('#isNo').css("border-color","#999999");
                        judgeBuy = 1;
                    }

                    if (data.code == "0") {
                        var courseLesson = data.data;
                        cTitle = courseLesson.title;
                        cNowPrice = courseLesson.nowprice;
                        var html = '';
                        $('#course-title').text(courseLesson.title);
                        $('#userimg').attr("src", courseLesson.user.imgurl);
                        $('#user-name').text(courseLesson.user.username);
                        $('#course-level').text(courseLesson.level);
                        $('#course-time').text(courseLesson.coursetime);
                        $('#study-count').text(courseLesson.count);
                        $('#course-desc').text(courseLesson.desc);
                        $('#lesson-note').text(courseLesson.coursenote);

                        courseLesson.courselesson
                            .map(function (item, index) {
                                if(judgeBuy == 1) {
                                    html += ' <div class="chapter course-wrap " style=" margin-bottom: 8px;padding: 24px 32px 32px;background: #fff;box-shadow: 0 8px 16px 0 rgba(7,17,27,.1);border-radius: 12px;font">'
                                        + '<h3> <a style="text-decoration: none; color: black" href="'+ item.lessonurl +'">'
                                        + item.lessontitle
                                        + '</a></h3>'
                                        + '<div class="chapter-description" style="margin-top: 2px;font-size: 12px;color: #545c63;line-height: 18px;">'
                                        + item.lessondesc
                                        + '</div></div>'
                                }else {
                                    html += ' <div class="chapter course-wrap " style=" margin-bottom: 8px;padding: 24px 32px 32px;background: #fff;box-shadow: 0 8px 16px 0 rgba(7,17,27,.1);border-radius: 12px;font">'
                                        + '<h3> <a style="text-decoration: none;">'
                                        + item.lessontitle
                                        + '</a></h3>'
                                        + '<div class="chapter-description" style="margin-top: 2px;font-size: 12px;color: #545c63;line-height: 18px;">'
                                        + item.lessondesc
                                        + '</div></div>'
                                }
                            })

                        $('#course-lesson').html(html);

                    }
                });
    }

    function getCourseList() {
        var html = '';
        $
            .getJSON(
                courseUrl,
                function (data) {
                    if (data.code == "0") {
                        var blogList = data.data;
                        blogList
                            .map(function (item, index) {
                                html += '<div class="shizhan-course-wrap l  ">\n' +
                                    '                        <a href="courseInfo.html">\n' +
                                    '                        </a>\n' +
                                    '                        <div class="shizhan-course-box"><a href="">\n' +
                                    '                            <!-- 学习进度 -->\n' +
                                    '\n' +
                                    '                        </a>\n' +
                                    '                            <div class="box"><a href="courseInfo.html">\n' +
                                    '                                <div class="img-box">\n' +
                                    '                                    <div class="shizhan-course-gradient"></div>\n' +
                                    '                                    <img class="shizhan-course-img" alt="' + item.title + '" src="' + item.url + '">\n' +
                                    '                                    <div class="lecturer-info">\n' +
                                    '                                        <img class="images/a1.jpg" alt="" src="' + item.user.imgurl + '">\n' +
                                    '                                        <span>\n' +
                                    '\n' +
                                    '\t\t\t\t\t\t\tBrian\n' +
                                    '\t\t\t\t\t\t</span>\n' +
                                    '                                    </div>\n' +
                                    '                                </div>\n' +
                                    '                            </a>\n' +
                                    '                                <div class="shizhan-intro-box"><a href="courseInfo.html">\n' +
                                    '                                    <a href="?courseId=' +
                                                                          item.id +
                                                                          '" style="text-decoration:none;margin-top: 10px;"><p class="shizan-name" style="height: 24px;overflow: hidden;"\n' +
                                    '                                                                                               title="' + item.title + '">\n' +
                                    '                                        ' + item.title + '</p></a>\n' +
                                    '                                    <div class="evaluation-box">\n' +
                                    '                                        <div class="shizhan-info">\n' +
                                    '                                            <span class="grade">' + item.level + '</span>\n' +
                                    '                                            <span>98</span>\n' +
                                    '                                            <span class="r">' + item.count + '人学习</span>\n' +
                                    '\n' +
                                    '\n' +
                                    '                                        </div>\n' +
                                    '                                        <div class="evaluation-desc-box clearfix">\n' +
                                    '                                            <i class="trangle"></i>\n' +
                                    '                                            <div class="left-box l">\n' +
                                    '                                                <p>好评度</p>\n' +
                                    '                                                <p class="big-text">100%</p>\n' +
                                    '                                                <p>' + item.count + '人评价</p>\n' +
                                    '                                            </div>\n' +
                                    '                                            <div class="right-box l">\n' +
                                    '                                                <p>内容实用<span>10</span></p>\n' +
                                    '                                                <p>通俗易懂<span>10</span></p>\n' +
                                    '                                                <p>逻辑清晰<span>10</span></p>\n' +
                                    '                                            </div>\n' +
                                    '                                        </div>\n' +
                                    '                                    </div>\n' +
                                    '\n' +
                                    '                                </a>\n' +
                                    '                                    <div class="shizhan-info-bottom"><a href="//class.imooc.com/sale/webfullstack">\n' +
                                    '                                    </a>\n' +
                                    '                                        <div class="clearfix"><a href="//class.imooc.com/sale/webfullstack">\n' +
                                    '\n' +
                                    '                                            <span class="discount-price" style="margin-right: 5px;">￥' + item.nowprice + '</span>\n' +
                                    '                                            <del><span class="cost-price"><del>￥' + item.preprice + '</del></span></del>\n' +
                                    '\n' +
                                    '\n' +
                                    '                                        </a>\n' +
                                    '                                            <div class="r clearfix"><a href="//class.imooc.com/sale/webfullstack"></a>\n' +
                                    '                                                <a href="courseInfo.html"\n' +
                                    '                                                   style="color:#B7BBBF;line-height: 24px;font-size: 12px;text-decoration:none;">了解详情</a>\n' +
                                    '                                            </div>\n' +
                                    '                                        </div>\n' +
                                    '\n' +
                                    '                                    </div>\n' +
                                    '                                </div>\n' +
                                    '                            </div>\n' +
                                    '                        </div>\n' +
                                    '\n' +
                                    '                    </div>'
                            });
                    }
                    $('#course-list').html(html);
                });
    }

    getcourselesson();
    getCourseList();

});