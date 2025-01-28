package crud_oper;

public class Record {
    private String name;
    private int Id;
    private Long Ph_no;

    public Record() {
    }

    public Record(String name, int Id, Long Ph_no) {
        this.name = name;
        this.Id = Id;
        this.Ph_no = Ph_no;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Long getPh_no() {
        return Ph_no;
    }

    public void setPh_no(Long ph_no) {
        this.Ph_no = ph_no;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", Ph_no=" + Ph_no +
                '}';
    }
}
