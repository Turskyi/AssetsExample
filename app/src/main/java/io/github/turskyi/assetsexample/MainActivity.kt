package io.github.turskyi.assetsexample

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.turskyi.assetsexample.databinding.ActivityMainBinding
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.et1.typeface = Typeface.createFromAsset(assets, "fonts/friday_stroke.otf")
        binding.et2.typeface = Typeface.createFromAsset(assets, "fonts/metal_shard.ttf")
        loadImageFromAsset()
    }

    private fun loadImageFromAsset() {
        try {
            /* get the input stream */
            val inputStream: InputStream = assets.open("images/cat.jpg")
            /* load as Drawable */
            val drawable:Drawable = Drawable.createFromStream(inputStream, null)
            /* display the image in ImageView */
            binding.mImage.setImageDrawable(drawable)
        } catch (ex: IOException) {
            return
        }
    }

}