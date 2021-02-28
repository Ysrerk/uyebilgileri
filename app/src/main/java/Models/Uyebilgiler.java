package Models;

public class Uyebilgiler {
    private String id;
    private String uyeid;
    private String uyeadi;
    private String uyeemail;
    private String uyeresim;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUyeid() {
        return uyeid;
    }

    public void setUyeid(String uyeid) {
        this.uyeid = uyeid;
    }

    public String getUyeadi() {
        return uyeadi;
    }

    public void setUyeadi(String uyeadi) {
        this.uyeadi = uyeadi;
    }

    public String getUyeemail() {
        return uyeemail;
    }

    public void setUyeemail(String uyeemail) {
        this.uyeemail = uyeemail;
    }

    public String getUyeresim() {
        return uyeresim;
    }

    public void setUyeresim(String uyeresim) {
        this.uyeresim = uyeresim;
    }

    @Override
    public String toString() {
        return "Uyebilgiler{" +
                "id=" + id +
                ", uyeid='" + uyeid + '\'' +
                ", uyeadi='" + uyeadi + '\'' +
                ", uyeemail='" + uyeemail + '\'' +
                ", uyeresim='" + uyeresim + '\'' +
                '}';
    }
}
