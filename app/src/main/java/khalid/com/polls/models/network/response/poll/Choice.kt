package khalid.com.polls.models.network.response.poll


data class Choice(
    val id: Int,
    val text: String,
    val voteCount: Int
)