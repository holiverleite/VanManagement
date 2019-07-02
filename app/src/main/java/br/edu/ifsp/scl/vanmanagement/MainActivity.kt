package br.edu.ifsp.scl.vanmanagement

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.ifsp.scl.vanmanagement.CreateProfile.UserProfileActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun userProfile(view: View) {
        val userIntent = Intent(this, UserProfileActivity::class.java)
        startActivity(userIntent)
    }
}
