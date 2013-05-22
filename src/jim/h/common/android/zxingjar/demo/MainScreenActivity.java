package jim.h.common.android.zxingjar.demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;


public class MainScreenActivity extends Activity{

        
        protected boolean _active = true;
        protected int _splashTime = 3000; // time to display the splash screen in ms
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.splash);
                
                Thread splashTread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            int waited = 0;
                            while(_active && (waited < _splashTime)) {
                                sleep(100);
                                if(_active) {
                                    waited += 100;
                                }
                            }
                        } catch(InterruptedException e) {
                            // do nothing
                        } finally {
                            finish();
                            startActivity(new Intent("jim.h.common.android.zxingjar.demo.HvaSkjer"));
                            minStop();
                        }
                    }
                };
                splashTread.start();
        }
        
        public void minStop() {
            _active = false;
        }
        
      //Function that will handle the touch
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                _active = false;
            }
            return true;
        }
}
