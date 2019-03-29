package com.homeflow.testmiguel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var cantidad = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cantidad_total.text = cantidad.toString()

        operacion.setOnClickListener {
            val deposito = depositar.text.toString()
            val retiro = retirar.text.toString()

            when {
                deposito.isNotEmpty() -> {
                    cantidad += deposito.toInt()
                    cantidad_total.text = cantidad.toString()
                    depositar.setText("")
                }

                retiro.isNotEmpty() -> {
                    cantidad -= retiro.toInt()
                    cantidad_total.text = cantidad.toString()
                    retirar.setText("")
                }

                else -> Toast.makeText(applicationContext, "Debe al menos rellenar un campo para hacer la operacion.", Toast.LENGTH_LONG).show()
            }
        }

    }
}
