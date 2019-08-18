package khalid.com.polls.models.network.response.poll


import khalid.com.polls.models.network.response.poll.Content

data class PollsResponse(
    val content: List<Content>,
    val last: Boolean,
    val page: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int
)