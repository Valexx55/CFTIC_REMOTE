package com.example.vale.httpimagen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

//import com.example.vale.asyntaskvsservice.R;

public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       if (null!=savedInstanceState)
        {
            bitmap = savedInstanceState.getParcelable ("img");
        }
            else {

                    try
                        {
                            bitmap = new DescargaImagenes().execute("http://www.hrsanroque.com/galeria/slider/18.jpg").get();
                        }
                    catch (Throwable t)
                        {
                            Log.d(getClass().getCanonicalName(), "Error descargando la imagen", t);
                        }
                }

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageBitmap(bitmap);


      /*  Bitmap bitmap1 = null;

        bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        new UpLoadImage().execute(bitmap1);
*/

    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putParcelable ("img", bitmap);
    }
}
