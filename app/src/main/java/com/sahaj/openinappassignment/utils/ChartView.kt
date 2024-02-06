package com.sahaj.openinappassignment.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.sahaj.openinappassignment.R

class ChartView(context: Context) : FrameLayout(context) {
    private val lineChart: LineChart

    init {
        LayoutInflater.from(context).inflate(R.layout.chart_layout, this, true)
        lineChart = findViewById(R.id.line_chart)
    }

    fun setChartData(data: LineData, labels: List<String>) {
        lineChart.data = data
        lineChart.invalidate()
        lineChart.apply {
            description.isEnabled = false
            legend.isEnabled = false

            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.textSize = 9f
            xAxis.textColor = 0xFF999CA0.toInt()
            xAxis.valueFormatter = IndexAxisValueFormatter(labels)
            axisLeft.apply {
                textColor = 0xFF999CA0.toInt()
                textSize = 9f
            }
            axisRight.isEnabled = false
        }
    }
}