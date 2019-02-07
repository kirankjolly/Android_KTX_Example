package example.cabot.android_ktx_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.core.text.isDigitsOnly
import androidx.core.content.edit
import androidx.core.text.bold
import androidx.core.text.italic
import androidx.core.text.underline
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TextUtil KTX alternative
        println("1".isDigitsOnly())

        //Operator overloading
        var names = arrayOf("name 1", "name 2", "name 3")
        names.forEach { println(it) }
        val selectedName = names[1]
        names += selectedName
        names.forEach { println(it) }

        //Shared preference
        val preferences = this.getSharedPreferences("prefs", 0)
        preferences.edit {
            putInt("key1", 1000)
        }
        println(preferences!!.getInt("key1",10))

        //Text
        val builder = SpannableStringBuilder("Hello ")
            .bold { italic { underline { append("Good Morning") } } }
        txt1.text = builder
    }
}

//reference
//https://medium.com/exploring-android/exploring-ktx-for-android-13a369795b51
//https://www.raywenderlich.com/5576-android-ktx-tutorial-getting-started
