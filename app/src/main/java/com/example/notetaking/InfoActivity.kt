package com.example.notetaking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.content_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        setSupportActionBar(toolbar)

        val person = intent.getParcelableExtra<Person>("person")

        button2.setOnClickListener{ view ->
            var iError = ""

            if(!addressTxt.text.toString().isEmpty()) {
                person.address = addressTxt.text.toString()
            } else {
                iError = "Address is required!"
                addressTxt.setError(iError)
            }

            if(!ageText.text.toString().isEmpty()) {
                person.age = ageText.text.toString().toInt()
            } else {
                iError = "Age is required!"
                ageText.setError(iError)
            }

            if(!cityText.text.toString().isEmpty()) {
                person.city = cityText.text.toString()
            } else {
                iError = "City is required!"
                cityText.setError(iError)
            }

            if(iError.isEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("person", person)

                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }
    }

}
