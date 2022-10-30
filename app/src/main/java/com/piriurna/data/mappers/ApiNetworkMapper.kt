package com.piriurna.data.mappers

import com.piriurna.data.remote.ASCException
import com.piriurna.domain.ApiNetworkError

fun ASCException.toApiNetworkError() : ApiNetworkError {
    return ApiNetworkError(
        code = this.code,
        message = this.message,
        errors = listOf(this.toString())
    )

}