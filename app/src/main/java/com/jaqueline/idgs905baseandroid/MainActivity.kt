package com.jaqueline.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jaqueline.idgs905baseandroid.Distancia.distancia
import com.jaqueline.idgs905baseandroid.Ejemplo1.ejemplo1
import com.jaqueline.idgs905baseandroid.Ejemplo2.Ejemplo2Activity
import com.jaqueline.idgs905baseandroid.ExamenResistencia.ExamenResistencia
import com.jaqueline.idgs905baseandroid.Multiplica_AxB.Suma

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        val btnEjemplo2 = findViewById<Button>(R.id.btn2)
        val btnDistancia = findViewById<Button>(R.id.btn3)
        val btnSumaAB = findViewById<Button>(R.id.btn4)
        val btnExamen =findViewById<Button>(R.id.btn5)

        btnEjemplo1.setOnClickListener {
            startActivity(Intent(this, ejemplo1::class.java))
        }

        btnEjemplo2.setOnClickListener {
            startActivity(Intent(this, Ejemplo2Activity::class.java))
        }

        btnDistancia.setOnClickListener {
            startActivity(Intent(this, distancia::class.java))
        }

        btnSumaAB.setOnClickListener {
            startActivity(Intent(this, Suma::class.java))
        }
        btnExamen.setOnClickListener {
            startActivity(Intent(this, ExamenResistencia::class.java))
        }
    }
}