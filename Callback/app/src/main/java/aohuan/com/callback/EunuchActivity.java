package aohuan.com.callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/**
* 太监activity
 * */
public class EunuchActivity extends AppCompatActivity {
    //定义全局接口对象， 当前接口对象为null
    private static BuySoyListener mBuySoyListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eunuch);
    }
    //主要获取接口对象，可以知道当前接口对象是从哪个类中实现的
    //（太监接到皇上电话，保证派人打酱油之后，就给皇上回电话）
    public static void setOnBuySoyListener(BuySoyListener buySoyListener){
        mBuySoyListener = buySoyListener;
    }


    public void publicOnClick(View view) {
        //判断接口对象是否实例过，如果为null就不往下执行，否则空指针（如果皇上没有打电话过来，就不能自作主张的回电话）
        if (mBuySoyListener== null) return;
        switch (view.getId()){
            case R.id.m_btn1:
                //通过接口对象设置参数，并回调到当前接口对象的实例中的重写方法中； 当前代码执行完，立即执行接口对象实例的重写方法中：EmperorActivity（派遣人员之后，回电话告诉皇上，派遣的人员是谁）
                mBuySoyListener.dispatch("张三");
                break;
            case R.id.m_btn2:
                mBuySoyListener.dispatch("李四");
                break;
            case R.id.m_btn3:
                mBuySoyListener.dispatch("王五");
                break;
            case R.id.m_btn4:
                mBuySoyListener.dispatch("赵六");
                break;
        }
    }
}
