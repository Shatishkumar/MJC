package com.example.mjc.housekeeping

class HousekeepingItem {
    var id: Int? =0
    var qty: Int? =0
    var name =""

    constructor(
        id:Int,
        qty:Int,
        name:String
    ){
        this.id=id
        this.qty=qty
        this.name=name
    }
}