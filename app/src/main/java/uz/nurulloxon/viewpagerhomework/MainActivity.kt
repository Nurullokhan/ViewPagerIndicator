package uz.nurulloxon.viewpagerhomework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import uz.nurulloxon.viewpagerhomework.Adapters.ViewPagerAdapterIndicator
import uz.nurulloxon.viewpagerhomework.Models.ViewData
import uz.nurulloxon.viewpagerhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingA: ActivityMainBinding
    lateinit var itemList: ArrayList<ViewData>
    lateinit var viewPagerAdapterIndicator: ViewPagerAdapterIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingA = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingA.root)

        loadData()

        viewPagerAdapterIndicator = ViewPagerAdapterIndicator(itemList)
        bindingA.viewPager.adapter = viewPagerAdapterIndicator

        indicator()
        currentIndicator(0)

        bindingA.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentIndicator(position)
            }
        })

        bindingA.skipBtn.setOnClickListener {
            if (bindingA.viewPager.currentItem + 1 < viewPagerAdapterIndicator.itemCount) {
                bindingA.viewPager.currentItem = bindingA.viewPager.currentItem + 1
            } else {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
//                finish()
            }
        }

    }

    private fun loadData() {
        itemList = ArrayList()
        itemList.add(ViewData("Xush kelibsiz1", "Salom salom1", R.drawable.background_one))
        itemList.add(ViewData("Xush kelibsiz2", "Salom salom2", R.drawable.background_two))
        itemList.add(ViewData("Xush kelibsiz3", "Salom salom3", R.drawable.background_three))
        itemList.add(ViewData("Xush kelibsiz3", "Salom salom3", R.drawable.background_four))
    }

    private fun indicator() {
        val imageIndicator = arrayOfNulls<ImageView>(viewPagerAdapterIndicator.itemCount)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in imageIndicator.indices) {
            imageIndicator[i] = ImageView(applicationContext)
            imageIndicator[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.indicator_inactive
                )
            )
            imageIndicator[i]?.layoutParams = layoutParams
            bindingA.indicator.addView(imageIndicator[i])
        }
    }

    @SuppressLint("SetTextI18n")
    private fun currentIndicator(index: Int) {
        val childCount = bindingA.indicator.childCount
        for (i in 0 until childCount) {
            val imageView: ImageView = bindingA.indicator.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.indicator_active)
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
//        if (index == viewPagerAdapterIndicator.itemCount - 1) {
//            binding.skipBtn.text = "O'tkazib yuborish"
//        } else {
//            binding.skipBtn.text = "Next"
//        }
    }
}