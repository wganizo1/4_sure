package wganz.assessment.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import wganz.assessment.R

class Home : AppCompatActivity() {
    lateinit var houses:Button
    lateinit var spells:Button
    lateinit var students:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        houses = findViewById(R.id.houses)
        spells = findViewById(R.id.spells)
        students = findViewById(R.id.students)
        houses.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext, Houses::class.java)
            startActivity(intent)
        })
        spells.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext, Spells::class.java)
            startActivity(intent)
        })
        students.setOnClickListener(View.OnClickListener {
            intent = Intent(applicationContext, Students::class.java)
            startActivity(intent)
        })
    }


}
