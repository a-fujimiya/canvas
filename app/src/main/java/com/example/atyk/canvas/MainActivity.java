package com.example.atyk.canvas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
  private CanvasView canvasView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    canvasView = (CanvasView) findViewById(R.id.canvas_view);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    switch (id) {
      case R.id.action_clear:
        canvasView.allClear();
        return true;
      case R.id.color_red:
        canvasView.setColor(Color.RED);
        return true;
      case R.id.color_green:
        canvasView.setColor(Color.GREEN);
        return true;
      case R.id.color_blue:
        canvasView.setColor(Color.BLUE);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
