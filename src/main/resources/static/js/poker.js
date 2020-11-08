
function check_my_hand(hand) {
    axios.post("/api/check/hand", hand)
        .then(function (response) {
            document.getElementById("my_rank").innerText="Sizda: "+response.data;
        })
}

function start() {

    let temp="<div class=\"col-2 m-4\">\n" +
        "\n" +
        "            <div class=\"mt-5\">\n" +
        "                <p>Bu yerda ism<br>100</p>\n" +
        "            </div>\n" +
        "\n" +
        "            <div class=\"row\">\n" +
        "                <div class=\"col border\">2 &#9830</div>\n" +
        "                <div class=\"col border\">2 &#9830</div>\n" +
        "                <div class=\"col border\">2 &#9830</div>\n" +
        "                <div class=\"col border\">2 &#9830</div>\n" +
        "                <div class=\"col border\">2 &#9830</div>\n" +
        "            </div>\n" +
        "\n" +
        "\n" +
        "        </div>";

    axios.get("/api/generate", {
        params: {
            count: document.getElementById("count").value
        }
    })
        .then(function (response) {

            let ab=JSON.parse(JSON.stringify(response.data));
            localStorage.setItem('residue', JSON.stringify(ab.cards));
            localStorage.setItem('my_hand', JSON.stringify(ab.hands[ab.hands.length-1]));
            localStorage.setItem('all',JSON.stringify(ab));
            localStorage.setItem('change_count',0);


            document.getElementById('zz').innerHTML="<p id=\"my_rank\"></p>\n" +
                "        <h4 class=\"zz\">Qaysi kartani almashtirmoqchisiz? (1-5)</h4>\n" +
                "        <input type=\"number\" id=\"change_value\" class=\"form-group zz\" placeholder=\"tartib\">\n" +
                "        <button onclick=\"change()\" class=\"btn btn-success zz\">Almashtirish</button>\n" +
                "        <button onclick=\"cancel()\" class=\"btn btn-success\">Tugatish</button>\n" +
                "        <p id=\"error\" class=\"zz\"></p>";


            check_my_hand(ab.hands[ab.hands.length-1])
            var checkBox = document.getElementById("ch");
            checkBox.checked=false;

            let out="";
            let ids={};
            for (let i = 0; i <ab.hands.length; i++) {
                if (i!==ab.hands.length-1)
                ids[i]=ab.hands[i].name+"1";

                if (ab.hands[i].name!=="Siz"){
                    out+="<div id='"+ab.hands[i].name+"' class=\"col-lg-2 col-md-4 col-sm-12 m-4 w-100\">\n" +
                        "\n" +
                        "            <div class=\"mt-5\">\n" +
                        "                <p>"+ab.hands[i].name+"</p>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div style='border: 1px solid black; height: 50px; width: 175px' id='"+ab.hands[i].name+1+"' class=\"row border shadow\">\n" +
                        "                <div style='color: "+ab.hands[i].cards[0].color+"; display: none; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center h\">"+ab.hands[i].cards[0].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[1].color+"; display: none; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center h\">"+ab.hands[i].cards[1].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[2].color+"; display: none; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center h\">"+ab.hands[i].cards[2].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[3].color+"; display: none; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center h\">"+ab.hands[i].cards[3].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[4].color+"; display: none; background-color: #e5e5e5; border: 1px solid black;' class=\"col-3 w-100 text-center h\">"+ab.hands[i].cards[4].symbol+"</div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "\n" +
                        "        </div>";
                }
                else {
                    out="<div id='"+ab.hands[i].name+"' class=\"col-lg-2 col-md-4 col-sm-12 m-4 w-100\">\n" +
                        "\n" +
                        "            <div class=\"mt-5\">\n" +
                        "                <p>"+ab.hands[i].name+"</p>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div style='border: 1px solid black; height: 50px; width: 175px' id='"+ab.hands[i].name+1+"' class=\"row border shadow\">\n" +
                        "                <div style='color: "+ab.hands[i].cards[0].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ab.hands[i].cards[0].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[1].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ab.hands[i].cards[1].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[2].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ab.hands[i].cards[2].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[3].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ab.hands[i].cards[3].symbol+"</div>\n" +
                        "                <div style='color: "+ab.hands[i].cards[4].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-3 w-100 text-center\">"+ab.hands[i].cards[4].symbol+"</div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "\n" +
                        "        </div>"+out;
                }


            }
            localStorage.setItem('ids',JSON.stringify(ids));


            document.getElementById("root").innerHTML=out;




            console.log(ab);
        })
}

