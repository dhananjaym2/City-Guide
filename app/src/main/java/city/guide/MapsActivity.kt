package city.guide

import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import city.guide.utils.v
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var playAndStop_FloatingActionButton: FloatingActionButton
    private var LOG_TAG: String = this.javaClass.simpleName
    private var isPlaying: Boolean = false
    private val jodhpurLatLng = LatLng(26.2703357, 72.9603309)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        playAndStop_FloatingActionButton = findViewById(R.id.playAndStop_FloatingActionButton)
        playAndStop_FloatingActionButton.setOnClickListener({

            v(LOG_TAG, "playAndStop_FloatingActionButton clicked isPlaying:" + isPlaying)

            //if not started call API to fetch next lat long else stop the API calls.

            val imageDrawableToShow: Int
            if (isPlaying) {
                imageDrawableToShow = R.drawable.ic_play_arrow_white_24dp
            } else {
                imageDrawableToShow = R.drawable.ic_crop_square_white_24dp
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                playAndStop_FloatingActionButton.setImageDrawable(resources.getDrawable(imageDrawableToShow, theme))
            } else {
                playAndStop_FloatingActionButton.setImageDrawable(resources.getDrawable(imageDrawableToShow))
            }
            
            isPlaying = !isPlaying
        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        mMap.addMarker(MarkerOptions().position(jodhpurLatLng).title(getString(R.string.MarkerInJodhpur)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jodhpurLatLng))
    }
}
