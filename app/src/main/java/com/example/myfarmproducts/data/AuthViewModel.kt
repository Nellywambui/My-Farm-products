package com.example.myfarmproducts.data

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.example.myfarmproducts.models.Users
import com.example.myfarmproducts.navigation.ROUTE_ABOUT
import com.example.myfarmproducts.navigation.ROUTE_HOME
import com.example.myfarmproducts.navigation.ROUTE_LOGIN
import com.example.myfarmproducts.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(
    var navController: NavController,
    var context: Context){

    var mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth= FirebaseAuth.getInstance()
        progress= ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait.....")
    }

    fun signup(
//        name: String,
        email:String,
        password:String,
        confirmpass:String
    ) {
        progress.show()
        if (email.isBlank() || password.isBlank() || confirmpass.isBlank()) {
            progress.dismiss()
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG).show()
            return
        }else if (password != confirmpass) {
            progress.dismiss()
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
//            navController.navigate(ROUTE_REGISTER)
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val userdata = Users(email, password, mAuth.currentUser!!.uid)
                    val regRef = FirebaseDatabase.getInstance().getReference().child("Users/" + mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {
                        if (it.isSuccessful) {
                            progress.dismiss()
                            Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_HOME)
                        } else {
                            progress.dismiss()
                            Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                                .show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                } else {
                    progress.dismiss()
                    navController.navigate(ROUTE_ABOUT)
                }

            }
        }
    }


    fun login(email: String,
              pass: String,
    ){
        progress.show()
        var userid = System.currentTimeMillis().toString()

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in", Toast.LENGTH_LONG).show()
                Log.e("User Id", "Here is user id: $userid")
                navController.navigate("$ROUTE_ABOUT/$userid")
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE\
            }else{
                Toast.makeText(context,"${it.exception!!.message}", Toast.LENGTH_LONG).show()
//                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
//        navController.navigate(ROUTE_LOGIN)
    }

    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }
}