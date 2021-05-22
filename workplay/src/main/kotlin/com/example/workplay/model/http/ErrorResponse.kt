package com.example.workplay.model.http

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class ErrorResponse(
    var resultCode:String?=null,
    var httpStatus:String?=null,
    var httpMethod:String?=null,
    var message:String?=null,
    var path:String?=null,
    var timestamp:LocalDateTime?=null,
    var errors:MutableList<Error>?=null

)

data class Error(
    var field:String?=null,
    var message:String?=null,
    var value:Any?=null
)