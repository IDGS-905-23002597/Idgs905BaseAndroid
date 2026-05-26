package com.jaqueline.idgs905baseandroid.Ejemplo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jaqueline.idgs905baseandroid.R

class Ejemplo2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_ejemplo2)

        val btnStart = findViewById<Button>(R.id.btnStart)

        val edtName = findViewById<EditText>(R.id.editName)

        btnStart.setOnClickListener {

            val name = edtName.text.toString()

            if (name.isNotEmpty()) {

                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("EXTRA_NAME", name)

                startActivity(intent)
            }
        }
    }
}