function change() {
    let index=document.getElementById("change_value").value;
    console.log(index);
    if (index==null||index===""){
        document.getElementById("error").innerHTML="To'ldirish shart!";
    } else if (index >= 0 && index <= 5 && index-Math.round(index)===0){

            document.getElementById("error").innerHTML="";
            console.log(JSON.parse(localStorage.getItem('residue')));
            console.log(JSON.parse(localStorage.getItem('my_hand')));

            let changeDto={
                hand:JSON.parse(localStorage.getItem('my_hand')),
                cards:JSON.parse(localStorage.getItem('residue')),
                index:index-1
            }
            console.log(changeDto);
            axios.post("/api/change",changeDto)
                .then(function (response) {
                    localStorage.setItem('change_count',parseInt(localStorage.getItem('change_count'))+1);
                    console.log(JSON.parse(JSON.stringify(response.data)));
                    let ar=JSON.parse(JSON.stringify(response.data));
                    console.log(localStorage.getItem("change_count"));
                    localStorage.setItem('residue', JSON.stringify(ar.residue_cards));
                    localStorage.setItem('my_hand', JSON.stringify(ar.hand));
                    let all=JSON.parse(localStorage.getItem('all'));
                    all.hands[all.hands.length-1]=ar.hand;
                    all.cards=ar.residue_cards;
                    // console.log("all")
                    // console.log(all);
                    localStorage.setItem('all',JSON.stringify(all));
                    let data= "<div class=\"mt-5\">\n" +
                        "                <p>"+ar.hand.name+"</p>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div style='border: 1px solid black; height: 50px; width: 175px' class=\"row border shadow\">\n" +
                        "                <div style='color: "+ar.hand.cards[0].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ar.hand.cards[0].symbol+"</div>\n" +
                        "                <div style='color: "+ar.hand.cards[1].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ar.hand.cards[1].symbol+"</div>\n" +
                        "                <div style='color: "+ar.hand.cards[2].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ar.hand.cards[2].symbol+"</div>\n" +
                        "                <div style='color: "+ar.hand.cards[3].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-2 w-100 text-center\">"+ar.hand.cards[3].symbol+"</div>\n" +
                        "                <div style='color: "+ar.hand.cards[4].color+"; background-color: #e5e5e5; border: 1px solid black;' class=\"col-3 w-100 text-center\">"+ar.hand.cards[4].symbol+"</div>\n" +
                        "</div>\n";
                    document.getElementById("Siz").innerHTML=data;
                    check_my_hand(ar.hand);
                })
        if (parseInt(localStorage.getItem('change_count'))===2){
            document.getElementById('zz').innerHTML="" +
                "<button onclick=\"cancel()\" class=\"btn btn-success mb-2\">Tugatish</button>";
        }

        }
        else {
            document.getElementById("error").innerHTML="Karta tartib raqami 1-5 oralig'ida butun bo'lishi kerak!";
        }
    
}

function view_other_cards() {
    var checkBox = document.getElementById("ch");
    let ids=JSON.parse(localStorage.getItem('ids'));
    console.log(ids);
    var cname=document.getElementsByClassName('h');
    if (checkBox.checked===true){

        for (let i = 0; i <ids.length; i++) {

            // document.getElementById(ids[i]).style.display='block';
            // var c=document.getElementById(""+ids[i]).children;
            // for (let i = 0; i <c.length ; i++) {
            //     c[i].style.display='block';
            // }
        }


        for (let i = 0; i <cname.length; i++) {
            cname[i].style.display='block';
        }
        // document.getElementById('0-bot1').children.style.display='none';
        // document.getElementById("root").innerHTML="";
        console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    } else {
        for (let i = 0; i <ids.length; i++) {

            // document.getElementById(ids[i]).style.display='none';
            // var c=document.getElementById(""+ids[i]).children;
            // for (let i = 0; i <c.length ; i++) {
            //     c[i].style.display='none';
            // }
        }
        for (let i = 0; i <cname.length; i++) {
            cname[i].style.display='none';
        }

        // document.getElementById('0-bot1').children.style.display='none';
        // document.getElementById("root").innerHTML="";
        console.log("bbbbbbbbbbbbbbbbbbbbbb")
    }

}

function cancel() {
    axios.post("api/check/all", JSON.parse(localStorage.getItem('all')).hands)
        .then(function (response) {
            console.log(response.data);

            let final_rank=JSON.parse(JSON.stringify(response.data));

            let natija="";
            var j=final_rank.length-1;
            var k;
            for (let i = 0; i <final_rank.length; i++) {
                // if (final_rank[j].hand.name==="Siz") k=j;
                natija+=i+1+"-o'rin : "+final_rank[j].hand.name+" : "+final_rank[j].name+"\n";
                j--;
            }
            if (final_rank[final_rank.length-1].hand.name==="Siz"){
                alert("Siz yutdingiz!\n"+natija)
            } else alert("Siz yutqazdingiz!\n"+natija)



            document.getElementById('zz').innerHTML="";
            document.getElementById('start').textContent="Yangi o'yin boshlash";
            document.getElementById('ch').checked=true;
            view_other_cards();
        })
}


