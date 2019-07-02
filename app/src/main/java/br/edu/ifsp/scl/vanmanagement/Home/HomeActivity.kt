package br.edu.ifsp.scl.vanmanagement.Home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.edu.ifsp.scl.vanmanagement.MainActivity
import br.edu.ifsp.scl.vanmanagement.R
import kotlinx.android.synthetic.main.home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val fragmentAdapter = HomeAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}