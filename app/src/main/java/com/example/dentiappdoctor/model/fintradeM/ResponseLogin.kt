package com.example.dentiappdoctor.model.fintradeM

import com.example.dentiappdoctor.model.fintradeM.ContentF

data class ResponseLogin (

    var content: ContentF,
    val error : Boolean,
    val msg : String

)