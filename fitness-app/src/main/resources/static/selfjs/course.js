/**值的初始化*/
var tagId = 0;
var pageSize=8;
var courseTitle = '';
var orderByCondition=0;
var courseLevel=0;
var pageNum=1;
/**
 * 获得按courseTitle模糊查询的值
 */
function titlefunction() {
    courseTitle = document.getElementById('cou-title').value;
    if(courseTitle == null){
        courseTitle = '';
    }
    getcourselist();
}
function tagIdfunction(e) {
    tagId = e;
    pageNum = 1;
    getcourselist();
}
/**
* 获得价钱排序值
* @param e
*/
function pricefunction(e) {
    orderByCondition = e;
    pageNum = 1;
    getcourselist();
}
/**
 * 获得人气排序值
 * @param e
 */
function countfunction(e) {
    sortId = e;
    pageNum = 1;
    getcourselist();
}

/**
 * 按照courselevel查询
 * @param e
 */
function levelfunction(e) {
    courseLevel = e;
    pageNum = 1;
    getcourselist();
}
function getcourselist() {
    var listCourseUrl = '/course/listcourses?tagId='+tagId+'&pageIndex='+pageNum+'&pageSize='+pageSize+'&courseTitle='+courseTitle+'&orderByCondition='+orderByCondition+'&courseLevel='+courseLevel;
    var url = listCourseUrl;

    $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var courseList = data.data;
                    var html = '';
                    courseList
                        .map(function (item, index) {
                            html += '<div class="shizhan-course-wrap l ">'
                                + '<a href=""></a>'
                                + '<div class="shizhan-course-box"><a href="//class.imooc.com/sale/webfullstack">'
                                + '<div class="course-stat new">新课 </div></a>'
                                + '<div class="box"><a href="#">'
                                + '<div class="img-box">'
                                + '<div class="shizhan-course-gradient"></div>'
                                + '<a href="courseInfo/?courseId='
                                + item.id
                                + '"><img class="shizhan-course-img" alt="大前端—前端全能进阶" src="'
                                + item.url
                                + '"></a>'
                                + '<div class="lecturer-info">'
                                + '<img class="images/a1.jpg" alt="" src="/images/a1.jpg">'
                                + '<span>'
                                + item.user.username
                                + '</span> </div> </div> </a>'
                                + '<div class="shizhan-intro-box"><a href="courseInfo/?courseId='
                                + item.id
                                + '"style="text-decoration:none;">'
                                + '<p class="shizan-name" title="大前端—前端全能进阶" style="overflow: hidden; height: 24px;">'
                                + item.title
                                + '</p></a>'
                                + '<div class="evaluation-box">'
                                + '<div class="shizhan-info">'
                                + '<span class="grade">'
                                + item.level
                                + '</span>'
                                + '<span>'
                                + item.count
                                + '</span>'
                                + '<span class="r">'
                                + item.coursetime
                                + '</span></div>'
                                + '<div class="evaluation-desc-box clearfix">'
                                + '<i class="trangle"></i>'
                                + '<div class="left-box l">'
                                + '<p>好评度</p>'
                                + '<p class="big-text">100%</p><p>3人评价</p></div>'
                                + '<div class="right-box l">'
                                + '<p>内容实用<span>10</span></p>'
                                + '<p>通俗易懂<span>10</span></p>'
                                + '<p>逻辑清晰<span>10</span></p></div></div> </div>'
                                + '<a style="text-decoration:none;"><p class="shizan-desc" title="专为实际开发经验1年以上的前端工程师职场进阶设计，更高层面架构前端。">'
                                + item.desc
                                + '</p></a>'
                                + '</a><div class="shizhan-info-bottom"><a href="#"></a>'
                                + '<div class="clearfix"><a href="#">'
                                + '<span class="discount-price" style="margin-right: 5px;">￥'
                                + item.nowprice
                                + '</span> <del><span class="cost-price"><del>￥'
                                + item.preprice
                                + '</del></span></del>'
                                + '</a><div class="r clearfix"><a href="#"></a>'
                                + '<a href="courseInfo/?courseId='
                                + item.id
                                + '" style="color:#B7BBBF;line-height: 24px;font-size: 12px;text-decoration:none;">了解详情</a>'
                                + '</div></div></div></div></div> </div></div>'
                        });
                    $('#course-button').html('<button class="corner-button" onclick="nextPage()">\n' +
                        '                    <span>加载更多</span>\n' +
                        '                </button>');
                } else {
                    html = '<div style="height: 550px; text-align: center; line-height: 550px; font-size: 20px;" >好像还没有发布过动态哦</div>';
                    $('#course-button').html('');
                }
                $('#course-list').html(html);
                pageNum += 1;

            });

}
function addItems(pageSize, pageIndex) {
    // 生成新条目的URL
    var listCourseUrl = '/course/listcourses?tagId='+tagId+'&pageIndex='+pageNum+'&pageSize='+pageSize+'&courseTitle='+courseTitle+'&orderByCondition='+orderByCondition+'&courseLevel='+courseLevel;
    var url = listCourseUrl;
    var html = '';
    loading = true;
    $.getJSON(
        url,
        function (data) {
            if (data.code == "0") {
                var courseList = data.data;
                var html = '';
                courseList
                    .map(function (item, index) {
                        html += '<div class="shizhan-course-wrap l ">'
                            + '<a href="#"></a>'
                            + '<div class="shizhan-course-box"><a href="//class.imooc.com/sale/webfullstack">'
                            + '<div class="course-stat new">新课 </div></a>'
                            + '<div class="box"><a href="courseInfo.html">'
                            + '<div class="img-box">'
                            + '<div class="shizhan-course-gradient"></div>'
                            + '<a href="courseInfo/?courseId='
                            + item.id
                            + '"><img class="shizhan-course-img" alt="大前端—前端全能进阶" src="'
                            + item.url
                            + '"></a>'
                            + '<div class="lecturer-info">'
                            + '<img class="images/a1.jpg" alt="" src="images/a1.jpg">'
                            + '<span>'
                            + item.user.username
                            + '</span> </div> </div> </a>'
                            + '<div class="shizhan-intro-box"><a href="courseInfo/?courseId='
                            + item.id
                            + '"style="text-decoration:none;">'
                            + '<p class="shizan-name" title="大前端—前端全能进阶" style="overflow: hidden; height: 24px;">'
                            + item.title
                            + '</p></a>'
                            + '<div class="evaluation-box">'
                            + '<div class="shizhan-info">'
                            + '<span class="grade">'
                            + item.level
                            + '</span>'
                            + '<span>'
                            + item.count
                            + '</span>'
                            + '<span class="r">3人评价</span></div>'
                            + '<div class="evaluation-desc-box clearfix">'
                            + '<i class="trangle"></i>'
                            + '<div class="left-box l">'
                            + '<p>好评度</p>'
                            + '<p class="big-text">100%</p><p>3人评价</p></div>'
                            + '<div class="right-box l">'
                            + '<p>内容实用<span>10</span></p>'
                            + '<p>通俗易懂<span>10</span></p>'
                            + '<p>逻辑清晰<span>10</span></p></div></div> </div>'
                            + '<a style="text-decoration:none;"><p class="shizan-desc" title="专为实际开发经验1年以上的前端工程师职场进阶设计，更高层面架构前端。">'
                            + item.desc
                            + '</p></a>'
                            + '</a><div class="shizhan-info-bottom"><a href="//class.imooc.com/sale/webfullstack"></a>'
                            + '<div class="clearfix"><a href="//class.imooc.com/sale/webfullstack">'
                            + '<span class="discount-price" style="margin-right: 5px;">￥'
                            + item.nowprice
                            + '</span> <del><span class="cost-price"><del>￥'
                            + item.preprice
                            + '</del></span></del>'
                            + '</a><div class="r clearfix"><a href="//class.imooc.com/sale/webfullstack"></a>'
                            + '<a href="courseInfo/?courseId='
                            + item.id
                            + '" style="color:#B7BBBF;line-height: 24px;font-size: 12px;text-decoration:none;">了解详情</a>'
                            + '</div></div></div></div></div> </div></div>'
                    });
            } else {
                $('#course-button').html('<div class="col-md-12" style="font-size: 30px; text-align: center; background-color: white">\n' +
                    '                   no more\n' +
                    '                </div>');
            }

            $('#course-list').append(html);
            pageNum += 1;

        });
}
function nextPage() {
    addItems(pageSize, pageNum);
}

$(function () {
    getcourselist();
});