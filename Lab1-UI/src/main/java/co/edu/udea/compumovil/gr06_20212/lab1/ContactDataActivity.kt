package co.edu.udea.compumovil.gr06_20212.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.view.isVisible

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
    }

    private fun personValidation(){
        var contactPhone=(findViewById<EditText>(R.id.contactPhone) as EditText).text.toString()
        var contactMail=(findViewById<EditText>(R.id.contactEmail) as EditText).text.toString()
        var contactCountry=(findViewById<EditText>(R.id.contactCountry) as EditText).text.toString()

        if (contactPhone.isEmpty() || contactMail.isEmpty() || contactCountry.isEmpty()){
            println("error no lleno los  campos")

            (findViewById<EditText>(R.id.textPhoneError)).isVisible = contactPhone.isEmpty()

            (findViewById<EditText>(R.id.textmailError)).isVisible = contactMail.isEmpty()

            (findViewById<EditText>(R.id.textCountryError)).isVisible = contactCountry.isEmpty()

        }
        else{
            (findViewById<EditText>(R.id.textPhoneError)).isVisible = false

            (findViewById<EditText>(R.id.textmailError)).isVisible = false

            (findViewById<EditText>(R.id.textCountryError)).isVisible = false

            println(contactPhone)
            println(contactMail)
            println(contactCountry)
        }

    }
}