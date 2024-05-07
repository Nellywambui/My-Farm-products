package com.example.myfarmproducts.ui.theme.about

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfarmproducts.R
import com.example.myfarmproducts.data.AuthViewModel
import com.example.myfarmproducts.navigation.ROUTE_ABOUT
import com.example.myfarmproducts.navigation.ROUTE_ADD_FRUITS
import com.example.myfarmproducts.navigation.ROUTE_GALLERY
import com.example.myfarmproducts.navigation.ROUTE_HOME
import com.example.myfarmproducts.navigation.ROUTE_LOGIN
import com.example.myfarmproducts.navigation.ROUTE_REGISTER
import com.example.myfarmproducts.ui.theme.MyFarmProductsTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = {Text(text = "Farm Produce",
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        },
        navigationIcon ={
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Home, contentDescription ="Home", tint = Color.Blue )

    }
    },
        colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.White ,
        titleContentColor = Color.Black ,
        navigationIconContentColor = Color.White),
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "You have clicked the notification icon", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "notification",
                    tint = Color.DarkGray
                )
            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "You have clicked the many given options",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        }
    )
}

@Composable
fun AboutScreen(navController: NavController, userid: String){
    Box (modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.tea),
            contentDescription = "Farm Produce",
            contentScale = ContentScale.FillBounds
        )

    }
    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        TopBar()
        Text(text = "ABOUT PAGE",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )



        Text(text = "This is used by clients to purchase farm products online the products include: fruits, vegetables,animal products.")
        Text(
            text = userid,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp)
        )
        Button(onClick = {navController.navigate(ROUTE_HOME)},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)
            ) {
            Text(text = "HOME")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {navController.navigate("$ROUTE_GALLERY/$userid")},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Cyan)
        ) {
            Text(text = "GALLERY")
        }

    }
}


@Preview
@Composable
fun AboutScreenPreview() {
    AboutScreen(navController = rememberNavController(), userid = "")

}




