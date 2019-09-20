$(function () {
    var coachInfoUrl = '/coach/coachInfo';

    function coachInfo() {
        var url = coachInfoUrl;

        $.getJSON(
            url,
            function (data,index) {
                if (data.code == "0") {
                    var info = data.data;
                     $('#coach-name').text(info[0].coachname);
                     $('#coach-desc').text(info[0].coachdesc);
                     $('#coach-count').text(info[0].count);
                }
            });
    }
    coachInfo();
});