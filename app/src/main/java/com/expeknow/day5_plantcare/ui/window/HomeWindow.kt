package com.expeknow.day5_plantcare.ui.window

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.expeknow.day5_plantcare.ui.uitls.PlantDataList


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeWindow(navController: NavController) {

    val plantList = PlantDataList

    val defaulfModifier = Modifier.padding(start = 20.dp, top = 0.dp, bottom = 0.dp, end = 0.dp)

    Scaffold {
        Column(modifier = defaulfModifier.verticalScroll(rememberScrollState())) {
            Row(Modifier.fillMaxWidth()) {
                IconButton(onClick = { /*TODO*/ }, Modifier.padding(top = 20.dp)) {
                    Icon(painter = painterResource(id = R.drawable.menu),
                        contentDescription = "", Modifier.size(35.dp))
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(painter = painterResource(id = R.drawable.leaf), contentDescription = "",
                Modifier.size(100.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "My plants", fontSize = 36.sp, fontWeight = FontWeight.Bold)
            }
            
            Spacer(modifier = Modifier.height(30.dp))

            PlantCards(plantList, navController)

        }
    }
}

@Composable
fun PlantCards(dataList: List<PlantData>, navController: NavController) {
    val interactionSource = MutableInteractionSource()
    Column() {
        for(plant in dataList){
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.primary_green)
                ),
                shape = RoundedCornerShape(50.dp, 0.dp, 0.dp, 50.dp),
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clickable(interactionSource = interactionSource, indication = null)
                    { navController.navigate("details/${plant.id}") }
            ) {

                Row(Modifier.fillMaxHeight()) {
                    Image(painter = painterResource(id = plant.imageId), contentDescription = "",
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(100.dp), )

                    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
                        Text(text = plant.name, fontSize = 25.sp, fontWeight = FontWeight.Bold,
                            color = Color.White)

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = plant.family, fontSize = 15.sp, fontWeight = FontWeight.Light,
                            color = Color.White)

                        Spacer(modifier = Modifier.height(15.dp))

                        Card(colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.secondary_green),
                            contentColor = colorResource(id = R.color.secondary_text_color)),
                            shape = RoundedCornerShape(20.dp),
                        ) {
                            Text(text = plant.health, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 16.dp))
                        }

                        Row(
                            Modifier
                                .weight(1f)
                                .fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            IconButton(onClick = { navController.navigate("details/${plant.id}") }) {
                                Icon(painter = painterResource(id = R.drawable.arrow),
                                    contentDescription = "",
                                    Modifier.size(50.dp),
                                    tint = Color.White)
                            }
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }

    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeWindow(rememberNavController())
}