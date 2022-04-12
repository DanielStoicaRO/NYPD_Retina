package retina.nypd.entities;


public class OffensesCount {

    private final int KY_CD;
    private final Long count;

    public OffensesCount(int KY_CD, Long count) {
        this.KY_CD = KY_CD;
        this.count = count;
    }

    public int getKY_CD() {
        return KY_CD;
    }

    public Long getCount() {
        return count;
    }
}