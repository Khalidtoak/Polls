package khalid.com.polls.models.network.response.auth

data class AuthResponse(
    val accessToken: String,
    val message: String,
    val success: Boolean,
    val tokenType: String
)