package hotel;

public class RoomInfo {
    private int RoomNumber; //방번호
    private String Name;      //고객 이름
    private int PhoneNumber;// 고객 전화번호
    private String payment; // 결제 상태
    private int roomUserNum;// 인원 수
    private Boolean checkIO; // 체크인/아웃 상태

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getRoomUserNum() {
        return roomUserNum;
    }

    public void setRoomUserNum(int roomUserNum) {
        this.roomUserNum = roomUserNum;
    }

    public Boolean getCheckIO() {
        return checkIO;
    }

    public void setCheckIO(Boolean checkIO) {
        this.checkIO = checkIO;
    }
    
}
