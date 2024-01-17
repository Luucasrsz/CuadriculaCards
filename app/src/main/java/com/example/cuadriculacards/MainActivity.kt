package com.example.cuadriculacards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadriculacards.Data.DataSource
import com.example.cuadriculacards.Model.Topic
import com.example.cuadriculacards.ui.theme.CuadriculaCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaCardsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicList(DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier.size(dimensionResource((R.dimen.padding_big))),
                contentScale = ContentScale.Crop
            )


            Column {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    modifier = Modifier.padding(
                        start = dimensionResource((R.dimen.padding_medium)),
                        top = dimensionResource((R.dimen.padding_medium)),
                        end = dimensionResource((R.dimen.padding_medium)),
                        bottom = dimensionResource((R.dimen.padding_small))
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        modifier = Modifier.padding(start = dimensionResource((R.dimen.padding_medium))),
                        contentDescription = stringResource(R.string.icon)
                    )

                    Text(
                        text = topic.modelVersion.toString(),
                        modifier = Modifier.padding(start = dimensionResource((R.dimen.padding_small))),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

        }
    }
}

@Composable
fun TopicList(topicList: List<Topic>) {

        LazyVerticalGrid(columns = GridCells.Fixed(2),
            verticalArrangement =  Arrangement.spacedBy(dimensionResource((R.dimen.padding_small))),
            horizontalArrangement =  Arrangement.spacedBy(dimensionResource((R.dimen.padding_small))),
            contentPadding = PaddingValues(dimensionResource((R.dimen.padding_small)))
            ) {
            items(topicList) { topic ->
                TopicCard(topic = topic)
            }
        }



}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadriculaCardsTheme {
        TopicList(DataSource.topics)
    }
}