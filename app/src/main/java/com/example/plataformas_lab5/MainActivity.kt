package com.example.plataformas_lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.plataformas_lab5.ui.theme.Plataformas_Lab5Theme
import android.net.Uri
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.plataformas_lab5.GalleryScreen
import com.example.plataformas_lab5.GalleryViewModel

class MainActivity : ComponentActivity() {

    //Conectar con ViewModel
    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Registrar el photo picker
        val pickFotos = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
                uri: Uri? -> uri?.let{
            viewModel.agregarImagen(it) //Se agrega la imagen al ViewModel
        }
        }

        setContent {
            Plataformas_Lab5Theme {
                Surface(color = MaterialTheme.colorScheme.background){
                    GalleryScreen(
                        viewModel = viewModel,
                        onPickImage = {
                            pickFotos.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }
                    )
                }
            }
        }
    }
}