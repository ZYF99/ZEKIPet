/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PetModel
import com.example.androiddevchallenge.model.Publisher
import com.example.androiddevchallenge.utils.long2DateString

@SuppressLint("StaticFieldLeak")
private var navController: NavHostController? = null

@Composable
fun buildPetDetailPage(navControllerTmp: NavHostController) {
    navController = navControllerTmp
    val publisher = Publisher(
        System.currentTimeMillis(),
        "Android_ZEKI"
    )
    val petModel =
        PetModel(System.currentTimeMillis(), "", "金毛", "一只活泼可爱的金毛，求带走！", publisher = publisher)

    Column {
        TopAppBar(
            title = {
                Text("宠物详情")
            }
        )
        buildDetail(petModel)
    }
}

@Composable
fun buildDetail(petModel: PetModel) {
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .padding(Dp(16f))
                .fillMaxWidth()
        ) {
            Text(text = "发布者", style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 16.sp, modifier = Modifier.padding(end = 12.dp))
            Row {
                Modifier.padding(16.dp)
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = petModel.publisher?.name ?: "",
                        fontSize = 14.sp,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                    Text(text = long2DateString(petModel.time), fontSize = 10.sp)
                }
                Image(
                    painter = painterResource(id = R.drawable.icon_avatar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(shape = RoundedCornerShape(50))
                )
            }
        }
        Card(
            elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .padding()
        ) {
            Image(
                painter = painterResource(id = R.drawable.pic_dog),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Text(text = petModel.description ?: "", modifier = Modifier.padding(12.dp))
    }
}
