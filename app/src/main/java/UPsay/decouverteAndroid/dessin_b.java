package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class dessin_b extends View {
    float xText, yText;
    Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.emoji);

    Handler timerHandler = new Handler();
    Runnable updateTimerThread = new Runnable() {
        public void run() {
            timerHandler.postDelayed(this, 100);
            invalidate();
        }
    };

    public dessin_b(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        b = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight());
        setXYText(600, 600);
        timerHandler.postDelayed(updateTimerThread, 10);
    }

    public void setXYText(float x, float y) {
        xText = x;
        yText = y;
    }


    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        /*définir la couleur de l'objet de dessin */
        p.setColor(Color.BLACK);
        /*définir son style en remplissage*/
        p.setStyle(android.graphics.Paint.Style.FILL);
        /*dessiner un rectangle qui occupe la totalité du View*/
        canvas.drawRect(0, 0, getWidth(), getHeight(), p);
        /*définir une autre couleur pour dessiner un texte*/
        p.setColor(Color.GREEN);
        /*définir la taille du texte*/
        p.setTextSize(100);
        /*définir le centre du texte comme étant son origine*/
        p.setTextAlign(android.graphics.Paint.Align.CENTER);
        /*dessiner le texte en positionnant son origine au centre du View */
        String texte = "Bonjour MONDE";

        canvas.drawText(texte, xText, yText, p);
        canvas.drawBitmap(b, 200, 200, p);
        Toast.makeText(getContext(), "Il faut saisir une heure",
                Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        xText = event.getX();
        yText = event.getY();
        invalidate();
        return false;
    }
}