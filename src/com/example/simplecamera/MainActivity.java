package com.example.simplecamera;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity{

	ImageView imgViewer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(com.simplecamera.R.layout.activity_main);
		imgViewer = (ImageView) findViewById(com.simplecamera.R.id.imageView1);
		imgViewer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				open();
				
			}

			
		});
	}
	private void open() {
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 0);
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bmp = (Bitmap) data.getExtras().get("data");
		imgViewer.setImageBitmap(bmp);
	}
	
	
}
