function son() {
    let count=document.getElementById("son").value;
    // console.log(document.getElementById("son").value)
    if (!(count===""||count<2||count>10)){

        localStorage.setItem("son",""+document.getElementById("son").value);
        let a="<div class=\"row text-center d-flex justify-content-center mt-2\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-10)\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-10)\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-100)\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-100)\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-100)\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-100)\">\n" +
            "                <input class=\"form-control w-25 col-1\" placeholder=\"(2-100)\">\n" +
            "            </div>";

        let out="";
        let t1="<h5>Berilgan tartib</h5>" +
            "<div class=\"row text-center d-flex justify-content-center mt-2\">";
        let t2="<h5>Qidirilayotgan tartib</h5>" +
            "<div class=\"row text-center d-flex justify-content-center mt-2\">";

        for (let i = 0; i < count; i++) {
            t1+="<input id='"+i+"' class=\"form-control w-25 col-1\" placeholder=\"(2-10)\">";
            t2+="<input id='"+"q"+i+"' class=\"form-control w-25 col-1\" placeholder=\"(2-10)\">";

        }
        t1+="</div>";
        t2+="</div>";
        out+=t1+t2+"" +
            "<div class=\"row text-center d-flex justify-content-center\">\n" +
            "                <button class=\"btn-success btn\" onclick=\"gets1s2()\">Boshlash</button>\n" +
            "            </div>";

        document.getElementById("root1").innerHTML=out;

    }

}

function gets1s2() {
    let count=localStorage.getItem("son");
    let s1=[];
    let s2=[];
    for (let i = 0; i < count; i++) {
        s1[i]=document.getElementById(""+i).value;
        s2[i]=document.getElementById("q"+i).value;
    }
    // console.log(s1)
    // console.log(s2)

    let arrayModel={
        s1:s1,
        s2:s2
    }
    axios.post("api/hill", arrayModel)
        .then(function (response) {
            let a=JSON.parse(JSON.stringify(response.data))
            let p="";

            console.log(a)
            // for (let i = 0; i < a.length; i++) {
            //     let r="<div class=\"col-12\">";
            //
            //     for (let j = 0; j <a[i].length ; j++) {
            //         // r+=" "+a[i].[]
            //         console.log(a)
            //     }
            // }

        })
}



// function temp() {
//     console.log(localStorage.getItem("son"));
// }