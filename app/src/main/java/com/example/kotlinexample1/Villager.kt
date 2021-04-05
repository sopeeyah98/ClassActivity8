package com.example.kotlinexample1

// data class CLASSNAME (instance variable)
data class Villager (val name: String, val birthday: String, val phrase: String,
                     val houseURL: String, val villagerURL: String, var clicked: Boolean){
    // toString
        // Villager(name="Henry", birthday=...)
    // getters
    // setters
    // equals
}

// val -> do not come with setters
// var -> comes with both setters and getters