package com.example.plataformas_lab5

import android.net.Uri
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GalleryViewModel : ViewModel(){

    //Se guardan las imagenes seleccionadas
    private val img = MutableStateFlow<List<Uri>>(emptyList())
    val imagenes: StateFlow<List<Uri>> = img


    //Funcion para agregar una nueva imagen a la lista
    fun agregarImagen(uri: Uri){
        img.value = img.value + uri
    }
}