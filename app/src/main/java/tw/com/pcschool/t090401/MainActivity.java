package tw.com.pcschool.t090401;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View v)
    {
        MyAsyncTask task = new MyAsyncTask();
        task.execute(3);

    }


}

class MyAsyncTask extends AsyncTask<Integer, Integer, Integer>
{

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

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
    }
}
