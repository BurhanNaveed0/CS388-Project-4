package com.codepath.nationalparks

import NationalPark
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.nationalparks.R.id

/**
 * [RecyclerView.Adapter] that can display a [NationalPark] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class NationalParksRecyclerViewAdapter(
    private val parks: List<NationalPark>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<NationalParksRecyclerViewAdapter.ParkViewHolder>() {


    // Inflate the item layout from XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_national_park, parent, false)
        return ParkViewHolder(view)
    }

    // ViewHolder class holds references to all UI elements inside the list item layout
    inner class ParkViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: NationalPark? = null

        // TODO: Step 4a - Add references for remaining views from XML
        val mParkName: TextView = mView.findViewById(id.park_name) as TextView

        val mParkDescription: TextView = mView.findViewById(id.park_description) as TextView
        val mParkImage: ImageView = mView.findViewById(R.id.park_image)

        override fun toString(): String {
            return mParkName.toString() + " '" + mParkDescription.text + "'"
        }
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        val park = parks[position]

        // TODO: Step 4b - Bind the park data to the views
        holder.mParkName.text = park.name
        holder.mParkDescription.text = park.description

        // TODO: Step 4c - Use Glide to load the first image
        val imageUrl = "https://image.tmdb.org/t/p/w500/" + park.image_path

        Glide.with(holder.mView)
            .load(imageUrl)
            .centerInside()
            .into(holder.mParkImage)


        // Sets up click listener for this park item
        holder.mView.setOnClickListener {
            val context = holder.mView.context

            // If your park model includes known_for info, grab the first one:
            val topKnownFor = park.known_for?.firstOrNull()
            val movieTitle = topKnownFor?.title ?: "No title available"
            val movieOverview = topKnownFor?.overview ?: "No overview available"
            val moviePosterUrl = "https://image.tmdb.org/t/p/w500/" + (topKnownFor?.posterPath ?: "")

            val intent = Intent(context, ActorDetailActivity::class.java).apply {
                putExtra("name", park.name)
                putExtra("actorImageUrl", imageUrl)
                putExtra("movieTitle", movieTitle)
                putExtra("movieImageUrl", moviePosterUrl)
                putExtra("movieOverview", movieOverview)
            }

            context.startActivity(intent)

            // still notify listener if needed (for other logic)
            mListener?.onItemClick(park)
        }
    }

    // Tells the RecyclerView how many items to display
    override fun getItemCount(): Int {
        return parks.size
    }
}
