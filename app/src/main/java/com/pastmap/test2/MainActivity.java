package com.pastmap.test2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mapbox.mapboxsdk.views.MapView;

public class MainActivity extends Activity {
    private MapView mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        this.findViewById(R.id.mapview);

        setContentView(R.layout.activity_main);

        mv = (MapView) findViewById(R.id.mapview);
        mv.setMinZoomLevel(mv.getTileProvider().getMinimumZoomLevel());
        mv.setMaxZoomLevel(mv.getTileProvider().getMaximumZoomLevel());
        mv.setCenter(mv.getTileProvider().getCenterCoordinate());
        mv.setZoom(6);
//        currentMap = getString(R.string.streetMapId);

        // Show user location (purposely not in follow mode)
        mv.setUserLocationEnabled(true);

        mv.loadFromGeoJSONURL("https://a.tiles.mapbox.com/v4/pastmap.a975105a/features.json?access_token=pk.eyJ1IjoicGFzdG1hcCIsImEiOiI4ZDllNmEwMmU1ZDI1NDMyMTVlMmExNWZjYzMxYTIzZCJ9.fAXQRMv-wedtVViRn8hDbw");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
