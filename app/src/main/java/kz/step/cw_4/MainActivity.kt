package kz.step.cw_4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var buttonCamera: Button? = null
    var buttonCall: Button? = null

    private val IMAGE_CAPTURE_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        buttonCamera = findViewById(R.id.button_camera)
        buttonCall = findViewById(R.id.button_call)
    }

    private fun initializeLiseners() {

        buttonCamera?.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
        }


        buttonCall?.setOnClickListener {
            makePhoneCall("87050000000")
        }
    }

    fun makePhoneCall(number: String) : Boolean {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel:$number"))
            startActivity(intent)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }
}