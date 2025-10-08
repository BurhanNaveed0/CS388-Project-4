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
}