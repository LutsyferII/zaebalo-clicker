package com.zarj.ahClickAgain

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import com.zarj.ahClickAgain.ui.theme.ZaebaloTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.zarj.ahClickAgain.market.Market
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class ShopView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val this_c = this
        val sharedPreferences = this.getSharedPreferences("SHKOTEL", MODE_PRIVATE)
        setContent {
            ZaebaloTheme {
                val scroll_enable = remember{mutableStateOf(true)}

                val coins_text = remember{ mutableStateOf("${Player.coins}") }
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()){
                    Column(
                        modifier = Modifier
                            .verticalScroll(
                                state = ScrollState(1),
                                enabled = scroll_enable.value
                            )
                            .fillMaxSize()
                    ){
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray)){
                            Spacer(modifier = Modifier.width(50.dp))
                            Image(
                                painter = painterResource(id = R.drawable.coin),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .height(25.dp)
                                    .width(25.dp)
                            )
                            Text("${coins_text.value}")

                        }
                        for(slot in Market.getSlots()){
                            System.out.println("TEST "+slot.weaponImg)
                            //ShopSlot(slot,sharedPreferences,coins_text)


                        }
                        Button(onClick = {
                            Player.coins = Player.coins
                        }){
                            Text("UPDATE")
                        }

                    }
                    LowerPanel(packageContext = this_c)
                }

            }
        }

    }
    fun getContext(): Context {
        return this.getContext()
    }
}


