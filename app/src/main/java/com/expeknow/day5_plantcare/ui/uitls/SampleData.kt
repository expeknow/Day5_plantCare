package com.expeknow.day5_plantcare.ui.uitls

import com.expeknow.day5_plantcare.R

class PlantData (
    val name: String,
    val family: String,
    val health: String,
    val imageId: Int,
    val id: Int,
    val waterCycleInWeeks: Int,
    val lightType: String,
    val minimumTemp: Int,
    val info: String,
    val nextWateringInDays: Int,
)

val PlantDataList = listOf(
    PlantData("Diego", "Euphorbia Eritrea", "Healthy",
        R.drawable.plant1, 0, 3, "Natural light", 7,
        "Euphorbia Eritrea is a cactus-like plant that grows slowly and requires little maintenance.",
        8),
    PlantData("Sophia", "Monstera Deliciosa", "Thriving",
        R.drawable.plant2, 1, 4, "Indirect sunlight", 12,
        "Monstera Deliciosa, also known as the Swiss Cheese Plant, is a popular indoor plant with large, glossy leaves.",
        9),
    PlantData("Olivia", "Ficus elastica", "Stable",
        R.drawable.plant3, 2, 2, "Bright indirect light", 14,
        "Ficus elastica, commonly known as the Rubber Plant, is a resilient plant with thick, shiny leaves.",
        7),
    PlantData("Emma", "Dracaena Marginata", "Growing",
        R.drawable.plant4, 3, 1, "Moderate light", 10,
        "Dracaena Marginata, also known as the Dragon Tree, is a tall, slender plant with distinctive red-edged leaves.",
        6)
)

fun getPlantById(id: Int) : PlantData{
    for(plant in PlantDataList){
        if(plant.id == id){
            return plant
        }
    }
    return PlantDataList[0]
}