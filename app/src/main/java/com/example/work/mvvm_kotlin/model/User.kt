package com.example.work.mvvm_kotlin.model

class User {
    var id: Int = 0
    var name: String = ""

    constructor()

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }
}