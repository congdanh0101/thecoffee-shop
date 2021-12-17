$(document).ready(function() {
    $('#edit-btn').click(function() {
        $("input[name='editName']").removeAttr("readonly");
    });
});

$(document).ready(function() {
    $('#edit-btn').click(function() {
        $("input[name='editPrice']").removeAttr("readonly");
    });
});

$(document).ready(function() {
    $('#edit-btn').click(function() {
        $("input[name='editDescription']").removeAttr("readonly");
    });
});

$(document).ready(function() {
    $('#edit-btn').click(function() {
        $("select[name='editCategory']").removeAttr("disabled");
    });
});