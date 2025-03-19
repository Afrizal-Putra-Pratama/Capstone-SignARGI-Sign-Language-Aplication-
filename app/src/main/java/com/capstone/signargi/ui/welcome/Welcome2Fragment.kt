package com.capstone.signargi.ui.welcome

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.capstone.signargi.R

class Welcome2Fragment : Fragment() {
    private var listener: WelcomeFragmentListener? = null
    private lateinit var dots: MutableList<ImageView>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is WelcomeFragmentListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_welcome2, container, false)

        val btnNext = view.findViewById<ImageView>(R.id.btnNext)
        val indicatorLayout = view.findViewById<LinearLayout>(R.id.indicatorLayout)

        btnNext.setOnClickListener {
            listener?.nextPage()
        }

        setupIndicators(indicatorLayout, 3)
        setCurrentIndicator(1)

        return view
    }

    private fun setupIndicators(layout: LinearLayout, count: Int) {
        dots = mutableListOf()
        layout.removeAllViews()

        for (i in 0 until count) {
            val dot = ImageView(requireContext()).apply {
                setImageResource(R.drawable.indicator_inactive)
                val params = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                params.marginEnd = 8
                layoutParams = params
            }
            dots.add(dot)
            layout.addView(dot)
        }
    }

    private fun setCurrentIndicator(index: Int) {
        dots.forEachIndexed { i, imageView ->
            imageView.setImageResource(
                if (i == index) R.drawable.indicator_active else R.drawable.indicator_inactive
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}