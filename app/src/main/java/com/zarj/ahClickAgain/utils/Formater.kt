package com.zarj.ahClickAgain.utils

fun formatNumb(num : Long):String {
    var text : String= "$num"
    if(num<1000){
        text = "$num"
    }else if(num<1000000){
        text = ""+num/1000+"."+num%1000/100+"k"
    }else if(num<1000000000){
        text = ""+num/1000000+"."+num%1000000/100000+"m"
    }else if(num<1000000000000){
        text = ""+num/1000000000+"."+num%1000000000/100000000+"b"
    }else if(num<1000000000000000){
        text = ""+num/1000000000000+"."+num%1000000000000/100000000000+"t"
    }
    return text;
}
fun formatNumb(num : Int):String {
    var text : String= "$num"
    if(num<1000){
        text = "$num"
    }else if(num<1000000){
        text = ""+num/1000+"."+num%1000/100+"k"
    }else if(num<1000000000){
        text = ""+num/1000000+"."+num%1000000/100000+"m"
    }else if(num<1000000000000){
        text = ""+num/1000000000+"."+num%1000000000/100000000+"b"
    }
    return text;
}