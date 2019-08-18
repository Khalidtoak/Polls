package khalid.com.polls.models.network.response.poll


data class Content(
    val choices: List<Choice>,
    val createdBy: CreatedBy,
    val creationDateTime: String,
    val expirationDateTime: String,
    val expired: Boolean,
    val id: Int,
    val question: String,
    val selectedChoice: Int,
    val totalVotes: Int
)