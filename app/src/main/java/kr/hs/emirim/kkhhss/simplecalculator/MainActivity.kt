package kr.hs.emirim.kkhhss.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2: EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var btnNam : Button;
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String
    var result : Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        textResult = findViewById(R.id.text_result)
        btnAdd = findViewById(R.id.btn_plus)
        btnSub = findViewById(R.id.btn_minus)
        btnMul = findViewById(R.id.btn_multiply)
        btnDiv = findViewById(R.id.btn_divide)
        btnNam = findViewById(R.id.btn_namuji)

        btnAdd.setOnClickListener(btnListener)
        btnSub.setOnClickListener(btnListener)
        btnMul.setOnClickListener(btnListener)
        btnDiv.setOnClickListener(btnListener)
        btnNam .setOnClickListener(btnListener)

    }

    var btnListener = OnClickListener{
        num1 = edit1.text.toString()
        num2 = edit2.text.toString()
        if(num1=="" || num2==""){
            Toast.makeText(baseContext, "숫자를 입력하지 않았음!!!!!", Toast.LENGTH_LONG).show()
            return@OnClickListener
        }
        when(it.id){
            R.id.btn_plus -> result = num1.toDouble() + num2.toDouble()
            R.id.btn_minus -> result = num1.toDouble() - num2.toDouble()
            R.id.btn_multiply -> result = num1.toDouble() * num2.toDouble()
            R.id.btn_divide -> {
                if(num2.toDouble() == 0.0){
                    Toast.makeText(baseContext, "나눗셈은 0으로 나눌 수 없음!!!!!", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1.toDouble() / num2.toDouble()
            }
            R.id.btn_namuji -> {
                if(num2.toDouble() == 0.0){
                    Toast.makeText(baseContext, "나눗셈은 0으로 나눌 수 없음!!!!!", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1.toDouble() % num2.toDouble()
            }
        }
        textResult.text = "계산 결과: " + result
    }
}