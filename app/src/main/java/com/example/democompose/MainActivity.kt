package com.example.democompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.democompose.ui.theme.DemoComposeTheme
import com.example.democompose.ui.theme.OffWhite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileCard()
                }
            }
        }
    }
}

@Composable
private fun ProfileCard() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = OffWhite)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicture()
                Divider(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(0.dp, 10.dp),
                    color = MaterialTheme.colorScheme.primary,
                    thickness = 4.dp
                )
                ProfileInfo()
            }
        }
    }
}

@Composable
private fun ProfileInfo() {
    val context = LocalContext.current
    Text(text = "Alexandre Girard")
    Text(text = "Compose Developper")
    Text(text = "@yellowKiwi")
    Button(onClick = { Toast.makeText(context, "Toast du bouton", Toast.LENGTH_LONG).show() }) {
        Text(text = stringResource(id = R.string.portfolio))
    }
}

@Composable
private fun ProfilePicture() {

}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    DemoComposeTheme {
        ProfileCard()
    }
}


/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoComposeTheme {
        Greeting("Android")
    }
}*/