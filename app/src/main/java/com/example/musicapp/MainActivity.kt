package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicapp.ui.theme.MusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                Orientation()
            }
        }
    }
}

@Composable
fun Orientation() {
    val configuration = LocalConfiguration.current

    if (configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
        MusicAppInterfaceLandscape()
    } else {
        MusicAppInterface()
    }
}

@Composable
fun MusicAppInterface() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFB9D3EF)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxHeight()
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.imagen),
                    contentDescription = "Imagen personalizada",
                    modifier = Modifier.size(350.dp)
                )
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Ed Sheeran",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Shape of you",
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp)) {
                LinearProgressIndicator(
                    progress = { 0.25f },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "01:00",
                        fontSize = 10.sp
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "-03:00",
                        fontSize = 10.sp
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.anteriorpeque),
                            contentDescription = "Botón de canción anterior",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val isPlaying = remember { mutableStateOf(false) }
                    if (isPlaying.value) {
                        IconButton(
                            onClick = {isPlaying.value = false},
                            modifier = Modifier.size(45.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pausepeque),
                                contentDescription = "Botón de pausa",
                                modifier = Modifier.size(45.dp)
                            )
                        }
                    } else{
                        IconButton(
                            onClick = {isPlaying.value = true},
                            modifier = Modifier.size(45.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playpeque),
                                contentDescription = "Botón de reproducción",
                                modifier = Modifier.size(45.dp)
                            )
                        }

                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.siguientepeque),
                            contentDescription = "Botón de canción siguiente",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.listapeque),
                            contentDescription = "Botón de lista de canciones",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.compartirpeque),
                            contentDescription = "Botón de compartir",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.letrapeque),
                            contentDescription = "Botón de letra",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.volumenpeque),
                        contentDescription = "Imagen de volumen",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    var volume by remember { mutableStateOf(0.7f) }
                    Slider(
                        value = volume,
                        onValueChange = { newVolume -> volume = newVolume },
                        valueRange = 0f..1f,
                        steps = 9,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun MusicAppInterfaceLandscape() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFB9D3EF)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.imagen),
                        contentDescription = "Imagen personalizada",
                        modifier = Modifier.size(300.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(20.dp)
                ) {
                    LinearProgressIndicator(
                        progress = { 0.25f },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "01:00",
                            fontSize = 10.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "-03:00",
                            fontSize = 10.sp
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.volumenpeque),
                            contentDescription = "Imagen de volumen",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        var volume by remember { mutableStateOf(0.7f) }
                        Slider(
                            value = volume,
                            onValueChange = { newVolume -> volume = newVolume },
                            valueRange = 0f..1f,
                            steps = 9,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Ed Sheeran",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Shape of you",
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.anteriorpeque),
                            contentDescription = "Botón de canción anterior",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.listapeque),
                            contentDescription = "Botón de lista de canciones",
                            modifier = Modifier.size(45.dp)
                        )

                    }

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    val isPlaying = remember { mutableStateOf(false) }
                    if (isPlaying.value) {
                        IconButton(
                            onClick = {isPlaying.value = false},
                            modifier = Modifier.size(45.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.pausepeque),
                                contentDescription = "Botón de pausa",
                                modifier = Modifier.size(45.dp)
                            )
                        }
                    } else{
                        IconButton(
                            onClick = {isPlaying.value = true},
                            modifier = Modifier.size(45.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.playpeque),
                                contentDescription = "Botón de reproducción",
                                modifier = Modifier.size(45.dp)
                            )
                        }

                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.compartirpeque),
                            contentDescription = "Botón de compartir",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.siguientepeque),
                            contentDescription = "Botón de canción siguiente",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.letrapeque),
                            contentDescription = "Botón de leer la letra",
                            modifier = Modifier.size(45.dp)
                        )

                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicAppTheme {
        MusicAppInterfaceLandscape()
    }
}