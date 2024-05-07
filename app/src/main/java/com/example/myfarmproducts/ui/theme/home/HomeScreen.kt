package com.example.myfarmproducts.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfarmproducts.R
import com.example.myfarmproducts.data.AuthViewModel
import com.example.myfarmproducts.navigation.ROUTE_ADD_FRUITS
import com.example.myfarmproducts.navigation.ROUTE_HOME
import com.example.myfarmproducts.navigation.ROUTE_LOGIN
import com.example.myfarmproducts.navigation.ROUTE_REGISTER
import com.example.myfarmproducts.navigation.ROUTE_VIEW_FRUITS

@Composable
fun Background(navController: NavController){
    Box {
     Image(painter = painterResource(id = R.drawable.farm),
         contentDescription = "Farm Produce", contentScale = ContentScale.FillBounds)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HOME SCREEN",
            color = Color.Magenta,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)

        }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)
        ) {
            Text(text = "Register")

        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ROUTE_LOGIN) },
            modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Cyan))
        {
            Text(text = "Have an Account? Click to Login")

        }



    }


}




@Preview(
    showSystemUi = true,
    showBackground = true
)

@Composable
fun MyPreview() {
    Background(navController = rememberNavController())

}




