public class BabyLion extends Member {
    private String studentId;

    public BabyLion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public void printDetail() {
        System.out.println("👤 역할: 아기사자");
        System.out.printf("📌 이름: %s | 🎓 전공: %s | 🔢 기수: %d | 💻 파트: %s\n",
                getName(), getMajor(), getGeneration(), getPart());
        System.out.println("🆔 학번: " + studentId);
        System.out.println("📝 과제 제출 가능: ✅ 가능");
    }
}

