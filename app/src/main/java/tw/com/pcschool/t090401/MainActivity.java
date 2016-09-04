package tw.com.pcschool.t090401;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv2 = (TextView) findViewById(R.id.textView2);
    }

    public void click1(View v)
    {
        MyAsyncTask task = new MyAsyncTask();
        task.execute(5);

    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, Integer>
    {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv2.setText(String.valueOf(values[0]));
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int n = params[0];
            int i;
            for (i=0;i<n;i++)
            {
                try {
                    Thread.sleep(1000);
                    Log.d("TASK", "Sleep:" + i);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("TASK", "finish:" + integer);
            tv2.setText("finish:" + integer);
        }
    }

}

