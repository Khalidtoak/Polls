package khalid.com.polls.models.network.request


data class LoginRequest(
    val password: String,
    val userNameOrEmail: String
)