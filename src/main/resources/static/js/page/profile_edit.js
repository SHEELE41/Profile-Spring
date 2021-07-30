var main = {
    init : function () {
        var _this = this;
        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    update : function () {
        var data = {
            github: $('#userGithub').val(),
            bio: $('#userBio').val(),
            website: $('#userWebsite').val()
        };

        var id = $('#id').text();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/profile/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('프로필이 수정되었습니다.');
            window.location.href = '/profile/'+id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();