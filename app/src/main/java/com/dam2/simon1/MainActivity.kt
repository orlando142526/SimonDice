package com.dam2.simon1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt_verde : Button = findViewById(R.id.btVerde)
        val bt_rojo : Button = findViewById(R.id.btRojo)
        val bt_amarillo : Button = findViewById(R.id.btAmarillo)
        val bt_azul : Button = findViewById(R.id.btAzul)
        val bt_start : Button = findViewById(R.id.btIniciar)
        val bt_check : Button = findViewById(R.id.btCheck)
        val Btnscolor = listOf(bt_rojo,bt_verde,bt_amarillo,bt_azul)
        val toast = Toast.makeText(applicationContext,"GAME OVER", Toast.LENGTH_SHORT)
        val toast1 = Toast.makeText(applicationContext,"START", Toast.LENGTH_SHORT)

        val ModeloJuego by viewModels<MyViewModel>()

        ModeloJuego.estadoJuego.observe(this, Observer {

            if () {
                bt_verde.isEnabled = false
                bt_rojo.isEnabled = false
                bt_amarillo.isEnabled = false
                bt_azul.isEnabled = false
                bt_check.isEnabled = false
                bt_start.isEnabled= false
            } else {
                bt_verde.isEnabled = true
                bt_rojo.isEnabled = true
                bt_amarillo.isEnabled = true
                bt_azul.isEnabled = true
                bt_check.isEnabled = true
                bt_start.isEnabled= true
            }
        })

        ModeloJuego.secuenciaJuego.observe(this, Observer {
            ModeloJuego.mostrarSec(Btnscolor)
        })

        bt_start.setOnClickListener {
            toast.show()
            ModeloJuego.iniciarJuego()
        }

        bt_check.setOnClickListener {
            if (!ModeloJuego.comprobarSec()) {
                toast1.show()
            }
        }
        bt_verde.setOnClickListener {
            ModeloJuego.añadirSecuencia(1)
        }
        bt_rojo.setOnClickListener {
            ModeloJuego.añadirSecuencia(2)
        }
        bt_amarillo.setOnClickListener {
            ModeloJuego.añadirSecuencia(3)
        }
        bt_azul.setOnClickListener {
            ModeloJuego.añadirSecuencia(4)
        }
    }
}
