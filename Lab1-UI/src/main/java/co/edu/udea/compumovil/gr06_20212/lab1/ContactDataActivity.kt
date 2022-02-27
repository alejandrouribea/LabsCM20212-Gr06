package co.edu.udea.compumovil.gr06_20212.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible

class ContactDataActivity : AppCompatActivity() {
    val country = arrayOf("Argentina","Bolivia" , "Brasil" ,"Chile" , "Colombia" ,"Costa Rica" , "Cuba" , "Ecuador" , "El Salvador" , "Guatemala" , "Haití" , "Honduras" , "México" , "Nicaragua" , "Panamá" , "Paraguay" , "Perú" , "República Dominicana" , "Uruguay" , "Venezuela")
    val city = arrayOf("Bogotá","Medellín","Cali","Bucaramanga","Cartagena","Soacha","Cúcuta","Soledad","Bucaramanga","Pereira","Montería", "Pasto", "Bello", "Armenia", "Villavicencio")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        setTitle(R.string.Contact_information)
        autoCompleteCountry()
        autoCompleteCity()
        findViewById<Button>(R.id.ButtonContacNext).setOnClickListener(){
            contactValidation()
        }
    }
    private fun autoCompleteCountry(){
        val campoSugerencias = findViewById<View>(R.id.contactCity) as AutoCompleteTextView

        val adaptador: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, city)

        campoSugerencias.setAdapter(adaptador)
    }
    private fun autoCompleteCity(){
        val campoSugerencias = findViewById<View>(R.id.contactCountry) as AutoCompleteTextView

        val adaptador: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,country )

        campoSugerencias.setAdapter(adaptador)
    }

    private fun contactValidation(){
        var contactPhone=(findViewById<EditText>(R.id.contactPhone) as EditText).text.toString()
        var contactMail=(findViewById<EditText>(R.id.contactMail) as EditText).text.toString()
        var contactCountry=(findViewById<EditText>(R.id.contactCountry) as EditText).text.toString()
        var contactCity=(findViewById<EditText>(R.id.contactCity) as EditText).text.toString()
        var contactDirection=(findViewById<EditText>(R.id.contactDirection) as EditText).text.toString()


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

            Log.i("contactData", "Contact information"+"\n"+"Phone: "+contactPhone+"\n"+"Mail: "+contactMail+"\n"+"Country: "+contactCountry+"\n"+"City: "+contactCity+"\n"+"Direction: "+contactDirection)

        }

    }
}