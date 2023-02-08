package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       val tvResult = findViewById<TextView>(R.id.textview_result)
       val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
       val tvClassificacao =findViewById<TextView>(R.id.textview_classificacao)
            tvResult.text = result.toString()


        /*TABELA IMC
        MENOR QUE 18.5 ABAIXO DO PESO
        ENTRE 18.5 E 24,9 NORMAL
        ENTRE 25 E 29.9 SOBREPESO
        ENTRE 30 E 39.9 OBESIDADE
        MAIOR QUE QUE 40 OBESIDADE GRAVE
         */

        val classificacao = if (result < 18.5f){ //nesse caso mudei a ordem da classificacao e não preciso repetir todo else if
             "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f){ //aqui eu fiz um RANGE do kotlin que substitiu por in
          "PESO NORMAL"
        } else if (result in 25f..29.9f){
          "SOBREPESO"
        } else if (result in 30f..39.9f){
         "OBESIDADE"
        } else {
        "OBESIDADE GRAVE"
        }

            tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}