package hanhan.demo.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("身份证实体类")
public class IdCard {
    @ApiModelProperty("身份证唯一标识")
    private int iId;
    @ApiModelProperty("姓名")
    private String iName;
    @ApiModelProperty("身份证号码")
    private String iCode;
    @ApiModelProperty("地址")
    private String iAddress;

    public IdCard() {
    }

    public IdCard(String iCode, String iAddress) {
        this.iCode = iCode;
        this.iAddress = iAddress;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "iId=" + iId +
                ", iCode='" + iCode + '\'' +
                ", iAddress='" + iAddress + '\'' +
                '}';
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiCode() {
        return iCode;
    }

    public void setiCode(String iCode) {
        this.iCode = iCode;
    }

    public String getiAddress() {
        return iAddress;
    }

    public void setiAddress(String iAddress) {
        this.iAddress = iAddress;
    }
}
