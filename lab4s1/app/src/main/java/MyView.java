import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by noel1 on 2018-05-10.
 */
public class MyView extends View {
    float x, y;
    Canvas canvas;
    public MyView(Context context) {
        super(context);
    }
    public void onDraw(Canvas ca) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint pnt = new Paint();
        pnt.setColor(Color.RED);
        pnt.setStrokeWidth(5);
        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawPoint(x, y,pnt);
//canvas.drawRect(a,a,a,a,pnt)
    }


    public boolean onTouchEvent(MotionEvent event) {

        x = (int) event.getX();
        y = (int) event.getY();

        invalidate();
        return true;
    }
}
