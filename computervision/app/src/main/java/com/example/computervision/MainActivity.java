package com.example.computervision;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.*;
import java.lang.Object.*;
import java.util.Objects;

import android.app.*;
import android.content.*;
import android.net.*;
import android.view.*;
import android.graphics.*;
import android.widget.*;
import android.provider.*;
import com.microsoft.projectoxford.face.*;
import com.microsoft.projectoxford.face.contract.*;


public class MainActivity extends AppCompatActivity {
    //endpoint
    private final String apiEndpoint = System.getenv("https://ceranfaceapi.cognitiveservices.azure.com/");
    // Add your Face subscription key to your environment variables.
    private final String subscriptionKey = System.getenv("153049311c3149938a6f9c0d25194625");

    private final FaceServiceClient faceServiceClient =
            new FaceServiceRestClient("https://faceappdetect.cognitiveservices.azure.com/","ad3fdf15e0a746dba91fabd44b4c725f");

    private final int PICK_IMAGE = 1;
    private ProgressDialog detectProgressBar;
    Button button;
    Face[] result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detectProgressBar = new ProgressDialog(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE && data.getData() != null){
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
                detectAndFrame(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    //Till now Image is selected
    //Detect faces by uploading a face image
    private void detectAndFrame(final Bitmap imageBitmap){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        AsyncTask<InputStream,String,Face[]> detectTask = new AsyncTask<InputStream, String, Face[]>() {
            String exceptinMessage = "";
            @Override
            protected Face[] doInBackground(InputStream... params) {
                try{
                    publishProgress("Detecting....");
                     result = faceServiceClient.detect(params[0],true,false,null);
                    if(result == null){
                        publishProgress("Detection Finished. Nothing detected");
                        return null;
                    }
                    publishProgress(String.format("Detection Finished.%d face(s) detected",result.length));
                    return result;


                }catch (Exception e){
                    exceptinMessage = String.format("Detection Failed: %s",e.getMessage());
                    return null;

                }

            }

            @Override
            protected void onPreExecute() {
                detectProgressBar.show();
            }

            @Override
            protected void onPostExecute(Face[] faces) {
                detectProgressBar.dismiss();
                if(!exceptinMessage.equals("")){
                    Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
                    showError(exceptinMessage);
                }
                if(result == null) return;
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(drawFaceRectangleonBitmap(imageBitmap,result));
                imageBitmap.recycle();

            }

            @Override
            protected void onProgressUpdate(String... values) {
                detectProgressBar.setMessage(values[0]);
            }
        };
        detectTask.execute(inputStream);
    }
    private static Bitmap drawFaceRectangleonBitmap(Bitmap originalBitmap,Face[] faces){
        Bitmap bitmap = originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        if(faces != null){
            for(Face face : faces){
                FaceRectangle faceRectangle = face.faceRectangle;
                canvas.drawRect(faceRectangle.left,
                        faceRectangle.top,
                        faceRectangle.left+faceRectangle.width,
                        faceRectangle.top+faceRectangle.height,paint);
            }
        }
        return bitmap;


    }
    private void showError(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }})
                .create().show();
    }
}