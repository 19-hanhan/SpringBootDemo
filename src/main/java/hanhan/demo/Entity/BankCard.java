package hanhan.demo.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("银行卡实体类")
public class BankCard {
    @ApiModelProperty("银行卡唯一标识")
    private int bId;
    @ApiModelProperty("银行卡号")
    private String bCode;
    @ApiModelProperty("银行卡密码")
    private String bPassword;
    @ApiModelProperty("银行卡余额")
    private int bBalance;
    @ApiModelProperty("用户唯一标识")
    private User user;

    public BankCard() {
    }

    public BankCard(String bCode, String bPassword) {
        this.bCode = bCode;
        this.bPassword = bPassword;
        bBalance = 0;
    }

    public BankCard(String bCode, String bPassword, int bBalance) {
        this.bCode = bCode;
        this.bPassword = bPassword;
        this.bBalance = bBalance;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "bId=" + bId +
                ", bCode='" + bCode + '\'' +
                ", bPassword='" + bPassword + '\'' +
                ", bBalance=" + bBalance +
                ", user=" + user +
                '}';
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getbPassword() {
        return bPassword;
    }

    public void setbPassword(String bPassword) {
        this.bPassword = bPassword;
    }

    public int getbBalance() {
        return bBalance;
    }

    public void setbBalance(int bBalance) {
        this.bBalance = bBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
