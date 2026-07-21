public class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;
    private int experience;

    public Resume(String candidateName, T jobRole, int experience) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return candidateName + " | " + jobRole + " | " + experience + " Years";
    }
}