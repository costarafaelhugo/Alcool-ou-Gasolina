package com.hugorafaelcosta.alcoolougasolina

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun btCalcular(view: View) {
        val precoAlcool = findViewById<TextView>(R.id.preco_alcool)
        val precogasolina = findViewById<TextView>(R.id.preco_gasolina)
        val textoRecuperadoAlcool = precoAlcool.text.toString()
        val textoRecuperadoGaoslina = precogasolina.text.toString()
        val mensagemResultado = findViewById<TextView>(R.id.mensagem_resposta)


        val validaCampos = validarCampos(textoRecuperadoAlcool,textoRecuperadoGaoslina)
        if (validaCampos){
            calcularMelhorPreco(textoRecuperadoAlcool, textoRecuperadoGaoslina)
        }else{
          mensagemResultado.text = "Preencha corretamente os preços!"
        }

    }

    fun validarCampos(textoRecuperadoAlcool: String, textoRecuperadoGasolina: String): Boolean {
        var camposvalidados : Boolean= true

        if (textoRecuperadoAlcool.isNullOrEmpty()) {
            camposvalidados = false
        }else if(textoRecuperadoGasolina.isNullOrEmpty()){
                camposvalidados = false
            }
        return camposvalidados
        }


    fun calcularMelhorPreco(textoRecuperadoAlcool: String, textoRecuperadoGaoslina: String) {
        val valorAlcool = textoRecuperadoAlcool.toDouble()
        val valorGasolina = textoRecuperadoGaoslina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        val mensagemResultado = findViewById<TextView>(R.id.mensagem_resposta)

        if (resultadoPreco >= 0.7){
            mensagemResultado.text = "Melhor utilizar gasolina"
        }else mensagemResultado.text = "Melhor utilizar Álcool"
    }

}