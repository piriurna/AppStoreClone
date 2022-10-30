package com.piriurna.data.remote

sealed class ASCException(val code : Int?, message : String?) : Exception(message) {
    class NetworkException(code : Int, message : String?) : ASCException(code, message)

    object NoInternetException : ASCException(code = ErrorType.NO_INTERNET.code, message = "No internet connection available")

    class TimeoutException(message : String?) : ASCException(code = ErrorType.TIMEOUT.code, message = message)
}