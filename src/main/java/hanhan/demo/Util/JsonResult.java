package hanhan.demo.Util;

/**
 * 用于生成Json格式的数据类
 * @Author hanhan
 */
public class JsonResult<T> {
    private T data;
    private int code; // 状态码
    private String msg; // 提示信息

    /**
     * 不返回数据默认操作成功
     */
    public JsonResult() {
        code = 200;
        msg = "success";
    }

    /**
     * 支持人为指定状态码与提示信息
     * @param code
     * @param msg
     */
    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 提供了返回的数据则为成功
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        code = 200;
        msg = "success";
    }

    /**
     * 返回数据并自定义提示信息，为正确
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.msg = msg;
        code = 200;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
