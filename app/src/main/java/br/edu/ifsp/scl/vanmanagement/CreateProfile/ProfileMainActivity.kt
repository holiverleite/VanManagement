package br.edu.ifsp.scl.vanmanagement.CreateProfile

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import br.edu.ifsp.scl.vanmanagement.CreateProfile.Fragments.DeparturePointFragment
import br.edu.ifsp.scl.vanmanagement.CreateProfile.Fragments.UserProfileFragment
import br.edu.ifsp.scl.vanmanagement.Home.ProfileChooserFragment
import br.edu.ifsp.scl.vanmanagement.Home.SecondFragment
import br.edu.ifsp.scl.vanmanagement.R
import kotlinx.android.synthetic.main.fragment_user_profile.*

class ProfileMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_view,ProfileChooserFragment())
        transaction.commit()
    }

    // Profile Chooser - inicio
    // Profile Chooser - inicio
    // Profile Chooser - inicio
    fun userProfile(view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_view, UserProfileFragment())
        transaction.commit()
    }

    fun driverProfile(view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_view,SecondFragment())
        transaction.commit()
    }
    // Profile Chooser - fim
    // Profile Chooser - fim
    // Profile Chooser - fim






    // UserProfile - inicio
    // UserProfile - inicio
    // UserProfile - inicio
    fun didTapNextButton(view: View) {
        val departureLocationIntent = Intent(this, DeparturePointFragment::class.java)
        finish()
        startActivity(departureLocationIntent)
    }

    fun changePicture(view: View) {
        //check runtime permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_DENIED){
                //permission denied
                val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE);
                //show popup to request runtime permission
                requestPermissions(permissions, PERMISSION_CODE);
            }
            else{
                //permission already granted
                pickImageFromGallery();
            }
        }
        else{
            //system OS is < Marshmallow
            pickImageFromGallery();
        }
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,
            IMAGE_PICK_CODE
        )
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            profile.setImageURI(data?.data)
        }
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    // UserProfile - fim
    // UserProfile - fim
    // UserProfile - fim
}