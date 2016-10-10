package aohuan.com.callback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * 皇上activity
 * */
public class EmperorActivity extends AppCompatActivity {
    private Button mGoEunuch;
    private TextView mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emperor);
        mGoEunuch = (Button) findViewById(R.id.m_go_eunuch);
        mContent = (TextView) findViewById(R.id.m_content);

        //跳转到太监activity（让太监挑选一个人去买酱油）
        mGoEunuch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到太监类，选人打酱油
                startActivity(new Intent(EmperorActivity.this, EunuchActivity.class));
            }
        });

        //设置监听回调,将实例化对象转到太监类，，注意：重点在于实例化后的接口对象，回调主要通过该实例对象来实现回调的
        //(皇上突然想知道是谁打的酱油，打个电话告诉太监，派遣人员之后，再回个电话告诉我是谁去的)
        EunuchActivity.setOnBuySoyListener(new BuySoyListener() {
            @Override
            public void dispatch(String name) {
                //回调回来的参数显示到界面（太监告诉我，派遣谁去打的酱油）
                mContent.setText(name+ "去打的酱油");
            }
        });

    }
}
