package com.example.fuffy.ee461lhomework4;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String loc = "";

    public MapFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        MapView gMapView = view.findViewById(R.id.soleViewMap);
        gMapView.onCreate(savedInstanceState);
// SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        Button enter = view.findViewById(R.id.enter_location_button_maps_location_fragment);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        Button web = view.findViewById(R.id.location_web_button);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loc = loc.replace(" ", "_");
                String url = "https://en.wikipedia.org/wiki/" + loc;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        gMapView.getMapAsync(this);
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void resetText(Address a){
        StringBuilder newText = new StringBuilder();
        newText.append("Location Info \n\n");
        newText.append("Country: ");
        newText.append(a.getCountryName() + "\n");

        newText.append("Address: ");
        for(int i = 0; i<a.getMaxAddressLineIndex(); i++) {
            newText.append(a.getAddressLine(i) + "\n");
        }

        TextView textView = getView().findViewById(R.id.first_extra_credit_location_fragment);
        textView.setText(newText);
    }


    public void search()  {
        EditText location = getView().findViewById(R.id.location_text_box_maps_location_fragment);
        String loc = location.getText().toString();
        this.loc = loc;
        try {
            if (loc != null || !loc.equals("")) {
                mMap.clear();
                Geocoder geocoder = new Geocoder(getContext());
                List<Address> addressList = geocoder.getFromLocationName(loc, 1);
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
                //mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                resetText(address);
            }
        }
        catch(Exception e){

        }
    }
}
