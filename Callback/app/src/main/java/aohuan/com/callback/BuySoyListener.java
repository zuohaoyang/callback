package aohuan.com.callback;

/**
 * 打酱油监听事件
 */
public interface BuySoyListener {
    //派遣一个人去买酱油，还有知道这个人是谁
    void dispatch(String name);
}
