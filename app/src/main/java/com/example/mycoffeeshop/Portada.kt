package com.example.mycoffeeshop

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycoffeeshop.ui.theme.FontTittle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(navController: NavHostController) {
    Scaffold (topBar = { MyTopAppBar("Portada", onClidkDrawer = {}) } ){
        Row {

        }
    }
    Box {
    LazyColumn{
        items(getAboutData()) { card ->
            ItemCard(cardData = card)

        }
    }
    }
}

fun MyTopAppBar(layout: String, onClidkDrawer: () -> Unit){}

data class CardData(
    var name:String,
    var adress: String,
    @DrawableRes var photo: Int
)

fun getAboutData(): List<CardData> {
    return listOf(
        CardData(
            "Antico Caffè Greco",
            "St. Italy, Rome",
            R.drawable.images,
        ),
        CardData(
            "Coffee Room",
            "St. Germany, Berlin",
            R.drawable.images1,
        ),
        CardData(
            "Coffee Ibiza",
            "St. Colon, Madrid",
            R.drawable.images2,
        ),
        CardData(
            "Pudding Coffee Shop",
            "St. Diagonal, Barcelona",
            R.drawable.images3,
        ),
        CardData(
            "L'Express",
            "St. Picadilly Circus, London",
            R.drawable.images4,
        ),
        CardData(
            "Coffee Corner",
            "St. Àngel Guimerà",
            R.drawable.images5,
        ),
        CardData(
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam",
            R.drawable.images6,
        )
    )
}

@Composable
fun ItemCard(cardData: CardData) {
    var rating by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE4D6)),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Image(
            painter = painterResource(id = cardData.photo),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Column (Modifier.padding(start = 10.dp)){
            Spacer(modifier = Modifier.height(15.dp))
            Row (Modifier.fillMaxWidth()){
                Text(text = cardData.name,
                    fontFamily = FontTittle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp)
            }

            RatingBar(
                rating = rating,
                onRatingChanged = { newRating ->
                    rating = newRating
                }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = cardData.adress)
            Spacer(modifier = Modifier.height(5.dp))
            Divider()
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color.Transparent, contentColor = Color(0xFFD988B9)
                )
            ) {
                Text(text = "RESERVE")
            }
        }
    }
}


@Composable
fun RatingBar (modifier: Modifier = Modifier,
               rating: Int = 0,
               stars: Int = 5,
               starsColor: Color = Color.Black,
               onRatingChanged: (Int) -> Unit
) {

    Row (modifier = modifier){
        repeat(stars) { starIndex ->
            Icon(
                imageVector = if (starIndex < rating) Icons.Outlined.Star else Icons.Outlined.Clear,
                contentDescription = null,
                tint = starsColor,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { onRatingChanged(starIndex + 1) }
            )
        }
    }
}

@Composable
fun MyModalDrawer() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Opción 1", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(
            text = "Opción 2", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(
            text = "Opción 3", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Text(
            text = "Opción 4", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

