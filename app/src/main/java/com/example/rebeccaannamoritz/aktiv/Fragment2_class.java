package com.example.rebeccaannamoritz.aktiv;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;

/**
 * Created by rebeccaannamoritz on 25.10.15.
 */
public class Fragment2_class extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    Location location;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // inflate and return the layout
        View fraglayoutv2 = inflater.inflate(R.layout.frag2_layout, null);

        return fraglayoutv2;
        }*/


     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
         // inflate and return the layout
         View v = inflater.inflate(R.layout.frag2_layout, container,
                 false);
         mMapView = (MapView) v.findViewById(R.id.mapView);
         mMapView.onCreate(savedInstanceState);

         mMapView.onResume();// needed to get the map to display immediately

         try {
             MapsInitializer.initialize(getActivity().getApplicationContext());
         } catch (Exception e) {
             e.printStackTrace();
         }

        googleMap = mMapView.getMap();
        googleMap.setMyLocationEnabled(true);

        location = googleMap.getMyLocation();

        if (location != null) {

            // latitude and longitude
            LatLng lat = new LatLng(location.getLatitude(), location.getLongitude());
            //double latitude = 17.385044;
            //double longitude = 78.486671;

            // create marker
            MarkerOptions marker = new MarkerOptions().position(lat).title("Hello Maps");

            // Changing marker icon
            marker.icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

            // adding marker
            googleMap.addMarker(marker);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(lat).zoom(12).build();

            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
        }

             // Perform any camera updates here
             return v;
     }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
