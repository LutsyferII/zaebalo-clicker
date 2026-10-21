package com.zarj.ahClickAgain

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zarj.ahClickAgain.items.Inventory
import com.zarj.ahClickAgain.items.ItemStack

@Composable
fun OpenInventory(sp : SharedPreferences, text: MutableState<String>){

    Spacer(modifier = Modifier.height(200.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.rama_2),null, contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .fillMaxWidth()
            ){
                val items :List<ItemStack> =  Inventory.getItems()

                var rows = items.size/4
                if(items.size%4!=0){
                    rows++
                }
                var times = 0
                for(i in 1..rows){
                    Spacer(modifier = Modifier.height(30.dp));
                    Row(horizontalArrangement = Arrangement.Start,modifier = Modifier.fillMaxWidth()){
                        for(i in 1..4){
                            Spacer(modifier = Modifier.width(13.dp));

                            if(items.size>times){
                                ItemSlot(items.get(times))
                            }
                            times++
                        }
                    }
                }
            }
        }


    }

}
@SuppressLint("UnrememberedMutableState")
@Composable
fun ItemSlot(item : ItemStack){
    val img = LocalContext.current.resources.getIdentifier(item.img, "drawable", LocalContext.current.packageName)
    val rar = LocalContext.current.resources.getIdentifier(item.rarity.colorImg, "drawable", LocalContext.current.packageName)
    val am = mutableStateOf(""+item.amount)

    Button(
        colors = ButtonDefaults.buttonColors(disabledContentColor = Color.Unspecified, disabledContainerColor = Color.Transparent, containerColor = Color.Transparent),
        enabled = item.isConsumable,
        onClick = {
            item.consum()
            am.value = ""+item.amount
        },
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(width = 86.dp, height = 105.dp)
    ){
        Box(
            contentAlignment = Alignment.BottomCenter
        ){
            Image(painter = painterResource(id = rar),
                contentDescription = "Image",
                modifier = Modifier
                    .height(105.dp)
                    .width(86.dp)
            )
            Image(painter = painterResource(id = R.drawable.item_rama),
                contentDescription = "Image",
                modifier = Modifier
                    .height(105.dp)
                    .width(86.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(105.dp).width(86.dp)
            ){
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "Image",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                )
            }
            Text(am.value,fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 15.sp)
        }

    }
























}