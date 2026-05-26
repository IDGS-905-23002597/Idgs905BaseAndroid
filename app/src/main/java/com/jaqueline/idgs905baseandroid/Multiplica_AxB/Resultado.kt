package com.jaqueline.idgs905baseandroid.Multiplica_AxB

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jaqueline.idgs905baseandroid.R
import android.content.Intent
import android.widget.Button

class Resultado : AppCompatActivity() {

    private lateinit var txtResult: TextView
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        txtResult = findViewById(R.id.txtResult)
        btnRegresar = findViewById(R.id.btnRegresar)

        // Recibir resultado
        val resultado = intent.getIntExtra("resultado", 0)

        // Mostrar resultado
        txtResult.text = resultado.toString()

        // Botón regresar
        btnRegresar.setOnClickListener {
            val intent = Intent(this, Suma::class.java)
            startActivity(intent)
            finish()
        }
    }
}