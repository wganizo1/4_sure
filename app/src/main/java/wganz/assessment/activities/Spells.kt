package wganz.assessment.activities

import ModelSpells
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import wganz.assessment.R
import wganz.assessment.adapters.AdapterSpells
import java.io.IOException

class Spells : AppCompatActivity() {
    lateinit var progress:ProgressBar
    lateinit var listView_details: ListView
    var arrayList_details:ArrayList<ModelSpells> = ArrayList();


    val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spells)
        progress = findViewById(R.id.progressBar)
        listView_details = findViewById(R.id.listView)
        if(isNetworkAvailable(this)) {
            run("https://www.potterapi.com/v1/spells/?key=$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y")
        }
        else{
            error("They seem to be a network connection error ")
        }
    }

    fun run(url: String) {
        progress.visibility = View.VISIBLE
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                progress.visibility = View.GONE
            }

            override fun onResponse(call: Call, response: Response) {
                var str_response = response.body()!!.string()
                var jsonArray = JSONArray(str_response)
                var size:Int = jsonArray.length()
                arrayList_details= ArrayList();
                for (i in 0.. size-1) {
                    var json_objectdetail:JSONObject=jsonArray.getJSONObject(i)
                    var model:ModelSpells= ModelSpells();
                    model.id=json_objectdetail.getString("_id")
                    model.name=json_objectdetail.getString("spell")
                    model.effect=json_objectdetail.getString("effect")
                    model.typ=json_objectdetail.getString("type")
                     arrayList_details.add(model)
                }

                runOnUiThread {
                    val obj_adapter : AdapterSpells
                    obj_adapter = AdapterSpells(applicationContext,arrayList_details)
                    listView_details.adapter=obj_adapter
                    listView_details.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

                    }
                    progress.visibility = View.GONE
                }
            }
        })
    }
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    fun error(str: String){
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage(str)
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("RETRY", DialogInterface.OnClickListener {
                    dialog, id -> finish()
                run("https://www.potterapi.com/v1/spells/?key=$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y")
            })
            // negative button text and action
            .setNegativeButton("CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Error!!")
        // show alert dialog
        alert.show()
    }
}
