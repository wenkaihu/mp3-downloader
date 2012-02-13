package com.wenkaihu.mp3downloader.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.wenkaihu.mp3downloader.CONST;
import com.wenkaihu.mp3downloader.R;
import com.wenkaihu.mp3downloader.action.SuggestAction;

public class MainAct extends Activity {

	private Button mbtn;
	private AutoCompleteTextView autotv;
	private int mSearchEngine = CONST.ID_SE_BAIDU;
	private SuggestTask suTask;
	private String[] suggestions = {};
	
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
						startActivity(new Intent(MainAct.this, ResultsAct.class).putExtra(CONST.EXTRA_KEY_WORD, keyword).putExtra(CONST.EXTRA_SEARCH_ENGINE, mSearchEngine));
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		});
        mbtn.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				showDialog(0);
				return false;
			}
		});
        autotv.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (s.toString().trim().equals("")) return ;
				if (suTask != null){
					suTask.cancel(true);
					suTask = null;
				}
				suTask = new SuggestTask();
				suTask.execute(s.toString());
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
        autotv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, suggestions));
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		return new AlertDialog.Builder(this)
        .setTitle(R.string.search_engine_select)
        .setItems(R.array.search_engine, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	mSearchEngine = which;
            	mbtn.setText(getResources().getStringArray(R.array.search_engine)[which]);
            }
        }).create();
	}
	
	class SuggestTask extends AsyncTask<String, Object, String[]>{
		@Override
		protected String[] doInBackground(String... params) {
			return new SuggestAction(mSearchEngine).getSuggestion(params[0]);
		}
		@Override
		protected void onPostExecute(String[] result) {
			suggestions = result;
			autotv.setAdapter(new ArrayAdapter<String>(MainAct.this, android.R.layout.simple_dropdown_item_1line, suggestions));
			super.onPostExecute(result);
		}
		
	}
}