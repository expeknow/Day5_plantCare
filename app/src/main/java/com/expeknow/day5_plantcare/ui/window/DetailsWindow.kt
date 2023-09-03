package com.expeknow.day5_plantcare.ui.window

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.expeknow.day5_plantcare.R
import com.expeknow.day5_plantcare.ui.uitls.PlantData
import com.expeknow.day5_plantcare.ui.uitls.getPlantById

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsWindow(navController: NavController, id: Int) {

    val defaulfModifier = Modifier.padding(horizontal = 20.dp, vertical = 0.dp)
    val plantData = getPlantById(id)

    Scaffold(
        containerColor = colorResource(id = R.color.primary_green),
        modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(it).verticalScroll(rememberScrollState())) {
            Card(colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                PlantProfileCard(plant = plantData, navController)
            }
            Spacer(modifier = Modifier.height(30.dp))
            PlantDescription(plantData, defaulfModifier)

        }
    }
}

@Composable
fun PlantDescription(plantData: PlantData, modifier: Modifier = Modifier) {

        Row(modifier) {
            Text(text = "Plant care", fontWeight = FontWeight.Normal, fontSize = 25.sp, color = Color.White,
                )
        }
        Spacer(modifier = Modifier.height(20.dp))
        PlantStats(plantData)
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier) {
            Text(text = "Information", fontWeight = FontWeight.Normal, fontSize = 25.sp, color = Color.White,)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = plantData.info, fontWeight = FontWeight.Light, color = Color.White, fontSize = 14.sp)

    }
}

@Composable
fun PlantStats(plantData: PlantData) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(start = 20.dp, end = 0.dp)) {
        Column(Modifier.padding(vertical = 20.dp)) {
            StatListCreator("Every ${plantData.waterCycleInWeeks} weeks", R.drawable.water_drop)
            Spacer(modifier = Modifier.height(10.dp))
            StatListCreator(plantData.lightType, R.drawable.sun)
            Spacer(modifier = Modifier.height(10.dp))
            StatListCreator("Minimum of ${plantData.minimumTemp}°C", R.drawable.thermometer)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.green_water_bg)
            ),
            shape = RoundedCornerShape(50.dp, 0.dp, 0.dp, 50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Next watering",
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Box(contentAlignment = Alignment.Center) {

                    CircularProgressIndicator(
                        1f,
                        color = colorResource(id = R.color.progress_bar_bg),
                        strokeWidth = 6.dp,
                        modifier = Modifier.size(80.dp)
                    )
                    CircularProgressIndicator(
                        0.8f,
                        color = Color.White,
                        strokeWidth = 6.dp,
                        modifier = Modifier.size(80.dp)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()) {
                        Text(text = plantData.nextWateringInDays.toString(), fontWeight = FontWeight.Bold,
                        color = Color.White, fontSize = 18.sp)
                        Text(text = "days", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Light)
                    }
                }


            }
        }
    }
}


@Composable
fun StatListCreator(text: String, iconId: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Card(shape = RoundedCornerShape(100.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary_green)
        )) {
            Icon(painter = painterResource(id = iconId), contentDescription = "",
            tint = colorResource(id = R.color.secondary_text_color),
            modifier = Modifier.padding(7.dp))
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = text, color = Color.White, fontWeight = FontWeight.Light, fontSize = 13.sp)
    }
}

@Composable
fun PlantProfileCard(plant: PlantData, navController: NavController) {
    Row(Modifier.height(350.dp)) {
                Column(modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp)) {

                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "",
                            Modifier.size(50.dp),
                            tint = Color.Black)
                    }

                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                        Text(text = plant.name, fontSize = 30.sp, fontWeight = FontWeight.Bold,
                            color = Color.Black)

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = plant.family, fontSize = 16.sp, fontWeight = FontWeight.Normal,
                            color = Color.Black)

                        Spacer(modifier = Modifier.height(20.dp))

                        Card(colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.secondary_text_color),
                            contentColor = colorResource(id = R.color.secondary_green)),
                            shape = RoundedCornerShape(20.dp),
                        ) {
                            Text(text = plant.health, fontSize = 14 .sp, fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 16.dp))
                        }
                    }



                }
        Image(painter = painterResource(id = plant.imageId), contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 10.dp), contentScale = ContentScale.Fit)
    }

            
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    DetailsWindow(rememberNavController(),2)
}