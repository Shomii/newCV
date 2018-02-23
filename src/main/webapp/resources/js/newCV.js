function PreviewImage(no) {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(document.getElementById("uploadImage" + no).files[0]);
    oFReader.onload = function (oFREvent) {
        document.getElementById("uploadPreview" + no).src = oFREvent.target.result;
    };
}

$(function () {
    $('.datepicker').datepicker({
        format: 'MM-yyyy',
        startView: "months",
        minViewMode: "months",
        clearBtn: true
    });
    $('.datepicker2').datepicker({
        format: 'dd-mm-yyyy',
        clearBtn: true
    });
});

$(document).ready(function () {
    $("#language1").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divLanguage2").fadeIn("slow");
        } else
        {
            $("#divLanguage2").fadeOut("slow");
        }
    });
    $("#language2").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divLanguage3").fadeIn("slow");
        } else
        {
            $("#divLanguage3").fadeOut("slow");
        }
    });
    $("#language3").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divLanguage4").fadeIn("slow");
        } else
        {
            $("#divLanguage4").fadeOut("slow");
        }
    });
    $("#workExperience1").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divJob2").fadeIn("slow");
        } else
        {
            $("#divJob2").fadeOut("slow");
        }
    });
    $("#workExperience2").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divJob3").fadeIn("slow");
        } else
        {
            $("#divJob3").fadeOut("slow");
        }
    });
    $("#workExperience3").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divJob4").fadeIn("slow");
        } else
        {
            $("#divJob4").fadeOut("slow");
        }
    });
    $("#education1").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSchool2").fadeIn("slow");
        } else
        {
            $("#divSchool2").fadeOut("slow");
        }
    });
    $("#education2").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSchool3").fadeIn("slow");
        } else
        {
            $("#divSchool3").fadeOut("slow");
        }
    });
    $("#education3").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSchool4").fadeIn("slow");
        } else
        {
            $("#divSchool4").fadeOut("slow");
        }
    });
    $("#courses1").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divCourses2").fadeIn("slow");
        } else
        {
            $("#divCourses2").fadeOut("slow");
        }
    });
    $("#courses2").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divCourses3").fadeIn("slow");
        } else
        {
            $("#divCourses3").fadeOut("slow");
        }
    });
    $("#courses3").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divCourses4").fadeIn("slow");
        } else
        {
            $("#divCourses4").fadeOut("slow");
        }
    });
    $("#skill1").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSkill2").fadeIn("slow");
        } else
        {
            $("#divSkill2").fadeOut("slow");
        }
    });
    $("#skill2").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSkill3").fadeIn("slow");
        } else
        {
            $("#divSkill3").fadeOut("slow");
        }
    });
    $("#skill3").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSkill4").fadeIn("slow");
        } else
        {
            $("#divSkill4").fadeOut("slow");
        }
    });
    $("#skill1").keyup(function () {
        var id = $(this).val();
        if ((id).length > 3) {
            $("#divSkill1").fadeIn("slow");
        } else
        {
            $("#divSkill1").fadeOut("slow");
        }
    });

});

$(document).on('click', '#close-preview', function () {
    $('.image-preview').popover('hide');
    // Hover befor close the preview
    $('.image-preview').hover(
            function () {
                $('.image-preview').popover('show');
            },
            function () {
                $('.image-preview').popover('hide');
            }
    );
});

$(function () {
    // Create the close button
    var closebtn = $('<button/>', {
        type: "button",
        text: 'x',
        id: 'close-preview',
        style: 'font-size: initial;',
    });
    closebtn.attr("class", "close pull-right");
    // Set the popover default content
    $('.image-preview').popover({
        trigger: 'manual',
        html: true,
        title: "<strong>Preview</strong>" + $(closebtn)[0].outerHTML,
        content: "There's no image",
        placement: 'bottom'
    });
    // Clear event
    $('.image-preview-clear').click(function () {
        $('.image-preview').attr("data-content", "").popover('hide');
        $('.image-preview-filename').val("");
        $('.image-preview-clear').hide();
        $('.image-preview-input input:file').val("");
        $(".image-preview-input-title").text("Browse");
    });
    // Create the preview image
    $(".image-preview-input input:file").change(function () {
        var img = $('<img/>', {
            id: 'dynamic',
            width: 250,
            height: 200
        });
        var file = this.files[0];
        var reader = new FileReader();
        // Set preview image into the popover data-content
        reader.onload = function (e) {
            $(".image-preview-input-title").text("Change");
            $(".image-preview-clear").show();
            $(".image-preview-filename").val(file.name);
            img.attr('src', e.target.result);
            $(".image-preview").attr("data-content", $(img)[0].outerHTML).popover("show");
        }
        reader.readAsDataURL(file);
    });
});

var i = 0;

function duplicate(idValue) {

    if (idValue == 'duplicater' + i) {
        var original = document.getElementById('duplicater' + i);
        var clone = original.cloneNode(true);
        clone.id = "duplicater" + ++i;
        original.parentNode.appendChild(clone);
    }
}   