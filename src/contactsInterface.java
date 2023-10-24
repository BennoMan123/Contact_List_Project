import java.util.Date;

public interface contactsInterface {
    public Date getCreationTime();

    public String getAddress();

    public void setAddress(String address);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public void setName(String firstName, String lastName);

    public String getPhoneNum();

    public void setPhoneNum(String phoneNum);

    public void setBirthday(Date bDayDate);

    public void setBirthday(int month, int day, int year);

    public String getBirthday();

    public void setNotes(String note);

    public void addToNotes(String note);

    public String getNotes();
}
