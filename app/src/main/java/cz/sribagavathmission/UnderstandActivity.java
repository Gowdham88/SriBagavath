package cz.sribagavathmission;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by macbook on 28/07/16.
 */
public class UnderstandActivity  extends AppCompatActivity {


    TextView Txt_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.understanding);

        Txt_content = (TextView) findViewById(R.id.txt_content);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/Bamini.ttf");
        Txt_content.setTypeface(font1);

        Txt_content.setText("ஞானம் பெறுவதுதான் மனித வாழ்வின் மிக உயர்ந்த நிலை என்பது அனைவரும் அறிந்ததே.\n" +
                "\n" +
                "அத்தகைய உயர்ந்த நிலையை அடைவது மிக மிகக் கடினமானதாகத்தானே இருக்கும் ?\n" +
                "\n" +
                "கடினமாக்கப்பட்டதால் மட்டுமே கடினமாகிவிட்டது. யோக நிலையையும் ஞானத்தையும் இணைத்துப் பார்த்த காரணத்தால் மட்டுமே இது கடினமாக்கப்பட்டுவிட்டது.\n" +
                "\n" +
                "யோகநிலை என்பது பயிற்சி முயற்சிகளால் சாதிக்க வேண்டிய ஒன்று. பயிற்சி முயற்சிகளுக்கும், ஞானத்துக்கும் எந்தத் தொடர்பும் கிடையாது.\n" +
                "\n" +
                "ஞானத்தை அடைய எந்தப் பயிற்சிகளும் தேவை இல்லை. கால அவகாசம் தேவை இல்லை. காத்திருக்கத் தேவை இல்லை.\n" +
                "\n" +
                "ஞானமடைய என்னதான் தேவை ?\n" +
                "\n" +
                "ஞானம் என்றால் என்ன என்பதை மட்டும் புரிந்து கொண்டால் போதும்.\n" +
                "\n" +
                "உணர்வு பூர்வமாக ஆழமாகப் புரிந்து கொள்ள வேண்டுமா ?\n" +
                "\n" +
                "எந்த ஆழமும் தேவை இல்லை. மிக மேம்போக்காக- புத்தி பூர்வமாகப் புரிந்து கொண்டால் மட்டும் போதும்.\n" +
                "\n" +
                "அறிவின் இயலாமையை அறிவுபூர்வமாகப் புரிந்து கொள்வதுதான் ஞானம்.\n" +
                "\n" +
                "யோகநிலை இன்பத்தை மட்டுமே கொடுக்கும். இன்பம் அனுபவம் ஆகும் அளவுக்கு துன்ப அனுபவங்களும் ஏற்படும். துன்பத்தை வெற்றி கொள்ளும் திறன் ஞானத்துக்கு மட்டுமே உண்டு.\n" +
                "\n" +
                "ஞானப்புரிதல் என்னவென்று புரிந்து கொண்டால், அப்படிப் புரிந்த கணத்திலேயே நீங்களும் ஞானியாகலாம்.");

    }
}
