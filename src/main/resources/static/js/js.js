
function getSimple() {
    document.getElementById("root").innerHTML="    <section id=\"simple\" class=\"mt-5 p-2 shadow row w-75 text-center d-flex justify-content-center\" style=\"background-color: #cdcdcd\">\n" +
        "        <p class=\"col-12\" style=\"font-style: oblique\">Oddiy usul</p>\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"tempratura\">Bahorda haroratning kelishi:</label>\n" +
        "            <select class=\"custom-select\" name=\"tempratura\" id=\"tempratura\">\n" +
        "                <option value=\"1\">Harorat vaqtida isidi</option>\n" +
        "                <option value=\"0\">Harorat kech isidi</option>\n" +
        "            </select>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"rain\">Bahorda yomg'ir yog'ishi:</label>\n" +
        "            <select class=\"custom-select\" name=\"rain\" id=\"rain\">\n" +
        "                <option value=\"1\">Yetarli yog'di</option>\n" +
        "                <option value=\"0\">Yetarli yog'madi</option>\n" +
        "            </select>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"ishlov\">Yerga ishlov berilish:</label>\n" +
        "            <select class=\"custom-select\" name=\"ishlov\" id=\"ishlov\">\n" +
        "                <option value=\"1\">Yaxshi ishlov berilgan</option>\n" +
        "                <option value=\"0\">Yaxshi ishlov berilmagan</option>\n" +
        "            </select>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"nuri\">O'g'it berish:</label>\n" +
        "            <select class=\"custom-select\" name=\"nuri\" id=\"nuri\">\n" +
        "                <option value=\"1\">Yetarli berilgan</option>\n" +
        "                <option value=\"0\">Yetarli berilmagan</option>\n" +
        "            </select>\n" +
        "        </div>\n" +
        "\n" +
        "        <button onclick='getSimpleValues()' class=\"btn btn-success col-md-6\">Hisoblash</button>\n" +
        "<div id=\"natija\" class=\"mt-3 col-12\">\n" +
        "</div>"
        "    </section>\n";
}

function getOptimization() {

    document.getElementById("root").innerHTML="    <section id=\"optimization\" class=\"mt-5 p-2 shadow row w-75 text-center d-flex justify-content-center\" style=\"background-color: #cdcdcd\">\n" +
        "        <p class=\"col-12\" style=\"font-style: oblique\">Optimizatsiyalangan usul (Dalillarni kuchi 1 va 100 oralig'ida ifodalanadi)</p>\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"tempraturaO\">Bahorda haroratning kelishi:</label>\n" +
        "            <input type=\"number\" class=\"form-control\" placeholder=\"0 dan 100 gacha kiriting\" name=\"tempraturaO\" id=\"tempraturaO\">\n" +
        "            </input>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"rainO\">Bahorda yomg'ir yog'ishi:</label>\n" +
        "            <input type=\"number\" class=\"form-control\" placeholder=\"0 dan 100 gacha kiriting\" name=\"rainO\" id=\"rainO\">\n" +
        "            </input>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"ishlovO\">Yerga ishlov berilish:</label>\n" +
        "            <input type=\"number\" class=\"form-control\" placeholder=\"0 dan 100 gacha kiriting\" name=\"ishlovO\" id=\"ishlovO\">\n" +
        "            </input>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"col-md-6 col-sm-12 border mt-2 p-2\">\n" +
        "            <label for=\"nuriO\">O'g'it berish:</label>\n" +
        "            <input type=\"number\" class=\"form-control\" placeholder=\"0 dan 100 gacha kiriting\" name=\"nuriO\" id=\"nuriO\">\n" +
        "            </input>\n" +
        "        </div>\n" +
        "\n" +
        "        <button onclick='getOptimizationValues()' class=\"btn btn-success col-md-6\">Hisoblash</button>\n" +
        "<div id=\"natija\" class=\"mt-3 col-12\">\n" +
        "</div>"
        "    </section>\n";

}

function getSimpleValues() {
    let tempratura=parseInt(document.getElementById("tempratura").value);
    let rain=parseInt(document.getElementById("rain").value);
    let ishlov=parseInt(document.getElementById("ishlov").value);
    let nuri=parseInt(document.getElementById("nuri").value);

    let out=((tempratura+rain+ishlov+nuri)/4)*100;

    document.getElementById("natija").innerHTML="<h5>Hosilning yaxshi bo'lishi (foizda) :</h5>\n" +
        "        <h5 style=\"font-weight: bold\">"+out+" %</h5>";


}

function getOptimizationValues() {
    let tempratura=parseInt(document.getElementById("tempraturaO").value);
    let rain=parseInt(document.getElementById("rainO").value);
    let ishlov=parseInt(document.getElementById("ishlovO").value);
    let nuri=parseInt(document.getElementById("nuriO").value);
    console.log(tempratura);

    if (tempratura>100||tempratura<1||rain>100||rain<1||ishlov>100||ishlov<1||nuri>100||nuri<1||isNaN(tempratura)||isNaN(rain)||isNaN(ishlov)||isNaN(nuri)){
        document.getElementById("natija").innerHTML="<h5 style='color: red'>Noto'g'ri qiymat kiritilgan! (Qiymatlar 1 va 100 oralig'ida bo'lishi zarur)</h5>\n";
    }
    else {
        let out=((tempratura+rain+ishlov+nuri)/4);

        document.getElementById("natija").innerHTML="<h5>Hosilning yaxshi bo'lishi (foizda) :</h5>\n" +
            "        <h5 style=\"font-weight: bold\">"+out+" %</h5>";
    }


}