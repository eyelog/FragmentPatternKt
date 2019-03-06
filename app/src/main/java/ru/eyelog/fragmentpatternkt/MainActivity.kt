package ru.eyelog.fragmentpatternkt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isOneFragment = true;
    val manager = supportFragmentManager

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragmentOne()

        button.setOnClickListener {
            if (isOneFragment){
                changeFragmentTwo()
            }else{
                changeFragmentOne()
            }
        }
    }

    fun changeFragmentOne(){
        val transaction = manager.beginTransaction()
        val  fragment = FragmentOne()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isOneFragment = true
    }

    fun changeFragmentTwo(){
        val transaction = manager.beginTransaction()
        val  fragment = FragmentTwo()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isOneFragment = false
    }
}
