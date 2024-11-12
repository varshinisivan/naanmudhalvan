package com.example.owlapplication  // Package declaration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {  // Main class declaration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyApp(this)  // Calling the composable function
        }
    }
}

@Composable
fun StudyApp(context: Context) {  // Composable function definition
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Title text at the top
        Text(
            text = "Study Material",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFA500),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Card 1
        StudyCard(
            context = context,
            intentClass = MainActivity2::class.java,
            imageRes = R.drawable.img_1,
            courseRes = R.string.course1,
            topicRes = R.string.topic1,
            imageScale = 1.2F
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Card 2
        StudyCard(
            context = context,
            intentClass = MainActivity3::class.java,
            imageRes = R.drawable.img_2,
            courseRes = R.string.course2,
            topicRes = R.string.topic2,
            imageScale = 1.4F
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Card 3
        StudyCard(
            context = context,
            intentClass = MainActivity4::class.java,
            imageRes = R.drawable.img_3,
            courseRes = R.string.course3,
            topicRes = R.string.topic3,
            imageScale = 1.2F
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Card 4
        StudyCard(
            context = context,
            intentClass = MainActivity5::class.java,
            imageRes = R.drawable.img_4,
            courseRes = R.string.course4,
            topicRes = R.string.topic4,
            imageScale = 1.2F
        )

    }
}

@Composable
fun StudyCard(
    context: Context,
    intentClass: Class<*>,
    imageRes: Int,
    courseRes: Int,
    topicRes: Int,
    imageScale: Float
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clickable {
                context.startActivity(
                    Intent(context, intentClass)
                )
            },
        elevation = androidx.compose.material3.CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "",
                modifier = Modifier
                    .height(150.dp)
                    .scale(scaleX = imageScale, scaleY = 1F)
            )
            Text(
                text = stringResource(id = courseRes),
                color = Color(0xFFFFA500),
                fontSize = 16.sp
            )
            Text(
                text = stringResource(id = topicRes),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
