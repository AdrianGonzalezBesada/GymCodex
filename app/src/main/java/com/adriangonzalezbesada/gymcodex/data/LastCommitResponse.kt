package com.adriangonzalezbesada.gymcodex.data

data class LastCommitResponse(
    val commit: Commit
) {

    data class Commit(
        val message: String
    )

}