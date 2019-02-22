var member = init();

function init() {
    var member;
    $.ajax({
        url: '/people/list',
        type: "POST",
        dataType: "json",
        async: false,
        success: function (data) {
            if (data.code === 0)
                member = data.peopleEntityList;
            console.log(JSON.stringify(member));
        }
    });
    console.log(member);
    return member;
}

console.log(JSON.stringify(this.member));
