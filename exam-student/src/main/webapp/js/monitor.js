var Monitor = {
    examStatus: ['考试中', '空闲', '故障'],
    examClass: ['', 'free-status', 'error-status'],
    doLogout: function() {
        alert('logout');
    },
    loadGrid: function(data) {
        var str = '';
        for(var i=0; i<data.length; i++) {
            var s
                = '<tr><td>' + data[i].name + '</td>'
                + '<td>' + data[i].examId + '</td>'
                + '<td>' + data[i].status + '</td></tr>';
            str += s;
        }
        var $Str = $(str);
        $("#exam-body").append($Str);
    },
    loadPersonItem: function(data) {
        var allStr = '';
        for(var i=0; i<data.length; i++) {
            var curStatus = this.examStatus[data[i].status]
            var curStatusClass = this.examClass[data[i].status]
            var itemStr 
                = '<div class="per-item">'
                    + '<div class="first-row">'
                        + '<i class="person-img"></i>'
                        + '<span class="index">' + data[i].index + '</span>'
                        + '<span class="status ' + curStatusClass + '">' + curStatus + '</span>'
                        + '<span class="time">' + (data[i].time || '') + '</span>'
                    + '</div>'
                    + '<div class="second-row">'
                        + '<span class="name">' + (data[i].name || '') + '</span>'
                        + '<i class="sex-icon"></i>'
                    + '</div>'
                    + '<div class="third-row">'
                        + '<span class="exam-label">准考证：</span>'
                        + '<span class="exam-id">' + (data[i].examId || '') + '</span>'
                    + '</div>'
                    + '<div class="fourth-row">'
                        + '<span class="card-label">身份证：</span>'
                        + '<span class="card-id">' + (data[i].cardId || '') + '</span>'
                    + '</div>'
                    + '<div class="fifth-row">'
                        + '<span class="subject-label">科目：</span>'
                        + '<span class="subject-type">' + (data[i].subject || '') + '</span>'
                    + '</div>'
                + '</div>';
            
            allStr += itemStr;
        }
        $items = $(allStr);
        $('#main').append($items);
    }
};

$(function() {
    (function(_m) {
    var gridList = [
        {'name': '张三三', 'examId': '123344', 'status': '已登录'},
        {'name': '张三三', 'examId': '123344', 'status': '已登录'},
        {'name': '张三三', 'examId': '123344', 'status': '已登录'}
    ]
    var personList = [
        {
            index: 2,
            status: 0,
            time: '14:00',
            name: '张三三',
            examId: '123456',
            cardId: '123456789098765543',
            subject: '烟花爆竹生产单位'
        },
        {
            index: 3,
            status: 0,
            time: '14:00',
            name: '张三三',
            examId: '123456',
            cardId: '123456789098765543',
            subject: '烟花爆竹生产单位'
        },
        {
            index: 4,
            status: 1
        },
        {
            index: 5,
            status: 2
        },
        {
            index: 6,
            status: 0,
            time: '14:00',
            name: '张三三',
            examId: '123456',
            cardId: '123456789098765543',
            subject: '烟花爆竹生产单位'
        }
    ];
    _m.loadPersonItem(personList);
    _m.loadGrid(gridList)
    })(Monitor);
})