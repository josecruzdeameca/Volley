package jose.cruz.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                Log.d("Respuesta", "${response.substring(0, 500)}")
                tv_respuesta.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { error ->
                tv_respuesta.text = "Error: ${error.message}"
            })

        queue.add(stringRequest)

    }
}
