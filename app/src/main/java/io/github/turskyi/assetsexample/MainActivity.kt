package io.github.turskyi.assetsexample

import android.content.res.AssetManager
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showWhatInAssets()
        initView()
    }

    private fun showWhatInAssets() {
        val myAssetManager = applicationContext.assets
        try {
            /* array of filenames */
            val files = myAssetManager.list("")
            files?.let {
                Toast.makeText(applicationContext, files[0].toString() + ", " + files[1],
                        Toast.LENGTH_LONG).show()
            }
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
    }

    private fun initView() {
        et1.typeface = Typeface.createFromAsset(assets, "fonts/friday_stroke.otf")
        et2.typeface = Typeface.createFromAsset(assets, "fonts/metal_shard.ttf");
        loadImageFromAsset()
    }

    private fun loadImageFromAsset() {
        try {
            /* get the input stream */
            val ims = assets.open("images/cat.jpg")
            /* load as Drawable */
            val d = Drawable.createFromStream(ims, null)
            /* display the image in ImageView */
            mImage.setImageDrawable(d)
        } catch (ex: IOException) {
            return
        }
    }

}