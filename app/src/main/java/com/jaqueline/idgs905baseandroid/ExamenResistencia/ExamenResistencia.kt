package com.jaqueline.idgs905baseandroid.ExamenResistencia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jaqueline.idgs905baseandroid.R
import kotlin.math.pow

class ExamenResistencia : AppCompatActivity() {

    private lateinit var spBanda1: Spinner
    private lateinit var spBanda2: Spinner
    private lateinit var spMultiplicador: Spinner

    private lateinit var lblBanda1: TextView
    private lateinit var lblBanda2: TextView
    private lateinit var lblMultiplicador: TextView

    private lateinit var txtResultado: TextView
    private lateinit var txtSuperior: TextView
    private lateinit var txtInferior: TextView

    private lateinit var radioOro: RadioButton
    private lateinit var radioPlata: RadioButton

    private lateinit var btnResultado: Button

    private val listaColores = listOf(
        "Negro",
        "Café",
        "Rojo",
        "Naranja",
        "Amarillo",
        "Verde",
        "Azul",
        "Violeta",
        "Gris",
        "Blanco"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_examen_resistencia)

        inicializarComponentes()
        configurarSpinners()
        configurarEventos()
    }

    private fun inicializarComponentes() {

        spBanda1 = findViewById(R.id.sp1)
        spBanda2 = findViewById(R.id.sp2)
        spMultiplicador = findViewById(R.id.sp3)

        lblBanda1 = findViewById(R.id.txtValor1)
        lblBanda2 = findViewById(R.id.txtValor2)
        lblMultiplicador = findViewById(R.id.txtValor3)

        txtResultado = findViewById(R.id.txtOhm)
        txtSuperior = findViewById(R.id.txtMaximo)
        txtInferior = findViewById(R.id.txtMinimo)

        radioOro = findViewById(R.id.rbOro)
        radioPlata = findViewById(R.id.rbPlata)

        btnResultado = findViewById(R.id.btnCalcular)
    }

    private fun configurarSpinners() {

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listaColores
        )

        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spBanda1.adapter = adaptador
        spBanda2.adapter = adaptador
        spMultiplicador.adapter = adaptador
    }

    private fun configurarEventos() {

        spBanda1.onItemSelectedListener =
            crearListener(lblBanda1, false)

        spBanda2.onItemSelectedListener =
            crearListener(lblBanda2, false)

        spMultiplicador.onItemSelectedListener =
            crearListener(lblMultiplicador, true)

        btnResultado.setOnClickListener {
            calcularResistencia()
        }
    }

    private fun crearListener(
        textView: TextView,
        esMultiplicador: Boolean
    ): AdapterView.OnItemSelectedListener {

        return object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                if (esMultiplicador) {

                    val valor =
                        10.0.pow(position.toDouble()).toInt()

                    textView.text = valor.toString()

                } else {

                    textView.text = position.toString()
                }

                textView.setBackgroundColor(
                    asignarColor(position)
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun calcularResistencia() {

        val valor1 = spBanda1.selectedItemPosition
        val valor2 = spBanda2.selectedItemPosition

        val multiplicador =
            10.0.pow(
                spMultiplicador.selectedItemPosition.toDouble()
            ).toInt()

        val resistenciaTotal =
            ((valor1 * 10) + valor2) * multiplicador

        val porcentaje =
            if (radioOro.isChecked) {
                0.05
            } else {
                0.10
            }

        val limiteSuperior =
            resistenciaTotal + (resistenciaTotal * porcentaje)

        val limiteInferior =
            resistenciaTotal - (resistenciaTotal * porcentaje)

        txtResultado.text =
            "Valor Ohm: $resistenciaTotal "

        txtSuperior.text =
            "Valor Máximo: ${limiteSuperior.toInt()} "

        txtInferior.text =
            "Valor Mínimo: ${limiteInferior.toInt()} "
    }

    private fun asignarColor(indice: Int): Int {

        return when (indice) {

            0 -> Color.BLACK

            1 -> Color.rgb(120, 72, 48)

            2 -> Color.RED

            3 -> Color.rgb(255, 140, 0)

            4 -> Color.YELLOW

            5 -> Color.GREEN

            6 -> Color.BLUE

            7 -> Color.rgb(148, 0, 211)

            8 -> Color.GRAY

            9 -> Color.WHITE

            else -> Color.LTGRAY
        }
    }
}