package co.edu.udea.compumovil.gr06_20212.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible


class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        setTitle(R.string.personal_information)

        findViewById<EditText>(R.id.etDate).setOnClickListener(){
            showDatePikerDialog()
        }
        findViewById<RadioButton>(R.id.radioButtonM).setOnClickListener(){
            findViewById<RadioButton>(R.id.radioButtonF).isChecked=false
        }
        findViewById<RadioButton>(R.id.radioButtonF).setOnClickListener(){
            findViewById<RadioButton>(R.id.radioButtonM).isChecked=false
        }
        findViewById<Button>(R.id.ButtonContacNext).setOnClickListener(){
            personValidation()
        }

    }

    private fun showDatePikerDialog() {
        val datePicker=DatePickerFragment({day,month,year-> onDateSelected(year,month, day)})
        datePicker.show(supportFragmentManager,"datePiker")
    }
    private fun onDateSelected(day:Int,month:Int,year: Int){
        findViewById<EditText>(R.id.etDate).setText("$day/$month/$year")
    }

    private fun radioButtonCheckTrue(): String {
        if (findViewById<RadioButton>(R.id.radioButtonM).isChecked){
            return findViewById<RadioButton>(R.id.radioButtonM).text.toString()

        }
        else if (findViewById<RadioButton>(R.id.radioButtonF).isChecked){
            return findViewById<RadioButton>(R.id.radioButtonF).text.toString()
        }
        else{
            return " "
        }
    }
    private fun levelSpinnerOption():String{
        if ((findViewById<Spinner>(R.id.SpinnerLevelEducation) as Spinner).selectedItemPosition==0){
            return " "
        }
        else{
            return (findViewById<Spinner>(R.id.SpinnerLevelEducation) as Spinner).selectedItem.toString()
        }
        return " "
    }
    private fun personValidation(){
        var personname=(findViewById<EditText>(R.id.editTextPersonName) as EditText).text.toString()
        var personlastname=(findViewById<EditText>(R.id.contactEmail) as EditText).text.toString()
        var personsexo=radioButtonCheckTrue()
        var personbirth=(findViewById<EditText>(R.id.etDate) as EditText).text.toString()
        var personeducation=levelSpinnerOption()

        if (personname.isEmpty() || personlastname.isEmpty() || personbirth.isEmpty()){
            (findViewById<EditText>(R.id.textNameError)).isVisible = personname.isEmpty()
            (findViewById<EditText>(R.id.textLastNameError)).isVisible = personlastname.isEmpty()
            (findViewById<EditText>(R.id.textErroretDate)).isVisible = personbirth.isEmpty()
        }

        else{
            (findViewById<EditText>(R.id.textNameError)).isVisible = false
            (findViewById<EditText>(R.id.textLastNameError)).isVisible = false
            (findViewById<EditText>(R.id.textErroretDate)).isVisible = false

            println(personname)
            println(personlastname)
            println(personsexo)
            println(personbirth)
            println(personeducation)

            val intent: Intent = Intent(this,ContactDataActivity::class.java)// preguntar al  profe  modificar para que sea como mostro el profe  en clase
            startActivity(intent)//
        }

    }

}
