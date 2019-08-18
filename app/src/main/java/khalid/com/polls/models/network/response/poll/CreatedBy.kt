package khalid.com.polls.models.network.response.poll


import com.google.gson.annotations.SerializedName

data class CreatedBy(
    val id: Int,
    val name: String,
    val username: String
)