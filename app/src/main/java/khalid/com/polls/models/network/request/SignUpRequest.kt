package khalid.com.polls.models.network.request


data class SignUpRequest(
    val email: String,
    val name: String,
    val password: String,
    val username: String
)