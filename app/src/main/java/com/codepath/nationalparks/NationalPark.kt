import com.google.gson.annotations.SerializedName

class NationalPark {
    @JvmField
    @SerializedName("name")
    var name: String? = null

    @JvmField
    @SerializedName("known_for_department")
    var description: String? = null


    @SerializedName("profile_path")
    var image_path: String? = null

    class Image {
        @SerializedName("url")
        var url: String? = null
    }

    @SerializedName("known_for")
    var known_for: List<KnownFor>? = null
}

data class KnownFor(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("media_type")
    val mediaType: String? = null
)