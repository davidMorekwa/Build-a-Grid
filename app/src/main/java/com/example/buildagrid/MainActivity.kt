package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridCells.Adaptive
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.model.Topic
import com.example.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicList(topicList = DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic,modifier: Modifier = Modifier) {
    Card(
        elevation = 10.dp,
        modifier = modifier
            .height(68.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = stringResource(id = topic.name),
                modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(start = 16.dp)) {
                Text(text = stringResource(id = topic.name), style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(end = 16.dp)
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(text = topic.number.toString(), style = MaterialTheme.typography.caption)
                }

            }
        }
    }
//    Spacer(modifier = modifier.height(8.dp))
}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
        columns = Adaptive(120.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ){
        items(topicList){
            item: Topic -> TopicCard(topic = item)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuildAGridTheme {
//        TopicList(topicList = DataSource.topics)
    }
}