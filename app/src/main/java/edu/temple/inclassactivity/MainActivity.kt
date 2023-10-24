package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        val imageDisplayFragment = ImageDisplayFragment.newInstance(imageArray)

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView)!is ImageDisplayFragment)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,imageDisplayFragment)
            .addToBackStack(null)
            .setReorderingAllowed(true)
            .commit()
    }

    fun imageSelected(itemId:Int){
        Toast.makeText(this,"You selected $itemId",Toast.LENGTH_SHORT).show()
    }
}
