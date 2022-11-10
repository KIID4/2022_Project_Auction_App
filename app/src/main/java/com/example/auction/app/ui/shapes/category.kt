package com.example.auction.app.ui.shapes

import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import io.github.untactorder.toasterAtSnackBar.InjectableSnackBar
import io.github.untactorder.toasterAtSnackBar.IosSimpleToast
import io.github.untactorder.toasterAtSnackBar.PastelColorSet
import io.github.untactorder.toasterAtSnackBar.PastelToast


@Composable
fun category(injector: InjectableSnackBar) {

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(onClick = {},
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("온라인 경매", color = Color(0xff613838), fontSize = 22.sp)
            }

            Spacer(Modifier.padding(5.dp))

            Button(onClick = {
                injector.showSnackbar(
                    "This is a error notification. Please retry the previous action",
                    title = "An Error Occurred",
                    withDismissAction = true,
                    actionLabel = "Okay",
                    customToastDesign = { data ->
                        PastelToast(data, containerColor = PastelColorSet.plain)
                    }
                )
            },
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffF198FF))
            ) {
                Text("물품 등록", color = Color(0xff613838), fontSize = 25.sp)
            }

            Spacer(Modifier.padding(5.dp))

            Button(onClick = {},
                modifier = Modifier.size(width = 120.dp, height = 120.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("게시판", color = Color(0xff613838), fontSize = 25.sp)
            }
        }
        Button(onClick = {
            injector.showSnackbar(
                "Hi there! Welcome to the Toast! Have a nice day!",
                customToastDesign = { data ->
                    IosSimpleToast(data, darkBackground = false, toastWidth = 250.dp)
                }
            )
        },
            modifier = Modifier.size(width = 390.dp, height = 80.dp).padding(start = 15.dp, top = 15.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text("공지사항", color = Color(0xff613838), fontSize = 25.sp)
        }
    }
}


