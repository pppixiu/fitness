$(function () {
    var courseLessonUrl = '/course/listcoursebyid?courseId=438';

    function getcourselesson() {
        var url = courseLessonUrl;

        $
            .getJSON(
                url,
                function (data) {
                    if (data.code == "0") {
                        var courseLesson = data.data;
                        var html = '';
                        $('#course-title').text(courseLesson.title);
                        $('#user-img').attr("src",courseLesson.user.imgurl);
                        $('#user-name').text(courseLesson.user.username);
                        $('#course-level').text(courseLesson.level);
                        $('#course-time').text(courseLesson.time);
                        $('#study-count').text(courseLesson.count);
                        $('#course-desc').text(courseLesson.desc);


                        courseLesson
                            .map(function (item, index) {
                                html += ' <div class="chapter course-wrap " style=" margin-bottom: 8px;padding: 24px 32px 32px;background: #fff;box-shadow: 0 8px 16px 0 rgba(7,17,27,.1);border-radius: 12px;">'
                                     + '<h3> <a style="text-decoration: none;">'
                                     + item.courseLesson.lessontitle
                                     + '</a>'
                                     + '</h3>'
                                     + '<div class="chapter-description" style="margin-top: 2px;font-size: 12px;color: #545c63;line-height: 18px;">'
                                     + item.courseLesson.lessondesc
                                     + '</div></div>'
                            })

                        $('#course-lesson').html(html);

                    }
                });
    }


    getcourselist()
});