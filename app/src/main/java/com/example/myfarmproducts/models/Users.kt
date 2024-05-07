package com.example.myfarmproducts.models

import android.provider.ContactsContract.CommonDataKinds.Email

class Users {
//    var name: String = ""
    var email: String = ""
    var password: String = ""
    var userid: String = ""

    constructor(
//        name: String,
        email: String,
        password: String,
        userid: String,
    ){
//        this.name = name
        this.email = email
        this.password = password
        this.userid = userid
    }

    constructor()
}