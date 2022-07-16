public class yonghu {
    public String name;
    public int tel;
    public int money;

    public yonghu(String name, int tel, int money) {
        this.name = name;
        this.tel = tel;
        this.money = money;
    }

    public yonghu() {
    }

    @Override
    public String toString() {
        return "yonghu{" +
                "name='" + name + '\'' +
                ", tel=" + tel +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
