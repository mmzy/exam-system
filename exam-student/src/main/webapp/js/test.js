var singleChoice = {
    1: {
        type: 0, // 0单选，1判断
        ques: '第一题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    2: {
        type: 0,
        ques: '第2题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    3: {
        type: 0,
        ques: '第3题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    4: {
        type: 0,
        ques: '第4题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    5: {
        type: 0,
        ques: '第5题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    6: {
        type: 0,
        ques: '第6题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    7: {
        type: 0,
        ques: '第7题问题描述',
        options: ['答案一', '答案二', '答案三', '答案四'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    }
}
var judgeChoice = {
    8: {
        type: 1,
        ques: '第8题问题描述',
        options: ['是', '否'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    },
    9: {
        type: 1,
        ques: '第9题问题描述',
        options: ['答案一', '答案二'],
        answerIndex: -1,
        trueAnswer: 0,
        mark: false,
        score: 1
    }
}
var Test = {
    submit: function() {
        alert('交卷');
    },
    loadQuesIndex: function(data, type) {
        var str = '';
        for(var i in data) {
            var s
                = '<span class="ques-index-item" '
                + 'onclick="Test.changeQuestion(' + i + ')">'
                + i + '</span>';
            str += s;
        }
        $str = $(str);
        var id = '#single-index';
        if(type === 1) {
            id = '#judge-index';
        }
        $(id).append($str);
    },
    changeQuestion: function(index) {
        var data = singleChoice[index] || judgeChoice[index]
        var quesTypeStr = '单选题';
        if(data.type === 1) {
            quesTypeStr = '判断题';
        }
        $("#quesType").html(quesTypeStr);
        $("#quesScore").html(data.score);
        $("#question").html(data.ques);
        var aswOptions = data.options;
        var ss = '';
        for(var i=0; i<aswOptions.length; i++) {
            var str
                = '<input type="radio" name="asw" value="' + i + '" id="asw' + i + '" />'
                + '<label for="asw' + i + '">' + aswOptions[i] + '</label><br/>';
            ss += str;
        }
        $("#answer").html(ss);
    }
};

$(function() {
    (function(_t) {
        _t.loadQuesIndex(singleChoice, 0);
        _t.loadQuesIndex(judgeChoice, 1);
        var quesNum = Object.keys(singleChoice).length + Object.keys(judgeChoice).length;
        $("#quesNum").html(quesNum);
    })(Test);
});
