package com.example.myfarmproducts.ui.theme.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.loginregistration.FruitsList
import com.example.myfarmproducts.data.FruitViewModel
import com.example.myfarmproducts.models.Fruits
import com.example.myfarmproducts.ui.theme.MyFarmProductsTheme

@Composable
fun ViewFruitsScreen(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val fruitRepository = FruitViewModel(navController, context)
        val emptyFruitState = remember { mutableStateOf(Fruits("","","","")) }
        val emptyFruitsListState = remember { mutableStateListOf<Fruits>() }

        val fruits = fruitRepository.viewFruits(emptyFruitState, emptyFruitsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
//                navController.navigate(ROUTE_HOME)
            }) {
                Text(text = "Back to Home Screen")
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn {
                items(fruits){
                    FruitItem(
                        fruitName = it.fruitName,
                        fruitPrice = it.fruitPrice,
                        fruitImageUrl = it.fruitImageUrl,
                        id = it.id,
                        navController = navController,
                        fruitRepository = fruitRepository
                    )

                }
            }
        }
    }
}
@Composable
fun FruitItem(
    fruitName:String,
    fruitPrice:String,
    fruitImageUrl:String,
    id: String,
    navController:NavHostController,
    fruitRepository:FruitViewModel
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Green)
        .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(fruitImageUrl),
            contentDescription = null,
            modifier = Modifier
                .padding(13.dp)
                .size(300.dp)
        )
        Text(text = fruitName)
        Text(text = fruitPrice)
    }

}


@Preview(showBackground = true)
@Composable
fun ViewFruitsScreenPreview() {
    MyFarmProductsTheme {
        ViewFruitsScreen(navController = rememberNavController())
    }
}