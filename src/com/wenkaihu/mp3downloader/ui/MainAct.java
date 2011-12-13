package com.wenkaihu.mp3downloader.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.wenkaihu.mp3downloader.CONST;
import com.wenkaihu.mp3downloader.R;

public class MainAct extends Activity {

	private Button mbtn;
	private AutoCompleteTextView autotv;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        initViews();
    }

	private void initViews() {

        mbtn = (Button) findViewById(R.id.search_button);
        autotv = (AutoCompleteTextView) findViewById(R.id.search_box);
        mbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String keyword;
				try {
					keyword = URLEncoder.encode(autotv.getText().toString().trim(), CONST.ENCODING);
					if (keyword == null || keyword.equals("")){
						Toast.makeText(MainAct.this, R.string.null_search_keyword, Toast.LENGTH_SHORT).show();
					}else{
						startActivity(new Intent(MainAct.this, ResultsAct.class).putExtra(CONST.EXTRA_KEY_WORD, keyword));
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		});
        //TODO: add the suggestion when you input the keyword
	}
}