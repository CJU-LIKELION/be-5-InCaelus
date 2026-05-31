public class Staff extends Member {
    private String role;

    public Staff(String name, String major, int generation, String part, String role) {
        super(name, major, generation, part);
        this.role = role;
    }

    @Override
    public void printDetail() {
        System.out.println("👤 역할: 운영진");
        System.out.printf("📌 이름: %s | 🎓 전공: %s | 🔢 기수: %d | 💻 파트: %s\n",
                getName(), getMajor(), getGeneration(), getPart());
        System.out.println("👔 직책: " + role);
    }
}
