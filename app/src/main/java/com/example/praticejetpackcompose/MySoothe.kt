package com.example.praticejetpackcompose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import java.util.Locale

@Preview
@Composable
fun MSootheApp() {
    Scaffold(backgroundColor = Color(0xFFeee7e0),
        bottomBar = { SootheBottomNavigation() }
    ) {
        it
        HomeScreen()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.ab_inversions) {
            FavoriteCollectionGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = Color(0xFFeee7e0),
        modifier = modifier
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.show_more))
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_person),
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.show_more))
            }
        )
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(
                id = title
            )
                .uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
            )
        },
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },

        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface)
    )
}


@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color(0xFFeee7e0))
            .padding(all = 5.dp)

    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(68.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}


@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                Modifier
                    .size(60.dp)
                    .padding(1.dp),

                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(text),
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

@Composable
fun FavoriteCollectionGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 10.dp),
        modifier = modifier.height(140.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.iphone1 to R.string.iphone_1,
    R.drawable.iphone2 to R.string.iphone_2,
    R.drawable.iphone3 to R.string.iphone_3,
    R.drawable.iphone4 to R.string.iphone_4,
    R.drawable.iphone5 to R.string.iphone_5,
    R.drawable.iphone6 to R.string.iphone_6,
    R.drawable.iphone7 to R.string.iphone_7,
    R.drawable.iphone8 to R.string.iphone_8,
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.iphone1 to R.string.iphone_1,
    R.drawable.iphone2 to R.string.iphone_2,
    R.drawable.iphone3 to R.string.iphone_3,
    R.drawable.iphone4 to R.string.iphone_4,
    R.drawable.iphone5 to R.string.iphone_5,
    R.drawable.iphone6 to R.string.iphone_6,
    R.drawable.iphone7 to R.string.iphone_7,
    R.drawable.iphone8 to R.string.iphone_8,
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
