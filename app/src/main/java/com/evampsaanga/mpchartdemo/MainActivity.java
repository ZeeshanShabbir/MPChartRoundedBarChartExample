package com.evampsaanga.mpchartdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    String months[] = {"Jan", "Feb", "Mar", "May", "June", "July", "August"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarChart barChart = (BarChart) findViewById(R.id.barChat);
        barChart.setRoundedBarRadius(30);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisLineColor(Color.BLACK);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months[(int) value % months.length];
            }
        });
        xAxis.setEnabled(true);
        xAxis.setDrawGridLines(false);

        YAxis yAxis = barChart.getAxisLeft();
        YAxis yAxis1 = barChart.getAxisRight();
        yAxis.setEnabled(false);
        yAxis1.setEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setFitBars(true);
        barChart.setData(generateBarData());
        barChart.setTouchEnabled(false);
        //barChart.getBarData().setBarWidth(1f);
    }

    private BarData generateBarData() {

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        entries.add(new BarEntry(4f, 70f));
        entries.add(new BarEntry(5f, 60f));
        entries.add(new BarEntry(6f, 60f));
        int[] colors = new int[]{Color.GREEN,
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                Color.WHITE,
                Color.BLACK,
                Color.CYAN};
        BarDataSet set = new BarDataSet(entries, "");
        set.setColors(colors);
        return new BarData(set);
    }
}
