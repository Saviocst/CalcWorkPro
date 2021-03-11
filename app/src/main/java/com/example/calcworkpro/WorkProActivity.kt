package com.example.calcworkpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog

class WorkProActivity : AppCompatActivity() {

    lateinit var skbSunday: SeekBar
    lateinit var skbMonday: SeekBar
    lateinit var skbTuesday: SeekBar
    lateinit var skbWednesday: SeekBar
    lateinit var skbThursday: SeekBar
    lateinit var skbFriday: SeekBar
    lateinit var skbSaturday: SeekBar
    lateinit var skbOthers: SeekBar

    lateinit var txtOne: TextView
    lateinit var txtTwo: TextView
    lateinit var txtThree: TextView
    lateinit var txtFour: TextView
    lateinit var txtFive: TextView
    lateinit var txtSix: TextView
    lateinit var txtSeven: TextView
    lateinit var txtEight: TextView

    lateinit var editSalary: EditText

    lateinit var btnCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        skbSunday = findViewById(R.id.day_sunday)
        skbMonday = findViewById(R.id.day_monday)
        skbTuesday = findViewById(R.id.day_tuesday)
        skbWednesday = findViewById(R.id.day_wednesday)
        skbThursday = findViewById(R.id.day_thursday)
        skbFriday = findViewById(R.id.day_friday)
        skbSaturday = findViewById(R.id.day_saturday)
        skbOthers = findViewById(R.id.day_others)

        txtOne = findViewById(R.id.txt_one)
        txtTwo = findViewById(R.id.txt_two)
        txtThree = findViewById(R.id.txt_three)
        txtFour = findViewById(R.id.txt_four)
        txtFive = findViewById(R.id.txt_five)
        txtSix = findViewById(R.id.txt_six)
        txtSeven = findViewById(R.id.txt_seven)
        txtEight = findViewById(R.id.txt_eight)

        editSalary = findViewById(R.id.edit_salary)
        btnCalc = findViewById(R.id.btn_calc_worker)

        seekbarWork()

        btnCalc.setOnClickListener {

            if (!valid()){
                Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val salary = editSalary.text.toString().toDouble()
            val sunday = txtOne.text.toString().toInt()
            val monday = txtTwo.text.toString().toInt()
            val tuesday = txtThree.text.toString().toInt()
            val wednesday = txtFour.text.toString().toInt()
            val thursday = txtFive.text.toString().toInt()
            val friday = txtSix.text.toString().toInt()
            val saturday = txtSeven.text.toString().toInt()
            val others = txtEight.text.toString().toInt()


            val resposta = calcHours(salary, sunday, monday, tuesday, wednesday, thursday, friday, saturday, others)
            //val convert = String().format("%.2f", resposta).toDouble().toString()

            val builder = AlertDialog.Builder(this, R.style.AlertDialogSv)
            val view = LayoutInflater.from(this).inflate(R.layout.dialog_custom_sv, null)

            builder.setView(view)

            view.findViewById<TextView>(R.id.dialog_title_sv).text = resources.getString(R.string.info_confirm)

            view.findViewById<TextView>(R.id.result_agenda).text = String.format("Valor = %.2f R$", resposta) // Deu Certo OK

            view.findViewById<Button>(R.id.button_ok).text = resources.getString(R.string.btn_ok)

            view.findViewById<ImageView>(R.id.dialog_image_sv).setImageResource(R.drawable.ic_money_sv)

            val alertDialog: AlertDialog = builder.create()

            view.findViewById<Button>(R.id.button_ok).setOnClickListener { alertDialog.dismiss() }

            if(alertDialog.window != null){
                alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            }

            alertDialog.show()

        }

    }

    /*private fun dialogAlert(){
        val builder = AlertDialog.Builder(this, R.style.AlertDialogSv)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_custom_sv, null)

        builder.setView(view)

        view.findViewById<TextView>(R.id.dialog_title_sv).text = resources.getString(R.string.info_confirm)

        view.findViewById<TextView>(R.id.result_agenda).text = resources.getString(R.string.succesful)
        //view.findViewById<TextView>(R.id.result_agenda).text = resources.getString(R.string.resultado)

        view.findViewById<Button>(R.id.button_ok).text = resources.getString(R.string.btn_ok)

        view.findViewById<ImageView>(R.id.dialog_image_sv).setImageResource(R.drawable.ic_money_sv)

        val alertDialog: AlertDialog = builder.create()

        view.findViewById<Button>(R.id.button_ok).setOnClickListener { alertDialog.dismiss() }

        if(alertDialog.window != null){
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

        alertDialog.show()
    }*/

    private fun seekbarWork() {
        skbSunday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtOne.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbMonday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtTwo.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbTuesday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtThree.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbWednesday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtFour.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbThursday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtFive.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbFriday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtSix.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbSaturday.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtSeven.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        skbOthers.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtEight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
    }

    private fun valid():Boolean{
        if (editSalary.text.isNotEmpty()){
            return true
        }
        return false
    }

    private fun calcHours(salary: Double, sun: Int, mon: Int, tue: Int, wed: Int, thu: Int, fri: Int, sat: Int, oth: Int ): Double{
        return (salary/4) / (sun + mon + tue + wed + thu + fri + sat + oth)
    }
}