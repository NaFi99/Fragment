package com.example.flexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class HomeFragment : Fragment(), View.OnClickListener {

    /*
   Pada HomeFragment terdapat metode onCreateView()
   di mana layout interface didefinisikan dan ditransformasikan
   dari layout berupa file xml ke dalam objek view dengan menggunakan metode inflate()
    */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /*
Di sini kita bisa gunakan untuk inisialisasi view,
dan juga mengatur action-nya (set listener)
 */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if(v.id == R.id.btn_category){
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply{
                replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
            addToBackStack(null)
                commit()
            }
        }

    }
}