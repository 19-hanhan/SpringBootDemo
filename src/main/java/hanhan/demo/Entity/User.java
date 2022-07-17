package hanhan.demo.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户唯一标识")
    private int uId;
    @ApiModelProperty("用户名")
    private String uUsername;
    @ApiModelProperty("用户密码")
    private String uPassword;
    @ApiModelProperty("身份证号")
    private IdCard uIdCard;
    @ApiModelProperty("银行卡号")
    private List<BankCard> uBankCard;
    @ApiModelProperty("关注列表")
    private List<User> follows;
    @ApiModelProperty("粉丝列表")
    private List<User> fans;

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uIdCard='" + uIdCard + '\'' +
                ", uBankCard='" + uBankCard + '\'' +
                '}';
    }

    public User() {
    }

    public User(String uUsername, String uPassword) {
        this.uUsername = uUsername;
        this.uPassword = uPassword;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public IdCard getuIdCard() {
        return uIdCard;
    }

    public void setuIdCard(IdCard uIdCard) {
        this.uIdCard = uIdCard;
    }

    public List<BankCard> getuBankCard() {
        return uBankCard;
    }

    public void setuBankCard(List<BankCard> uBankCard) {
        this.uBankCard = uBankCard;
    }
}
