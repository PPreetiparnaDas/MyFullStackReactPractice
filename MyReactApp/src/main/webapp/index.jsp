<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "DataServlet",  // Your servlet URL
            type: "GET",
            dataType: "json",
            success: function (response) {
                console.log(response); // Check JSON response in console
                let output = "<ul>";
                response.forEach(function (item) {
                    output += "<li>" + item + "</li>";
                });
                output += "</ul>";
                $("#dataContainer").html(output);
            },
            error: function (xhr, status, error) {
                console.error("Error fetching data:", error);
            }
        });
    });
</script>
<div id="dataContainer"></div>
 -->