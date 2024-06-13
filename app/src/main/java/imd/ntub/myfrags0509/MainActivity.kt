//11056051 梁詔恩 11056036徐湘婷 11056015許有騫 
package imd.ntub.myfrags0509

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstFragment = FirstFragment.newInstance()
        secondFragment = SecondFragment.newInstance(intent.getLongExtra("CONTACT_ID", 0))

        class ViewPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
            override fun getItemCount() = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> firstFragment
                    1 -> SecondFragment.newInstance()
                    2 -> ThirdFragment.newInstance(
                        "11056051 梁詔恩" +
                                "\b 11056036 徐湘婷" + "\n 11056015 許有騫"
                    )

                    else -> firstFragment
                }
            }
        }
        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = ViewPagerAdapter(this)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            viewPager.currentItem = 0
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            viewPager.setCurrentItem(1, true)
        }
        findViewById<Button>(R.id.btn3).setOnClickListener {
            viewPager.setCurrentItem(2, true)
        }

    }

    fun navigateToSecondFragment(bundle: Bundle) {
        val secondFragment = SecondFragment.newInstance()
        secondFragment.arguments = bundle
        viewPager.currentItem = 1
    }

    override fun onBackPressed() {
        if(viewPager.currentItem > 0){
            viewPager.currentItem = viewPager.currentItem-1
        }else{
            super.onBackPressed()
        }
    }
}

