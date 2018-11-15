package com.marolix.smarttablayout.apphelper;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.marolix.smarttablayout.model.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by techniche-v1 on 27/9/16.
 */

public class AppConstant {

    public static final String IMG_IDLI_URL = "https://thumbs.dreamstime.com/z/idli-sambar-bowl-white-background-indian-dish-south-favourite-food-rava-semolina-idly-rava-idly-75110315.jpg";
    public static final String IMG_DOSA_URL = "htcustp://previews.123rf.com/images/imagefactory2013/imagefactory20131308/imagefactory2013130800402/21257690-Indian-breakfast-dosa1-served-in-a-plate-Stock-Photo-south.jpg";
    public static final String IMG_IDLI_VADA_URL = "http://indiatravelz.com/wp-content/uploads/2013/01/Idli-and-Vada.jpg";

    public static List<Product> selectedProducts = new ArrayList<Product>();

    public static final LatLngBounds BOUNDS_INDIA = new LatLngBounds(new LatLng(23.63936, 68.14712), new LatLng(28.20453, 97.34466));
    public static final String BASE_URL = "https://stg-shop.aabsweets.in";
    public static final String FILE_URL = BASE_URL + "/files/";
    public static final String FILE_URL_IF_NOT_FOUND = BASE_URL + "/img/";


    public static int lastSelectedAddrsPos = -1;
    public static int lastSelectedPaymentOpt = -1;
    public static String currentLocation = null;
    public static double currLat = 0.0;
    public static double currLng = 0.0;

    public static String selectedAddrsLat = "";
    public static String selectedAddrsLong = "";

    public static String KEY_PASS_DATA = "KEY_PASS_DATA";

    public static boolean is_it_my_addresses_scrn = false;

    public static double totalCartAmount = 0.0;
    public static String paymentOption = null;
//    public static DeliveryAddressModel selectedAddress = null;

    public static String StoreID = null;

    public static String StoreName = null;

    public static String LOGIN_FROM = "NORMAL";

    public static final String CUSTOMER_CARE = "1800 103 6363";

    public static final String PAYMENT_TYPE_WALLET = "PayUmoney";
    public static final String COD = "CashOn";

    // PayUMoney
    public static final String MERCHANT_ID = "5586922"; //"4928174";//
    public static final String MERCHANT_KEY = "MQgKspG6"; //"dRQuiA";//
    public static final String SALT_ID = "lsh7MIBlaM"; //"0nf7";//"
}