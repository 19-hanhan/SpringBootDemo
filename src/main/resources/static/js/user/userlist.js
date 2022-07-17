$.ajax({
    url: '/user/userlist.do',
    type: 'POST',
    dataType: "json",
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify({
        "list": [
            {
                "username": "Ander1",
                "password": "pwd"
            },
            {
                "username": "Ander2",
                "password": "pwd"
            },
            {
                "username": "Ander3",
                "password": "pwd"
            },
            {
                "username": "Ander4",
                "password": "pwd"
            },
            {
                "username": "Ander5",
                "password": "pwd"
            },
            {
                "username": "Ander6",
                "password": "pwd"
            }
        ],
        "cnt": 6
    }),
    success: function (jdata) {
        console.log(jdata);
        var html = '';
        jdata.data.list.map(function (item, index) {
            html += '<' + index + '>:' + item.username + ',' + item.password + '<br>'
        });
        $("#userlist").html(html);
    }
})