package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun joinMember() {

    var emailID : String? = null
    var passWD : String? = null
    var repassWD : String? = null
    var name : String? = null
    var callnumber : String? = null
    var birthday : String? = null

    Column(Modifier.padding(8.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(15.dp))
            Text("ID", fontSize = 16.sp)
            Spacer(Modifier.padding(20.dp))
            emailID = informationBar("이메일 입력")
            Spacer(Modifier.weight(0.1f))
            duplicationButton()
            Spacer(Modifier.weight(0.1f))
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("사용가능한 아이디 입니다.") // DB정보와 비교하여 코멘트 바꿈
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(12.dp))
            Text("PW", fontSize = 16.sp)
            Spacer(Modifier.padding(20.dp))
            passWD = informationBar("비밀번호 입력")
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(2.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(8.dp))
            Text("PW확인", fontSize = 16.sp)
            Spacer(Modifier.padding(14.dp))
            repassWD = informationBar("비밀번호 재입력")
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if(passWD == repassWD) Text("비밀번호가 일치합니다.")
            else Text("비밀번호가 일치하지 않습니다")
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(10.dp))
            Text("이름", fontSize = 16.sp)
            Spacer(Modifier.padding(20.dp))
            name = informationBar("사용자 이름 입력")
            Spacer(Modifier.weight(0.9f))
        }
        Spacer(Modifier.padding(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(4.dp))
            Text("전화 번호", fontSize = 16.sp)
            Spacer(Modifier.padding(14.dp))
            callnumber = informationBar("전화 번호 입력")
            Spacer(Modifier.weight(0.9f))
        }
        Spacer(Modifier.padding(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(4.dp))
            Text("생년 월일", fontSize = 16.sp)
            Spacer(Modifier.padding(14.dp))
            birthday = informationBar("생년 월일 입력")
            Spacer(Modifier.weight(0.9f))
        }
        Spacer(Modifier.padding(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Center
        ) {
            registerButton(emailID, passWD)
        }
    }
}

