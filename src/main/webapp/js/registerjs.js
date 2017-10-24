$('#username').on('blur',function () {
    var username=$(this).val();
    $.getJSON('check?username='+username,function (json) {
        isValid=json.valid;
        if(isValid){
            $('#isValid').text('√'+json.message).css('color','green');
        }else {
            $('#isValid').text('X'+json.message).css('color','red');
        }
        return isValid;
    });
});

$('#registerForm').on('submit',function (evt) {
    evt.preventDefault();
    if(isValid&&flag){
        this.submit();
    }
});

$('#code').on('click',function () {
    $(this).attr('src', 'code?' + Math.random());
});

function showErrorHint() {
    $('#isValid').text('X').css('color', 'red');
}

function showCorrectHint() {
    $('#isValid').text('√').css('color', 'green');
}

$('#repassword').on('blur',function () {
    var password=$('#password').val();
    var repassword=$('#repassword').val();
    flag=(password==repassword);
    if (flag){
        $('#note').text('√').css('color','green');
    }else{
        $('#note').text('X').css('color','red');
    }
    return flag;
});

/*   $('#username').on('blur', function () {
       var username = $(this).val();
       $.ajax({
           url: 'check',
           data: {'username': username},
           success: function (data) {
               if (data.indexOf('used') >= 0) {
                   showErrorHint();
               } else {
                   showCorrectHint();
               }
           }
       });
   });*/

