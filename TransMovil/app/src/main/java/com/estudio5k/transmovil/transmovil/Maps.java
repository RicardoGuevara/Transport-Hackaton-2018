package com.estudio5k.transmovil.transmovil;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Maps.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Maps#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Maps extends Fragment implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,GoogleMap.OnMyLocationClickListener {

    TextView ubicacion;
    private Marker marcador;
    double lat;
    double lng;
    double temp1,temp2;
    LatLng pacho,pedro,joaquin,buenos,ocho,catorce,atlantico,chiquinquira,catedra,alfredo,forero,joe,arenosa,parque,abajo;
    Location pacho2,pedro2,joaquin2,buenos2,ocho2,catorce2,atlantico2,chiquinquira2,catedra2,alfredo2,forero2,joe2,arenosa2,parque2,abajo2;

    GoogleMap map;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Maps() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Maps.
     */
    // TODO: Rename and change types and number of parameters
    public static Maps newInstance(String param1, String param2) {
        Maps fragment = new Maps();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ubicacion=(TextView)view.findViewById(R.id.Ubicacion);



        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        map.setMyLocationEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setOnMyLocationButtonClickListener(this);
        LatLng barranquilla = new LatLng(11.011849,-74.808646);

        pacho = new LatLng(10.915247,-74.79922);
        pacho2=new Location("pacho2");
        pacho2.setLongitude(10.915247);
        pacho2.setLongitude(-74.79922);
        map.addMarker(new MarkerOptions().position(pacho).title("Est. Pacho Galan"));
        pedro = new LatLng(10.921185,-74.799265);
        map.addMarker(new MarkerOptions().position(pedro).title("Est. Pedro Ramaya"));
        joaquin = new LatLng(10.932678,-74.799372);
        map.addMarker(new MarkerOptions().position(joaquin).title("Est. Joaquin Barrios Polo"));
        buenos=new LatLng(10.941537,-74.79964);
        map.addMarker(new MarkerOptions().position(buenos).title("Est. Buenos Aires"));
        ocho= new LatLng(10.946562,-74.799847);
        map.addMarker(new MarkerOptions().position(ocho).title("Est. La Ocho"));
        catorce=new LatLng(10.954782,-74.796685);
        map.addMarker(new MarkerOptions().position(catorce).title("Est. La Veintiuna"));
        atlantico= new LatLng(10.968535,-74.790495);
        map.addMarker(new MarkerOptions().position(atlantico).title("Est. Atlantico"));
        chiquinquira=new LatLng(10.976947,-74.787958);
        map.addMarker(new MarkerOptions().position(chiquinquira).title("Est. Chiquinquira"));
        catedra=new LatLng(10.988238,-74.788445);
        map.addMarker(new MarkerOptions().position(catedra).title("Est. La Catedral"));
        alfredo = new LatLng(10.990375,-74.795923);
        map.addMarker(new MarkerOptions().position(alfredo).title("Est. Alfredo Correa de Andreis"));
        forero= new LatLng(10.992468,-74.802465);
        map.addMarker(new MarkerOptions().position(forero).title("Est. Esthercita Forero"));
        joe= new LatLng(10.994694,-74.807882);
        map.addMarker(new MarkerOptions().position(joe).title("Est. Joe Arroyo"));
        arenosa = new LatLng(10.981927,-74.786448);
        map.addMarker(new MarkerOptions().position(arenosa).title("Est. La Arenosa"));
        parque = new LatLng(10.985792,-74.777985);
        map.addMarker(new MarkerOptions().position(parque).title("Est. Parque Cultural del Caribe"));
        abajo = new LatLng(10.98691,-74.783718);
        map.addMarker(new MarkerOptions().position(abajo).title("Est. Barrio Abajo"));





    }



    private void agregarMarcador(double lat,double lng){
        LatLng coordeandas= new LatLng(lat,lng);
        CameraUpdate miUbicacion =CameraUpdateFactory.newLatLngZoom(coordeandas,16);
        if (marcador!=null)marcador.remove();
        marcador=map.addMarker(new MarkerOptions().position(coordeandas).title("Tu posicion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        map.animateCamera(miUbicacion);

    }

    private void actualizarUbicacion(Location location){
        if (location!=null){
            lat=location.getLatitude();
            lng=location.getLongitude();
            agregarMarcador(lat,lng);
        }


    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(getContext(), "entre", Toast.LENGTH_SHORT).show();
        map.setOnMyLocationClickListener(this);
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        temp1=location.getLongitude();
        temp2=location.getLatitude();
        ubicacion.setText(temp1+","+temp2);
        mascercano();

    }

    private void mascercano() {
        int Menor;
        Location mio= new Location("mio");
        mio.setLatitude(temp1);
        mio.setLongitude(temp2);

        int distancia= (int) mio.distanceTo(pacho2);
        Toast.makeText(getContext(), String.valueOf(distancia), Toast.LENGTH_SHORT).show();




    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
