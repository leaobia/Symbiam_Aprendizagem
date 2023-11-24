package com.example.symbiancadastro

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.symbiancadastro.ui.theme.SymbianCadastroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SymbianCadastroTheme {
                // Create a mutable state to hold the URI
                val fotoUri = remember { mutableStateOf<Uri?>(null) }

                // Call the login function with the fotoUri parameter
                login(fotoUri = fotoUri)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun login(fotoUri: MutableState<Uri?>) {


    var emailState = rememberSaveable {
        mutableStateOf("")
    }

    var lockState = rememberSaveable {
        mutableStateOf("")
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        fotoUri.value = it
    }


    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(fotoUri.value)
            .build()
    )


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
            ) {
                Text(
                    text = "Bem-Vindo",
                    color = Color(130, 6, 240),
                    fontSize = 50.sp,
                    fontWeight = FontWeight(700)
                )
                Text(
                    text = "Tela de Cadastro do Sybiam",
                    color = Color(160, 156, 156),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
            }





            Spacer(modifier = Modifier.height(30.dp))


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 18.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Box(
                        modifier = Modifier.size(150.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier.size(150.dp)
                        )

                        Image(
                            painter = painter,
                            contentDescription = "",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = CircleShape)
                                .clickable {
                                    launcher.launch("image/*")
                                },
                            contentScale = ContentScale.Crop
                        )
                    }
                }


                Spacer(modifier = Modifier.height(23.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(150, 6, 240)),
                        modifier = Modifier
                            .width(180.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp)
                    ) {
                        Text(
                            text = "Enviar imagem",
                            color = Color(255, 255, 255),
                            fontWeight = FontWeight(800)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(23.dp))
                OutlinedTextField(
                    value = "", onValueChange = {
                        emailState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    label = { Text(text = "Login") },
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = "", onValueChange = {
                        lockState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    label = { Text(text = "Senha") },
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(modifier = Modifier.height(23.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(150, 6, 240)),
                        modifier = Modifier
                            .width(120.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp)
                    ) {
                        Text(
                            text = "Cadastrar",
                            color = Color(255, 255, 255),
                            fontWeight = FontWeight(800)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(35.dp))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 730.dp)  ,
            horizontalArrangement = Arrangement.Start

        ) {
            Surface(
                modifier = Modifier
                    .width(140.dp)
                    .height(50.dp),
                color = Color(200, 6, 240),
                shape = RoundedCornerShape(0.dp, 16.dp, 0.dp, 0.dp)
            ) {

            }

        }
    }
}

