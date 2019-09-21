$(function () {
    var listTagNameUrl = '/course/tagname';

    function gettagnamelist() {
        var url = listTagNameUrl;

        $.getJSON(
                url,
                function (data) {
                    if (data.code == "0") {
                        var tagNameList = data.data;
                        var html = '';
                        tagNameList
                            .map(function (item, index) {
                                html += '<a href="#" ONCLICK="tagIdfunction('
                                     + item.tagId
                                     + ')"style="color: black; text-decoration: none;margin-right: 12px;">'
                                     + item.tagName
                                     + '</a>'
                            })

                        $('#tagname-list').html(html);

                    }
                });
    }

     gettagnamelist();

});