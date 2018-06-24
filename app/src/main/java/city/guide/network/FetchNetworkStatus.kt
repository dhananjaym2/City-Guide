package city.guide.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun isConnectedToNetwork(context: Context): Boolean {
    val activeNetworkInfo: NetworkInfo? = getActiveNetworkInfoFromConnectivityManager(context)
    if (activeNetworkInfo != null && activeNetworkInfo.isConnected)
        return true
    return false
}

private fun getActiveNetworkInfoFromConnectivityManager(context: Context): NetworkInfo? {
    val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (connectivityManager.activeNetworkInfo != null)
        return connectivityManager.activeNetworkInfo
    return null
}

fun isConnectedToWiFi(context: Context): Boolean {
    val activeNetworkInfo: NetworkInfo? = getActiveNetworkInfoFromConnectivityManager(context)
    if (activeNetworkInfo != null && activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI)
        return true
    return false
}