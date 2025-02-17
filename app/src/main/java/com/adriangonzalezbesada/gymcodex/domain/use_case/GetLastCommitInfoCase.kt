package com.adriangonzalezbesada.gymcodex.domain.use_case

import com.adriangonzalezbesada.gymcodex.data.LastCommitResponse
import com.adriangonzalezbesada.gymcodex.network.CommitAPIImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GetLastCommitInfoCase @Inject constructor(
    private val commitAPIImpl: CommitAPIImpl

) {

    suspend fun execute(): Response<LastCommitResponse> = withContext(Dispatchers.IO) {

        commitAPIImpl.getLastCommitInfo()
    }
}