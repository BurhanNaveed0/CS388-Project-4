import com.google.gson.annotations.SerializedName

class NationalPark {
    @JvmField
    @SerializedName("original_title")
    var name: String? = null

    @JvmField
    @SerializedName("overview")
    var description: String? = null


    @SerializedName("poster_path")
    var image_path: String? = null

    class Image {
        @SerializedName("url")
        var url: String? = null
    }
}