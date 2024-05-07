package com.example.myfarmproducts.ui.theme.delivery

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myfarmproducts.data.FruitViewModel
import com.example.myfarmproducts.models.Users
import com.example.myfarmproducts.navigation.ROUTE_LAST
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun deliveryScreen(navController: NavHostController, userid: String) {
    var context = LocalContext.current
    var locationOptions = listOf(
        "Westlands",
        "Ruaka",
        "Thika",
        "Lavington",
        "Kileleshwa",
        "Ruiru",
        "Juja"
    )
    var isLocationExpanded by remember {
        mutableStateOf(false)
    }
    var location by remember {
        mutableStateOf(locationOptions[0])
    }

    var mUserid by remember {
        mutableStateOf(userid)
    }

//    var currentDataRef = FirebaseDatabase.getInstance().getReference().child("Users/$userid")
//    currentDataRef.addValueEventListener(object: ValueEventListener {
//        override fun onDataChange(snapshot: DataSnapshot) {
//            var user = snapshot.getValue(Users::class.java)
//            if (user != null) {
//                mUserid = user.userid
//            }else{
//                Toast.makeText(context, "Error fetching user id", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//        }
//    })

    Column {
        TextField(value = mUserid,
            onValueChange = {}
        )
        Row(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 0.dp,
                    bottom = 0.dp
                )
                .border(width = Dp.Hairline, color = Color.White)
        ) {
            Text(
                text = "Location:",
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                color = Color.White
            )
            ExposedDropdownMenuBox(
                expanded = isLocationExpanded,
                onExpandedChange = { isLocationExpanded = !isLocationExpanded }
            ) {
                TextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            end = 10.dp,
                            top = 0.dp,
                            bottom = 0.dp
                        ),
                    value = location,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isLocationExpanded) },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Magenta,
                        unfocusedTextColor = Color.Red,
                        focusedContainerColor = Color.Cyan,
                        unfocusedContainerColor = Color.Green,
                        disabledContainerColor = Color.White,
                        focusedLabelColor = Color.Green,
                        unfocusedLabelColor = Color.Magenta
                    ),
                )
                ExposedDropdownMenu(
                    expanded = isLocationExpanded,
                    onDismissRequest = { isLocationExpanded = false }) {
                    locationOptions.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = { location = locationOptions[index] },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }

            }
        }
        Text(text = "Currently Selected: $location")

        Button(onClick = {navController.navigate(ROUTE_LAST)
            var myDelivery = FruitViewModel(navController, context)
            myDelivery.makeDelivery(
                userid,
                location
            )
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}




@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun deliveryScreenPreview(){
    deliveryScreen(navController = rememberNavController(), userid = "")
}