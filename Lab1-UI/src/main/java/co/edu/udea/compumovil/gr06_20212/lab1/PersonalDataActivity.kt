package co.edu.udea.compumovil.gr06_20212.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton


class PersonalDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)


        findViewById<EditText>(R.id.etDate).setOnClickListener(){
            showDatePikerDialog()
        }
        findViewById<RadioButton>(R.id.radioButtonM).setOnClickListener(){
            radioButtonCheckM()
        }
        findViewById<RadioButton>(R.id.radioButtonF).setOnClickListener(){
            radioButtonCheckF()
        }

    }

    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month, day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }
    private fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.etDate).setText("$day/$month/$year")
    }

    private fun radioButtonCheckM(){
        findViewById<RadioButton>(R.id.radioButtonF).isChecked=false
    }
    private fun radioButtonCheckF(){
        findViewById<RadioButton>(R.id.radioButtonM).isChecked=false
    }
}
