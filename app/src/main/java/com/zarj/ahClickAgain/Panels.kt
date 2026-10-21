package com.zarj.ahClickAgain

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class Panels {





}
@Composable
public fun LowerPanel(packageContext : Context){
    val intent = Intent(packageContext,ShopView::class.java)



    val is_not_shop = remember{ mutableStateOf(!(packageContext::class.java.equals(ShopView::class.java))) }

    System.out.println("PACK = "+ packageContext.packageName+""+is_not_shop)

    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp).background(Color(0xFFc7c953)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            colors= ButtonDefaults.buttonColors(containerColor = Color.Transparent,disabledContentColor = Color.Transparent),
            onClick= {
                packageContext.startActivity(intent)
            },
            enabled = is_not_shop.value
        ){
            Image(
                painter = painterResource(id = R.drawable.shop),
                contentDescription = "Image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        }
    }
}