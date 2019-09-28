var blogUrl = '';
var courseUrl = '/course/listcourses?tagId=&pageIndex=1&pageSize=8&courseTitle=&orderByCondition=&courseLevel=';
var coachUrl = '/coach/coachList?rowIndex=0&pageSize=8';

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
                            html += '<div class="shizhan-course-wrap l onclick="window.open('
                                + "'"
                                + '/course/courseInfo/?courseId='
                                + item.id
                                + "'"
                                + ')">\n'
                                + '<a href="courseInfo.html">\n' +
                                '                        </a>\n' +
                                '                        <div class="shizhan-course-box"><a href="//class.imooc.com/sale/webfullstack">\n' +
                                '                            <!-- 学习进度 -->\n' +
                                '\n' +
                                '                        </a>\n' +
                                '                            <div class="box"><a href="/course/courseInfo/?courseId='
                                 + item.id +
                                '">\n' +
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
                                '                                <div class="shizhan-intro-box"><a href="/course/courseInfo/?courseId=\'' +
                                item.id +
                                '">\n' +
                                '                                    <a href="courseInfo.html" style="text-decoration:none;"><p class="shizan-name" style="height: 24px;overflow: hidden;"\n' +
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
                    $('#coach-button').html('<button class="corner-button" onclick="nextPage()">\n' +
                        '                    <span>加载更多</span>\n' +
                        '                </button>');
                }
                $('#course-list').html(html);
            });
}


function getCoachList() {
    var html = '';
    $
        .getJSON(
            coachUrl,
            function (data) {
                if (data.code == "0") {
                    var blogList = data.data;
                    blogList
                        .map(function (item, index) {
                            html += ' <div class="col-xs-3" style="margin-bottom: 10px;\n"onclick="window.open('
                                + "'"
                                + '/coach/coachPage?coachId='
                                + item.id
                                + "'"
                                + ')">' +
                                ' <div class="col-xs-12 radis shadow"\n' +
                                '                                 style="margin: 0 5px; padding: 0;background-color: white; padding-bottom: 20px;">\n' +
                                '                                <img src="' + item.imageurl + '" alt="" style="width: 100%; border-radius: 10px; margin-bottom: 15px; min-height: 170px; max-height: 170px; overflow: hidden;">\n' +
                                '                                <div class="col-xs-12" style="text-align: left; font-size: 16px; font-weight: 700;"><span>' + item.name + '</span>\n' +
                                '                                </div>\n' +
                                '                                <div class="col-xs-4" style="text-align: left; font-size: 12px; margin-top: 10px"><span>收藏:' + item.count + '</span>\n' +
                                '                                </div>\n' +
                                '                                <div class="col-xs-offset-3 col-xs-5" style="text-align: left"><span\n' +
                                '                                        style="color: red;font-size: 20px;">' + item.price + '/小时</span></div>\n' +
                                '                            </div>\n'  +
                                '                           </div>'
                        });
                }
                $('#coach-list').html(html);
            });
}


$(function () {
    getCourseList();
    getCoachList();
});