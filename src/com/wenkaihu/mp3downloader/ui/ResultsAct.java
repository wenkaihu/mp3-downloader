package com.wenkaihu.mp3downloader.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wenkaihu.mp3downloader.CONST;
import com.wenkaihu.mp3downloader.R;
import com.wenkaihu.mp3downloader.action.TrackAction;
import com.wenkaihu.mp3downloader.engine.Mp3SkullEngine;
import com.wenkaihu.mp3downloader.engine.SearchEngine;
import com.wenkaihu.mp3downloader.model.TrackInfo;

public class ResultsAct extends ListActivity {

	private SearchEngine defaultEngine;
	private TrackAction trackAction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_results_list);
		setTitle(R.string.result_title);
		//setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"a", "b"}));
		defaultEngine = new Mp3SkullEngine();
		trackAction = new TrackAction(defaultEngine);
	}

	private List<HashMap<String, String>> tracks = null;
	
	@Override
	protected void onStart() {
		super.onStart();
		final String key_word = getIntent().getExtras().getString(CONST.EXTRA_KEY_WORD);
		if (key_word == null) {
			return ;
		}
		new AsyncTask<Void, Void, Boolean>(){
			private ProgressDialog pd;
			@Override
			protected void onPreExecute() {
				pd = new ProgressDialog(ResultsAct.this);
				pd.setMessage("loading ... ");
				pd.show();
				super.onPreExecute();
			}
			@Override
			protected Boolean doInBackground(Void... params) {
				try {
					tracks = getMaps(trackAction.searchTracks(key_word));
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			@Override
			protected void onPostExecute(Boolean result) {
				pd.dismiss();
				if (tracks == null){
					return ;
				}
				setResultAdapter();
				super.onPostExecute(result);
			}
		}.execute();
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		final int pos = position; 
		new AlertDialog.Builder(this).setMessage("Download ?")
			.setPositiveButton("download", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					downloadTrack(pos);
				}
			})
			.setNegativeButton("cancel", null).show();
		super.onListItemClick(l, v, position, id);
	}
	
	protected void downloadTrack(int position) {
		try {
			trackAction.trackDownload(tracks.get(position).get(CONST.MAP_TRACK_LINK));
//			startActivity(new Intent)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private List<HashMap<String, String>> getMaps(List<TrackInfo> tracks){
		if (tracks == null) return null;
		List<HashMap<String, String>> maps = new ArrayList<HashMap<String,String>>();
		for (TrackInfo track : tracks){
			maps.add(track.getMap());
		}
		return maps;
	}

	private void setResultAdapter(){
		setListAdapter(new SimpleAdapter(this, tracks, R.layout.search_results_list_item, 
				new String[] {CONST.MAP_TRACK_NUMBER, CONST.MAP_TRACK_NAME, CONST.MAP_SINGER, CONST.MAP_FILE_TYPE, CONST.MAP_TRACK_SIZE}, 
				new int[]{R.id.track_number, R.id.track_name, R.id.singer, R.id.track_type, R.id.track_size}));
	}
}
