package com.example.laboratorio5

import android.R.attr.onClick
import android.R.attr.padding
import android.R.attr.text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun GalleryScreen(
    viewModel: GalleryViewModel,
    onPickImage: () -> Unit
){
    //Ver la lista de imagenes del View Model
    val imagenes by viewModel.imagenes.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Fotos")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {onPickImage()}) {
                Icon(Icons.Default.Add, contentDescription = "Agregar foto")
            }
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(imagenes) { uri ->
                Column(modifier = Modifier.padding(8.dp)){
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )
                    Text(
                        text = uri.lastPathSegment ?: "Foto",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}