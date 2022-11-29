package io.github.KIID_4.auction.ui.shapes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun joinMember(navController : NavController, toLoginScreen: () -> Unit = {}) {

    val (emailID, setEmailID) = remember { mutableStateOf(TextFieldValue()) }
    val (passWD, setPassWD) = remember { mutableStateOf(TextFieldValue()) }
    val (repassWD, setRepassWD) = remember { mutableStateOf(TextFieldValue()) }
    val (name, setName) = remember { mutableStateOf(TextFieldValue()) }
    val (callNum, setCallNum) = remember { mutableStateOf(TextFieldValue()) }
    val (birthday, setBirthday) = remember { mutableStateOf(TextFieldValue()) }
    val (registerSuccess, setSuccess) = remember { mutableStateOf(false) }

    if (registerSuccess) {
        navController.navigate("userMain")
        setSuccess(false)
    }

    Column(Modifier.padding(8.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(15.dp))
            Text("ID", fontSize = 16.sp)
            Spacer(Modifier.padding(20.dp))
            informationBar("이메일 입력", emailID, setEmailID)
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
            if (emailID.text.isNotEmpty()) Text("사용가능한 아이디 입니다.") // DB정보와 비교하여 코멘트 바꿈
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
            informationBar("비밀번호 입력", passWD, setPassWD)
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
            informationBar("비밀번호 재입력", repassWD, setRepassWD)
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (passWD.text.isNotEmpty() && repassWD.text.isNotEmpty()) {
                if (passWD.text == repassWD.text) {
                    Text("비밀번호가 일치합니다.")
                } else {
                    Text("비밀번호가 일치하지 않습니다.")
                }
            }
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
            informationBar("사용자 이름 입력", name, setName)
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
            informationBar("전화 번호 입력", callNum, setCallNum)
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
            informationBar("생년 월일 입력", birthday, setBirthday)
            Spacer(Modifier.weight(0.9f))
        }
        Spacer(Modifier.padding(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Center
        ) {
            registerButton(navController, emailID.text, passWD.text, toLoginScreen)
        }
    }
}
@Composable
fun Modifiymember(toMypageScreen: () -> Unit) {

    val (passWD, setPassWD) = remember { mutableStateOf(TextFieldValue()) }
    val (repassWD, setRepassWD) = remember { mutableStateOf(TextFieldValue()) }
    val (name, setName) = remember { mutableStateOf(TextFieldValue()) }
    val (callNum, setCallNum) = remember { mutableStateOf(TextFieldValue()) }
    val (birthday, setBirthday) = remember { mutableStateOf(TextFieldValue()) }

    Column(Modifier.padding(8.dp)){
        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(Modifier.padding(12.dp))
            Text("PW", fontSize = 16.sp)
            Spacer(Modifier.padding(20.dp))
            informationBar("비밀번호 입력", passWD, setPassWD)
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
            informationBar("비밀번호 재입력", repassWD, setRepassWD)
            Spacer(Modifier.weight(0.9f))
        }

        Spacer(Modifier.padding(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (passWD.text.isNotEmpty() && repassWD.text.isNotEmpty()) {
                if (passWD.text == repassWD.text) {
                    Text("비밀번호가 일치합니다.")
                } else {
                    Text("비밀번호가 일치하지 않습니다.")
                }
            }
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
            informationBar("사용자 이름 입력", name, setName)
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
            informationBar("전화 번호 입력", callNum, setCallNum)
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
            informationBar("생년 월일 입력", birthday, setBirthday)
            Spacer(Modifier.weight(0.9f))
        }
        Spacer(Modifier.padding(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,  // Text 위젯들 간 세로 중앙 정렬 위함
            horizontalArrangement = Arrangement.Center
        ) {
            modifiyButton(passWD.text, toMypageScreen)
        }
    }
}
