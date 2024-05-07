package com.example.myfarmproducts.models

class Fruits {
    var fruitName: String = ""
    var fruitPrice: String = ""
    var fruitImageUrl: String = ""
    var id: String = ""

    constructor(
        fruitName: String,
        fruitPrice: String,
        fruitImageUrl: String,
        id:String
    ){
        this.fruitName = fruitName
        this.fruitPrice = fruitPrice
        this.fruitImageUrl = fruitImageUrl
        this.id = id
    }

    constructor()
}