package com.morface.grandmafia_roleplaying.save_image_to_gallery

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URI


fun takeScreenshotOfView(view: View, height: Int, width: Int): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    val bgDrawable = view.background
    if (bgDrawable != null) {
        bgDrawable.draw(canvas)
    } else {
        canvas.drawColor(Color.WHITE)
    }
    view.draw(canvas)

    return bitmap
}

fun saveToGallery(context: Context, bitmap: Bitmap, albumName: String) {
    val filename = "${System.currentTimeMillis()}.png"
    val write: (OutputStream) -> Boolean = {
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
            put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DCIM}/$albumName")
        }

        context.contentResolver.let {
            it.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)?.let { uri ->
                it.openOutputStream(uri)?.let(write)
            }
        }
    } else {
        val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
            .toString() + File.separator + albumName
        val file = File(imagesDir)
        if (!file.exists()) {
            file.mkdir()
        }
        val image = File(imagesDir, filename)
        write(FileOutputStream(image))
    }

//    val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
//        .toString() + File.separator + albumName
//    val file = File(imagesDir)
//    if (!file.exists()) {
//        file.mkdir()
//    }
//    val image = File(imagesDir, filename)
//    val uri = image.toURI()
//    sharePalette(uri, context)

}

//private fun sharePalette(uri: URI, context: Context) {
//    val sharingIntent = Intent(Intent.ACTION_SEND)
//    sharingIntent.type = "image/*"
//    sharingIntent.putExtra(Intent.EXTRA_STREAM, uri)
//
//    context.startActivities(arrayOf(Intent.createChooser(sharingIntent, "Share with")))
//}