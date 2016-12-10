package com.example.atyk.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * drawing on this
 */

public class CanvasView extends View {
  private final List<Path> pathList;
  private final Paint paint;

  /**
   * {@inheritDoc}
   */
  public CanvasView(Context context) {
    super(context);

    pathList = new ArrayList<>();
    paint = new Paint();
    paint.setColor(Color.GREEN);
    paint.setStyle(Paint.Style.STROKE);
    paint.setAntiAlias(true);
    paint.setStrokeWidth(8);
  }

  /**
   * {@inheritDoc}
   */
  public CanvasView(Context context, AttributeSet attrs) {
    super(context, attrs);

    pathList = new ArrayList<>();
    paint = new Paint();
    paint.setColor(Color.GREEN);
    paint.setStyle(Paint.Style.STROKE);
    paint.setAntiAlias(true);
    paint.setStrokeWidth(8);
  }

  @Override protected void onDraw(Canvas canvas) {
    for (Path path : pathList) {
      canvas.drawPath(path, paint);
    }
    invalidate();
  }

  private Path drawingPath;

  @Override public boolean onTouchEvent(MotionEvent event) {
    final int action = event.getAction();
    switch (action) {
      case MotionEvent.ACTION_DOWN:
        drawingPath = new Path();
        drawingPath.moveTo(event.getX(), event.getY());
        pathList.add(drawingPath);
        break;
      case MotionEvent.ACTION_UP:
        drawingPath.moveTo(event.getX(), event.getY());
        break;
      case MotionEvent.ACTION_MOVE:
        drawingPath.lineTo(event.getX(), event.getY());
        break;
      default:
        Log.w("@@@", "action: " + action);
    }
    return true;
  }

  public void setColor(int color) {
    paint.setColor(color);
  }

  public void allClear() {
    pathList.clear();
  }
}
