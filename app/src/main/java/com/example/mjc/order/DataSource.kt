package com.example.mjc.order

import com.example.mjc.R

class DataSource {

    val list = listOf<FoodList>(
            FoodList(
                    1000,
                    "Nasi Lemak",
                    8.00,
                    R.drawable.nasilemak
            ),
            FoodList(
                    1000,
                    "Mee Goreng",
                    9.50,
                    R.drawable.meegoreng
            ),
            FoodList(
                    1000,
                    "Nasi Goreng",
                    9.50,
                    R.drawable.nasigoreng
            ),

            //1001
            FoodList(
                    1001,
                    "Chicken Chop",
                    17.00,
                    R.drawable.chickenchop
            ),
            FoodList(
                    1001,
                    "Spaghetti Bolognese ",
                    15.00,
                    R.drawable.bolognese
            ),

            FoodList(
                    1001,
                    "Spaghetti Carbonara",
                    15.00,
                    R.drawable.carbonara
            ),

            //1002
            FoodList(
                    1002,
                    "Jajangmyeon",
                    15.00,
                    R.drawable.jajangmyeon
            ),

            FoodList(
                    1002,
                    "Rabokki",
                    15.50,
                    R.drawable.rabokki
            ),
            FoodList(
                    1002,
                    "Fried Chicken",
                    20.00,
                    R.drawable.friedchicken
            )

    )


}
