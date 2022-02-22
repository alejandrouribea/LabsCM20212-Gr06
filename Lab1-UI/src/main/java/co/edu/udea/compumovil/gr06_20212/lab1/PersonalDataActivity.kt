package co.edu.udea.compumovil.gr06_20212.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.util.*


class PersonalDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        findViewById<EditText>(R.id.etDate).setOnClickListener(){
            showDatePikerDialog()
        }

    }

    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month, day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }
    fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.etDate).setText("$day/$month/$year")
    }

}
