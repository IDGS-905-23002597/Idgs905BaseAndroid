package com.jaqueline.idgs905baseandroid.Multiplica_AxB


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jaqueline.idgs905baseandroid.R

class Suma : AppCompatActivity() {

    private lateinit var edtA: EditText
    private lateinit var edtB: EditText
    private lateinit var btnSumar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        edtA = findViewById(R.id.edtA)
        edtB = findViewById(R.id.edtB)
        btnSumar = findViewById(R.id.button)

        btnSumar.setOnClickListener {

            if (edtA.text.toString().isEmpty() || edtB.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese ambos valores", Toast.LENGTH_SHORT).show()
            } else {

                val a = edtA.text.toString().toInt()
                val b = edtB.text.toString().toInt()

                var resultado = 0
                var cadena = ""

                for (i in 1..b) {
                    resultado += a

                    cadena += if (i == b) {
                        "$a"
                    } else {
                        "$a + "
                    }
                }

                cadena += " = $resultado"

                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("cadena", cadena)
                intent.putExtra("resultado", resultado)

                startActivity(intent)
            }
        }
    }
}