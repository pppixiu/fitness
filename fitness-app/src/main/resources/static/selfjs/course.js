$(function () {
    var listCourseUrl = '/course/listcourses?rowIndex=1&pageSize=8&courseCondition=null&orderbyByCondition=null';

    function getcourselist() {
        var url = listCourseUrl;

        $
            .getJSON(
                url,
                function (data) {
                    if (data.code == "0") {
                        var courseList = data.data;
                        var html = '';
                        courseList
                            .map(function (item, index) {
                                html += '<div class="shizhan-course-wrap l ">'
                                     + '<a href="courseInfo.html">'
                                     + '</a>'
                                     + '<div class="shizhan-course-box"><a href="//class.imooc.com/sale/webfullstack">'
                                     + '<div class="course-stat new">新课 </div></a>'
                                     + '<div class="box"><a href="courseInfo.html">'
                                     + '<div class="img-box">'
                                     + '<div class="shizhan-course-gradient"></div>'
                                     + '<img class="shizhan-course-img" alt="大前端—前端全能进阶" src="'
                                     + item.url
                                     + '">'
                                     + '<div class="lecturer-info">'
                                     + '<img class="images/a1.jpg" alt="" src="images/a1.jpg">'
                                     + '<span>'
                                     + item.user.username
                                     + '</span> </div> </div> </a>'
                                     + '<div class="shizhan-intro-box"><a href="courseInfo.html">'
                                     + '<a  href="courseInfo.html" style="text-decoration:none;">'
                                     + '<p class="shizan-name" title="大前端—前端全能进阶">'
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
                                     +item.desc
                                     + '</p></a>'
                                     + '</a><div class="shizhan-info-bottom"><a href="//class.imooc.com/sale/webfullstack"></a>'
                                     + '<div class="clearfix"><a href="//class.imooc.com/sale/webfullstack">'
                                     + '<span class="discount-price" style="margin-right: 5px;">￥'
                                     +item.nowprice
                                     + '</span> <del><span class="cost-price"><del>￥'
                                     +item.preprice
                                     + '</del></span></del>'
                                     + '</a><div class="r clearfix"><a href="//class.imooc.com/sale/webfullstack"></a>'
                                     + '<a href="courseInfo.html" style="color:#B7BBBF;line-height: 24px;font-size: 12px;text-decoration:none;">了解详情</a>'
                                     + '</div></div></div></div></div> </div></div>'
                            })

                        $('#course-list').html(html);

                    }
                });
    }


    getcourselist()
});