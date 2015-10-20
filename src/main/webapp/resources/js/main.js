$(document).ready(function () {
    onStart();
    addEvents();
});

var safeNull = function (value) {
    return value ? value : "-";
};

var makeAnimalTableRow = function (data, delFlag) {
    var deleteIcon = delFlag ? "<td><i class='fa fa-trash del-animal'/></td>" : "";
    return "<tr index='"+ data.id + "'>" +
        "<td>" + data.name + "</td>" +
        "<td>" + data.age + "</td>" +
        "<td>" + data.gender + "</td>" +
        "<td>" + data.type + "</td>" +
        deleteIcon +
        "</tr>"
};

var onStart = function () {
    $.ajax({
        url: $hostRoot + "define/animals",
        type: 'get',
        success: function (data) {
            $("#animals-pre-loader").remove();
            var animalRows = "";
            for (var i = 0; i < data.length; i++) {
                animalRows += makeAnimalTableRow(data[i], true);
            }
            $("#animals-table tbody").html(animalRows);
        },
        error: function (error) {
            console.log(error)
        }
    });
    $("#save-animal, #message-block").hide();
};

var addEvents = function () {
    $("#add-animal").on('click', function () {
        var inputs = {
            name: "<input id='animal-addition-name' type='text' class='form-control'/>",
            age: "<input id='animal-addition-age' type='text' class='form-control'/>",
            gender: "<select id='animal-addition-gender' class='form-control'>" +
            "<option value='MALE'>М</option>" +
            "<option value='FEMALE'>Ж</option>" +
            "</select>",
            type: "<select id='animal-addition-type' class='form-control'>" +
            "<option value='CAT'>Кот</option>" +
            "<option value='DOG'>Пес</option>" +
            "<option value='PIG'>Свинья</option>" +
            "<option value='ELEPHANT'>Слон</option>" +
            "<option value='PITON'>Пипитон</option>" +
            "</select>"
        };
        var row = makeAnimalTableRow(inputs);
        $("#animals-table-modal tbody").append(row);
        $("#save-animal").show();
        $(this).hide();
    });
    $("#save-animal").on('click', function () {
        var data = {
            name: $("#animal-addition-name").val(),
            age: $("#animal-addition-age").val(),
            type: $("#animal-addition-type").val(),
            gender: $("#animal-addition-gender").val()
        };
        $.ajax({
            url: $hostRoot + "add/animal",
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                if (response && response.status == "SUCCESS") {
                    //$("#animals-table tbody tr:last").remove();
                    $("#animals-table tbody").append(makeAnimalTableRow(data, true));
                    //$("#add-animal").show();
                    $("#save-animal").hide();
                    $("#add-animal").show();

                    var animalId = response.id;
                    $("#animals-table tbody tr:last").attr('index', animalId);

                    $("#animals-table-modal tbody tr").remove()

                } else {
                    $("#message-block").show().text("Ошибка! Пожалуйста, повторите попытку через 5 минут.")
                    setTimeout(function () {
                        $("#message-block").hide();
                    }, 5000);
                }
            },
            error: function (error) {
                $("#message-block").show().text("Ошибка! Пожалуйста, повторите попытку через 5 минут.")
                setTimeout(function () {
                    $("#message-block").hide();
                }, 5000);
            }
        });
    });
    $("#animals-table").on('click', ".del-animal", function() {

        var data = {
            id: $(this).parents('tr').attr('index')
        };
        var trrem = $(this).parents('tr').attr('index');

        $.ajax({
            url: $hostRoot + "del/animal",
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                if (response && response.status == "SUCCESS") {

                    $('#animals-table tbody tr[index="'+trrem+'"]')
                        .css('background-color', 'red').fadeToggle("slow");

                    $('#slide').hide();

                } else {
                    $("#message-block").show().text("Ошибка! Пожалуйста, повторите попытку через 5 минут.")
                    setTimeout(function () {
                        $("#message-block").hide();
                    }, 5000);
                }
            },
            error: function (error) {
                $("#message-block").show().text("Ошибка! Пожалуйста, повторите попытку через 5 минут.")
                setTimeout(function () {
                    $("#message-block").hide();
                }, 5000);
            }

        });
    });
};