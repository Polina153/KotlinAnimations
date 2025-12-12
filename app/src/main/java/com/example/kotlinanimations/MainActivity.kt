package com.example.kotlinanimations

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinanimations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val textShader = LinearGradient(
            0f, 0f,
            binding.text.paint.measureText(binding.text.toString()),
            binding.text.textSize,
            intArrayOf(Color.YELLOW, Color.GREEN, Color.BLUE),
            null,
            Shader.TileMode.CLAMP
        )
        binding.text.paint.shader = textShader
        binding.text.invalidate()

/*        ValueAnimator.ofObject(
            GradientArgbEvaluator,
            intArrayOf(Color.MAGENTA, Color.MAGENTA, Color.MAGENTA),
            intArrayOf(Color.MAGENTA, Color.MAGENTA, Color.BLUE),
            intArrayOf(Color.MAGENTA, Color.BLUE, Color.BLACK),
            intArrayOf(Color.BLUE, Color.BLACK, Color.RED),
            intArrayOf(Color.BLACK, Color.RED, Color.GREEN),
            intArrayOf(Color.BLACK, Color.GREEN, Color.BLUE),
            intArrayOf(Color.GREEN, Color.BLUE, Color.CYAN),
            intArrayOf(Color.BLUE, Color.CYAN, Color.MAGENTA),
            intArrayOf(Color.CYAN, Color.YELLOW, Color.MAGENTA),
        ).apply {
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            duration =  3000
            addUpdateListener {
                val shader = LinearGradient(
                    0f, 0f,
                    binding.text.paint.measureText(binding.text.text.toString()),
                    binding.text.textSize,
                    it.animatedValue as IntArray,
                    null,
                    Shader.TileMode.CLAMP
                )
                binding.text.paint.shader = shader
                binding.text.invalidate()
            }
            start()
        }
    }


    object GradientArgbEvaluator : TypeEvaluator<IntArray> {

        private val argbEvaluator = ArgbEvaluator()
        override fun evaluate(
            fraction: Float,
            startValue: IntArray?,
            endValue: IntArray?
        ): IntArray {
            return startValue!!.mapIndexed { index, item ->
                argbEvaluator.evaluate(fraction, item, endValue!![index]) as Int
            }.toIntArray()
        }*/
    }
}