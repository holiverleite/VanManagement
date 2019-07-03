package br.edu.ifsp.scl.vanmanagement.CreateProfile.Fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.edu.ifsp.scl.vanmanagement.R
import kotlinx.android.synthetic.main.fragment_user_profile.*

class UserProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                          savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_user_profile, container, false)
    }
}
