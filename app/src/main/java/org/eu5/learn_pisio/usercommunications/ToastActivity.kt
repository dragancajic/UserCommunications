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
	    val toast = Toast.makeText(this, "This is a toast", toastDuration)
	    //toast.setGravity(Gravity.CENTER, 0, 0) // <-- define position to toast message
	    toast.show()
    }

    private fun showCustomToast() {
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        // TODO: Get the custom layout and inflate it
	    // So to use the custom view, we first have to instantiate the layout from the resource
	    // file and to do that, I'm going to use the layout inflater from this activity:
	    val inflater = LayoutInflater.from(this)
	    val layout = inflater.inflate(
			R.layout.custom_toast_layout,
			findViewById(R.id.customToastLayout)
	    )

        // TODO: Build a toast message that uses the custom layout
	    // So once the custom view object is created, I then need to set the text message
	    // into the text view that's in that layout:
	    val tv = layout.findViewById<View>(R.id.textContent) as TextView
	    //tv.text = "This is custom toast"
	    tv.text = getString(R.string.string_custom_toast)
	    
	    // All right, so now the code needs to create the toast. In this case however, since we're
	    // using a custom layout we're not going to call the makeText() method like we did earlier.
	    // We'll create the new toast by instantiating the class directly:
	    val toast = Toast(applicationContext).run {
	    	duration = toastDuration
		    setGravity(Gravity.BOTTOM or Gravity.START, 50, 50)
		
		    // Now, I need to actually set the custom layout into the toast and to do this,
	        // I simply set the view to the layout that I've inflated!
	        // So, I'm going to set the toast's view to be the layout:
		    view = layout // <-- 'setter for view: View?' is deprecated. Deprecated in Java!
		    
		    // Deprecated | Custom toast views are deprecated.
		    // Apps can create a standard text toast with the makeText(Context, CharSequence, int)
		    // method, or use a Snackbar when in the foreground.
		    // » Starting from Android Build.VERSION_CODES.R, apps targeting API level
		    // Build.VERSION_CODES.R or higher that are in the background will NOT HAVE
		    // custom toast views displayed!
		    
		    show()
	    }
	    // So, that's how you can create a customized toast using a custom layout.
    }
}
