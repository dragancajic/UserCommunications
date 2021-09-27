package org.eu5.learn_pisio.usercommunications

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class ToastActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        findViewById<View>(R.id.btnShowToast).setOnClickListener(this)
        findViewById<View>(R.id.btnShowCustomToast).setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnShowToast -> showToast()
            R.id.btnShowCustomToast -> showCustomToast()
        }
    }

    private fun showToast() {
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        // TODO: Create and show the toast message

    }

    private fun showCustomToast() {
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        // TODO: Get the custom layout and inflate it


        // TODO: Build a toast message that uses the custom layout

    }
}
