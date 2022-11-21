package com.mertciril.kotlin2superkahraman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //callClassExample()
        //nullSafety()
    }

    fun createSuperhero(view: View) {
        val name = nameText.text.toString()
        val age = ageText.text.toString().toIntOrNull() //int'e çeviremezse null yapar
        val power = powerText.text.toString().toIntOrNull()


        if (age == null || power == null) {
            textView.text = "Lütfen doğru değeri girdiğinizden emin olun"
        } else {
            val superhero = Superhero(name, age, power)
            textView.text =
                "İsim: ${superhero.name}\nYaş: ${superhero.age}\nGüç: ${superhero.power}"
        }
    }


    fun nullSafety() {
        var myAge: Int? = null //  ? olduğu için null değer alabilir
        //!! null gelmeyecek, ? null gelebilir
        //null kontrolü yapılırken

        //1) if kullanılabilir,

        //2) elvis operatoru kullanılabilir
        val result = myAge?.minus(2) ?: 10 //eğer null gelirse 10 değerini al
        println(result)

        //3) let eğer null değilse çalışır null ise çalışmaz
        myAge?.let {
            println(it * 5)
        }
    }
}