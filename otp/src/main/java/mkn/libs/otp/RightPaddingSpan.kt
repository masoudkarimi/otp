package mkn.libs.otp

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.ReplacementSpan

class RightPaddingSpan(private val mPadding: Int) : ReplacementSpan() {
    override fun getSize(
        paint: Paint,
        text: CharSequence,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {
        val widths = FloatArray(end - start)
        paint.getTextWidths(text, start, end, widths)
        val sum = widths.sumBy {
            it.toInt()
        }
        return sum + mPadding
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        canvas.drawText(text, start, end, x, y.toFloat(), paint)
    }
}