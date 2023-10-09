package app.risqiikhsani.cobacoba


import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.risqiikhsani.cobacoba.ui.theme.CobacobaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobacobaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

data class Item(
        val image: Int,
        val title: String,
        val text: String
)


@Composable
fun MyApp() {

    val items = generateItems()

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = items[currentIndex].image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.Magenta)
                .padding(20.dp)
        ) {
            Text(
                text = items[currentIndex].title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = items[currentIndex].text,
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // Push buttons to the bottom

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = {
                    currentIndex = (currentIndex - 1 + items.size) % items.size
                },
                enabled = currentIndex > 0,
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % items.size
                },
                enabled = currentIndex < items.size - 1,
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun generateItems(): List<Item> {
    val item1 = Item(image = R.drawable.cat1, title = "Bob", text = "Kucing imut")
    val item2 = Item(image = R.drawable.cat2, title = "Lui", text = "Kucing imut")
    val item3 = Item(image = R.drawable.cat3, title = "Cutz", text = "Kucing imut")
    val item4 = Item(image = R.drawable.cat4, title = "Tom", text = "Kucing imut")
    val item5 = Item(image = R.drawable.cat5, title = "Rey", text = "Kucing imut")
    val item6 = Item(image = R.drawable.cat6, title = "Angela", text = "Kucing imut")
    val item7 = Item(image = R.drawable.cat7, title = "Sweet", text = "Kucing imut")
    val item8 = Item(image = R.drawable.cat8, title = "Fren", text = "Kucing imut")
    val item9 = Item(image = R.drawable.cat9, title = "Muy", text = "Kucing imut")
    val item10 = Item(image = R.drawable.cat10, title = "Rey", text = "Kucing imut")

    return listOf(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CobacobaTheme {
    }
}